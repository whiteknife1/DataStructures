import scala.language.higherKinds
import scala.collection.mutable.ArrayBuffer
// front pointer is inclusive
// back pointer is inclusive

abstract class QueueImpl{
  type Queue[A]
  def empty[A]: Queue[A]
  def mkQueue[A](elems: A*): Queue[A]
  def size[A](q: Queue[A]): Int
  // def contains[A](q: Queue[A], key:A): Boolean
  def dequeue[A](q: Queue[A]): Option[A]
  def enqueue[A](q: Queue[A], item: A): Unit
  // def front[A](q: Queue[A]): A
  def isEmpty[A](q: Queue[A]): Boolean
  //  def peek[A](q: Queue[A]): A
  // def fill[A](items: (A)*): Queue[A]
}

object ArrayQueue extends QueueImpl{
  class Queue[A]{
    var buff: ArrayBuffer[Option[A]] = ArrayBuffer.fill(10)(None)
    var front: Int = 0 //Just A Pointer
    var back: Int = -1
    var numElems: Int = 0 //Actual elements in Queue
  }

  def empty[A]: Queue[A] = new Queue[A]

  def mkQueue[A](elems: A*): Queue[A] = {
    var q: Queue[A] = empty[A]
    for(i <- elems) {
      enqueue(q, i)
    }
    q
  }

  def isEmpty[A](q: Queue[A]): Boolean = q.numElems == 0

  def size[A](q: Queue[A]): Int = q.numElems

  def dequeue[A](q: Queue[A]): Option[A] = {
    if(isEmpty(q)) throw new NoSuchElementException("attempted dequeue on an empty queue.")
    else{
      val item = q.buff(q.front)
      q.buff(q.front) = None
      q.front = (q.front+1) % q.buff.length
      q.numElems -= 1
      item
    }
  }

  def enqueue[A](q: Queue[A], item: A): Unit = {
    if(q.numElems == q.buff.length){
      for(i <- 0 until q.numElems){
        q.buff += None
      }
      var temp: Int = 0
      while((temp != q.front)){
        q.buff(q.numElems+temp) = q.buff(temp)
        q.buff(temp) = None
        temp += 1
      }
      q.back = (q.back+q.numElems)%q.buff.length
    }
    q.numElems += 1
    q.back = (q.back+1) % q.buff.length
    q.buff(q.back) = Option(item)

  }
}

/*
import ArrayQueue._

var x = mkQueue("a", "b", "c", "d", "e", "f", "g", "h", "i", "j") 
println(x.buff.length)
println(x.front)
println(x.back)
var w = empty
w.buff
x.buff.foreach(i => println(i))
dequeue(x)
dequeue(x)
enqueue(x, "m")
println(x.back)
enqueue(x, "n")
enqueue(x, "o")
println(x.buff.length)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
dequeue(x)
//enqueue(x, Option("SSS"))
x.front
x.back
x.numElems
isEmpty(x)
size(x)
x.buff(x.front).get
x.buff(x.back).get
/*
