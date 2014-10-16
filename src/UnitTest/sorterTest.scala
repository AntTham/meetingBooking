package UnitTest

import org.junit.Test
import org.junit.Assert._
import java.text.SimpleDateFormat

class sorterTest {
  
  var testList:List[Int] = List(2,5,4,2,9,5,3)
  val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
  
  @Test
  def dateComparisonTest{

	val before = formatter.parse("2011-03-16 10:17:06")
	val after = formatter.parse("2011-04-18 10:17:06")
	val equals = formatter.parse("2011-03-16 10:17:06")
    
	assertTrue(before.before(after))
	assertFalse(before.after(after))
	assertTrue(before.equals(equals))
	
  }

  @Test
  def sortTest {
     var testArray:Array[Int] = Array(2,5,4,2,9,5,3)
     for (x <- 0 to (testArray.length - 1)) {
      var index = x
      for (j <- (x + 1) to (testArray.length - 1)) {

        var date1 = testArray(j)
        var date2 = testArray(index)
        if (date1 < date2) {
          index = j
        }
      }
      var earilerDate = testArray(index)
      testArray(index) = testArray(x)
      testArray(x) = earilerDate

     }
      
      val actual = testArray
      val expected =Array(2,2,3,4,5,5,9)
      assertArrayEquals(expected, actual)
    
  }
  

}