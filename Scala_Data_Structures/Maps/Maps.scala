/*I. Maps
    A. Key-value pairs
      Ex. key: "Armor"  value: "1"
          key: "signal" value: "2"
          key: "cyber"  value: "3"
          key: "FA"     value: "10"
    B. Must be unique
    C. Methods
      1. insert
      2. remove
II. Scala Options
  A. Return Type
    1. Some(key) if key is there
    2. None    if key not present
*/

abstract class MapImpl{
  type MapStringToInt
  def empty: MapStringToInt
  def size(map: MapStringToInt): Int
  def insert(map: MapStringToInt, key: String, value: Int): MapStringtoInt
  def isEmpty(map: MapStringToInt): Boolean
  def get(map: MapStringToInt, key: String): Option[Int]
  def getOrElse(map: MapStringToInt, key: String): Option[Int]
  def contains(map: MapStringToInt, key: String): Boolean
}

object ListMap extends MapImpl{
  type MapStringToInt = List[(String,Int)]
  def empty: MapStringToInt = List.empty
  def size(map: MapStringToInt): Int = map.size
  def isEmpty(map: MapStringToInt): Boolean = map.isEmpty
  def get(map: MapStringToInt, key: String): Option[Int]{
    for((k, v) <- map){
      if(k == key) Some(v)
    }
    None
  }
  def getOrElse(map: MapStringtoInt, key: String, dv Int): Int = {
    if(map.isEmpty) dv
    else if(map.head._1 == key) map.head._2
    else GetOrElse(map.tail, key, dv)
  }
  def contains(map: MapStringtoInt, key: String): Boolean = {
    if(map.isEmpty) False
    else(map.head._1 == target || contains(map.tail, key))
  }
}
