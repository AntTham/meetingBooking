package App

import Models.Request
import java.util.Calendar
import java.text.SimpleDateFormat


//This class the given the responsibility to remove unsuccessful bookings
class remover {
  
  val dateHandler: dateTimeHandler = new dateTimeHandler
  
    //removing unsuccessful booking
  def removeSameRequests(a: List[Request]): List[Request] = {
    var list = a
    var i = 0
    var length = list.length
    
    while (i < length - 2) {
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
    return list
  }
	
  //removes request which are not during office hours
  def removenonOfficeHrs(a: List[Request]): List[Request] = {
    var list = a
    var x = 0
    var length = list.length
    val c = Calendar.getInstance();
    val endHour = 17
    val endMin = 30

    while (x < length - 1) {
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
    //method takes list of request with altered datetime stamps. This loop reverts them back 
    for (i <- 0 to list.length - 1) {
      var request = list(i)
      list = dateHandler.minusDuration(list, i, request)
    }
    return list
  }
  
  
  //TODO removes booking requests which overlap with already booked requests
  def removeOverLap(a:List[Request]): List[Request] = {
    return a
  }

}