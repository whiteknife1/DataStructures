/*I. Sets
    A.Unique
    B.Unordered
    C. Good for checking if something is contained in set
        1. constant time
        2. just returns yes or know
    D. Must have insert, delete, size, union, intersection... functions
    E. implemented with linked list
    F. Use Abstract Data type*/
   
abstract class SetImpl{
  type Set
  def empty: Set
  def contains(set: Set, item: Int): Boolean
  def insert(set: Set, item: Int): Set

}

object ListSet extends SetImpl{
  \\ListSet is a list of unique integers
  \\not required to be sorted or ordered
  type Set = List[Int]
  def empty: Set = List.empty
  def contains(set: Set, item: Int) Booolean ={
    set.contains(item)
  }
  def insert(set: Set, item: Int): Set ={
    if(set.contains(item)) set
    item :: set
  }
  def build(items: Int*): Set = {
    items.distinct.toList
  }
}

import ListSet._
set = build(1, 2, 45)
