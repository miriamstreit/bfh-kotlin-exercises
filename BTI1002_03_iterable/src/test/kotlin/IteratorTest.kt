/** Programming 1 with Kotlin - HS 19/20,
 *  Computer Science, Bern University of Applied Sciences */

package iterator

import DigitsIterator
import StringIterator
import StringListIterator
import StringTableIterator
import Iterator

fun main() {
  val iterators = ArrayList<Iterator>()

  // StringIterator
  iterators.add(StringIterator("Hello"))
  iterators.add(StringIterator("World"))
  iterators.add(StringIterator(""))

  // StringListIterator
  val strings = ArrayList<String>()
  strings.add("Hello")
  strings.add("World")
  iterators.add(StringListIterator(strings))

  // StringTableIterator
  val strTable = arrayOf(
    arrayOf("Hello", "World", "!"),
    arrayOf("Hallo", "Welt"),
    arrayOf("Bonjour", "Monde")
  )
  iterators.add(StringTableIterator(strTable))


  // DigitsIterator
  iterators.add(DigitsIterator())

  // Loop over all iterators
  for (i in 1..2) {
    println("**** Round $i ****")
    for (iterator in iterators) {
      println("** " + iterator.javaClass.simpleName + " **")
      while (iterator.hasNext()) {
        println(iterator.next())
      }
      try {
        println(iterator.next())
      } catch (e: NoSuchElementException) {
        println(e)
      }
      iterator.reset()
    }
  }
}