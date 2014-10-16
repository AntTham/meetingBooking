package App

import Models.Request
import java.util.Calendar
import java.util.Date
import java.text.SimpleDateFormat

class dateTimeHandler {

  val c = Calendar.getInstance();
  val dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
  val timeFormatter = new SimpleDateFormat("HH:mm:ss");
  
  //works out what time the meeting will end
  def addDuration(a: List[Request], index: Int, request: Request): List[Request] = {
    var list = a

    val date = request.requestDate
    c.setTime(date);
    c.add(Calendar.HOUR, request.duration)
    val newRqDate = c.getTime()

    var newRq = new Request(request.submissionDate, request.empID, newRqDate, request.duration)
    val newList = list.updated(index, newRq)

    return newList
  }


  //reverts dates with duration added on back to orginal
  def minusDuration(a: List[Request], index: Int, request: Request): List[Request] = {
    var list = a
    val date = request.requestDate
    c.setTime(date);
    c.add(Calendar.HOUR, -request.duration)
    val newRqDate = c.getTime()

    var newRq = new Request(request.submissionDate, request.empID, newRqDate, request.duration)
    val newList = list.updated(index, newRq)

    return newList
  }

  
  //formatting Dates and Time separately
  def getDateString(d: Date): String = {
    c.setTime(d)
    val date = dateFormatter.format(c.getTime());

    return date
  }

  def getTimeString(d: Date): String = {
    c.setTime(d)
    val time = timeFormatter.format(c.getTime());

    return time
  }

}