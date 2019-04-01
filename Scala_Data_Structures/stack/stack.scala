import scala.language.higherKinds
abstract class StackImpl{
  type Stack[A]
  def empty[A]: Stack[A]
  def size[A](stack: Stack[A]): Int
  def contains[A](stack: Stack[A], key:A): Boolean
  def pop[A](stack: Stack[A]): Stack[A]
  def push[A](stack: Stack[A], item: A): Stack[A]
  def top[A](stack: Stack[A]): A
  def isEmpty[A](stack: Stack[A]): Boolean
  def build[A](items: (A)*): Stack[A]
}


object Stack extends StackImpl{
  type Stack[A] = List[A]

  def empty[A]: Stack[A] = List.empty[A]

  def size[A](stack: Stack[A]): Int =stack.size

  def contains[A](stack: Stack[A], key:A): Boolean = {
    if(stack.isEmpty) false
    else if(stack.head == key) true
    else contains(stack.tail, key)
  }

  def pop[A](stack: Stack[A]): Stack[A] = {
    stack.tail
  }

  def push[A](stack: Stack[A], item: A): Stack[A] = {
    item::stack
  }

  def top[A](stack: Stack[A]): A = {
    return stack.head
  }

  def isEmpty[A](stack: Stack[A]): Boolean={
    stack.isEmpty
  }

  def build[A](items: (A)*): Stack[A] = {
    var stack: Stack[A] = List.empty
    for(a <- items){
      stack = push(stack, a)
    }
    stack
  }
}

import Stack._

val stack: Stack[Int] = build(1, 2, 3, 4, 5, 6, 7, 8)
push(stack, 8)
pop(stack)
top(stack)
contains(stack, 19)
contains(stack, 5)
size(stack)
val stack2 : Stack[String] = build("h", "e", "l", "l", "o")
