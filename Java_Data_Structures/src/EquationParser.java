import java.util.Stack;
import java.util.Scanner;
/**
 * Created by John Eberling on 11/17/16.
 */
public class EquationParser {
    private static Stack<String> equation = new Stack();
    private static StringBuilder infix = new StringBuilder();
    private static StringBuilder postfix = new StringBuilder();;

    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
        System.out.printf("Please enter an equation:%n");
        String eq = input.nextLine();
        readExpression(eq);
        equation.push("(");
        infix.append(")");
        convertToPostfix();
        System.out.println(postfix);
    }

    public static void readExpression(String eq){
        for(int i=0; i < eq.length(); i++){
            infix.append(eq.charAt(i));
        }
    }

    public static void convertToPostfix(){
        int pos = 0;
        do {
            if(Character.isDigit(infix.charAt(pos))){
                postfix.append(infix.substring(pos, pos+1));
            }

            else if(infix.charAt(pos)=='('){
                equation.push(infix.substring(pos, pos+1));
            }

            else if(isOperator(infix.substring(pos, pos+1))){
                while((precedence(equation.peek(), infix.substring(pos, pos+1)))){
                   postfix.append(equation.pop());
                }
                equation.push(infix.substring(pos, pos+1));
            }

            else if(infix.charAt(pos) == ')'){
                while(!equation.peek().equals("(")){
                    postfix.append(equation.pop());
                }
            }
            pos++;
        } while(pos<infix.length());
    }

    public static boolean isOperator(String str){
        if(str.equals("+")) return true;
        else if(str.equals("-")) return true;
        else if(str.equals("*")) return true;
        else if(str.equals("/")) return true;
        else if(str.equals("^")) return true;
        else if(str.equals("%")) return true;
        return false;
    }

    public static boolean precedence(String str1, String str2){
        int value1, value2;
        if(str1.equals("^")){
            value1 = 5;
        }
        else if(str1.equals("/")||str1.equals("%")||str1.equals("*")){
            value1 =  4;
        }
        else if(str1.equals("+")|| str1.equals("-")){
            value1 = 3;
        }
        else{ return false;}

        if(str2.equals("^")){
            value2 = 5;
        }
        else if(str2.equals("/")||str2.equals("%")||str2.equals("*")){
            value2 =  4;
        }
        else{ value2 = 3;}

        if(value1 >= value2) return true;
        return false;
    }
}


