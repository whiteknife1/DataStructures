import java.util.Scanner;
import java.util.Stack;
/**
 * Created by john_eberling on 12/1/16.
 */
public class PostfixEvaluator {
    private static StringBuilder postfix = new StringBuilder();
    private static Stack<Double> equation = new Stack();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the equation in postfix notation:%n");
        String eq = input.nextLine();
        convertToBuilder(eq);
        postfix.append(")");
        double result = evaluatePostfix();
        System.out.printf("The answer to the equation is %f%n", result);

    }

    public static void convertToBuilder(String eq){
        for(int i=0; i<eq.length(); i++){
            postfix.append(eq.charAt(i));
        }
    }

    public static double evaluatePostfix(){
        int pos = 0;
        double x, y;
        do {
            if (Character.isDigit(postfix.charAt(pos))) {
                equation.push(Double.parseDouble(postfix.substring(pos, pos+1)));
            }

            else if(isOperator(postfix.substring(pos, pos+1))){
                x = equation.pop();
                y = equation.pop();
                equation.push(calculate(x, y, postfix.substring(pos, pos+1)));
            }
            pos++;
        }while(pos<postfix.length());
        return equation.peek();
    }



    public static double calculate(double x, double y, String str){
        if(str.equals("^")){
            return Math.pow(y, x);
        }
        else if(str.equals("/")){
            return y/x;
        }
        else if(str.equals("%")){
            return y%x;
        }
        else if(str.equals("*")){
            return y*x;
        }
        else if(str.equals("+")){
            return y+x;
        }
        else{
            return y-x;
        }
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
}
