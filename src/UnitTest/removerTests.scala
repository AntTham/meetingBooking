package UnitTest

import org.junit.Test
import org.junit.Assert._
import java.text.SimpleDateFormat
import Models.Request
import java.util.Calendar

class removerTests {
  
  val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
  
  val submission = formatter.parse("2011-03-14 10:17:06")
  val submission1 = formatter.parse("2011-03-15 14:57:29")
  val request = formatter.parse("2011-03-17 10:17:06")
  val request1 = formatter.parse("2011-03-17 10:17:06")
  val lateRequest = formatter.parse("2011-03-17 18:17:06")
  
  val rq1 = new Request(submission,"1",request,2)
  val rq2 = new Request(submission,"2",request,2)
  val late = new Request(submission,"1",lateRequest,2)
  
  @Test 
  def sameRequestRemove {
    val a :List[Request] = List(rq1,rq2)
    
    var list = a
    var i = 0
    var length = list.length
    
    while (i < list.length ) {
      var fst = list(i)
      var sec = list(i + 1)
      var cmp1 = fst.requestDate
      var cmp2 = sec.requestDate

      if (cmp1.equals(cmp2)) {

        list = list.take(i+1) ++ list.drop(i + 2)
        length = length - 1
      }
      i = i + 1
    }
    
    val expected = List(rq1)
    assertEquals(expected,list)
  }
  
  @Test
  def OfficeHoursTest {
    val a: List[Request] = List(rq1, rq2,late)
    var list = a

    var x = 0
    var length = list.length
    val c = Calendar.getInstance();
    val endHour = 17
    val endMin = 30

    while (x < length) {
      var date = list(x).requestDate
      c.setTime(date)
      var hour: Int = c.get(Calendar.HOUR_OF_DAY)
      var min: Int = c.get(Calendar.MINUTE)

      if ((hour > endHour) || (hour == endHour && min > endMin)) {
        list = list.take(x) ++ list.drop(x + 1)
        length = length - 1
      }
      x = x + 1
    }
    
    val expected = List(rq1,rq2)
    assertEquals(expected,list)
  }
 

}