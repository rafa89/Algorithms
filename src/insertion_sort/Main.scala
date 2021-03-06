package insertion_sort

//INSERTION-SORT
//1 for j = 2 to A.length
//2 key = A[J]
//3 // Insert A[j] into the sorted sequence A[1 .. j -1] .
//4 i = j -1
//5 while i > 0 and A[i] > key
//6   A[i+1] = A[i]
//7   i = i -1
//8 A[i+1] = key

object Main extends App {
  //  val input = (1 to 10).map(_ => Random.nextInt()).toArray
  val input = Array(5, 2, 4, 6, 1, 3)
  println("insertionSortIncrease \n")
  insertionSortIncrease(input).foreach(println)
  println("insertionSortDecrease \n")
  insertionSortDecrease(input).foreach(println)
  val e1 = Array(1, 0, 0, 0, 1, 1, 1)
  val e2 = Array(0, 0, 1, 0, 1, 1, 0)
  println("binaryAdd \n")
  binaryAdd(e1.reverse, e2.reverse).foreach(println)

  def insertionSortIncrease(input: Array[Int]): Array[Int] = {
    val result = input
    (1 until input.size).foreach { j =>
      var i = j - 1
      val key: Int = result(j)
      while (i >= 0 && result(i) > key) {
        result(i + 1) = result(i)
        i = i - 1
      }
      result(i + 1) = key
    }
    result
  }

  def insertionSortDecrease(input: Array[Int]): Array[Int] = {
    val result = input
    (1 until input.size).foreach { j =>
      var i = j - 1
      val key: Int = result(j)
      while (i >= 0 && result(i) < key) {
        result(i + 1) = result(i)
        i = i - 1
      }
      result(i + 1) = key
    }
    result
  }

  def binaryAdd(e1: Array[Int], e2: Array[Int]): Array[Int] = {
    def sumAt(i: Int): Int =
      if (i < e1.size && i < e2.size)
        e1(i) + e2(i)
      else if (i < e1.size)
        e1(i)
      else e2(i)

    val maxSize: Int = e1.size.max(e2.size)
    val result: Array[Int] = Array.fill[Int](maxSize + 1)(0)
    (0 until maxSize).foreach { i =>
      val sum: Int = result(i) + sumAt(i)
      if (sum > 1) {
        result(i) = sum % 2
        result(i + 1) += 1
      }
      else
        result(i) = sum
    }
    result.reverse
  }


}
