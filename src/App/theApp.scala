package App

import Models.Request
import java.util.Date
import java.text._
import java.text.DateFormat._
import java.util.Calendar

object theApp {

  def main(args: Array[String]) {

    //getting data from "database"
    val input = new data()
    val array: Array[Request] = input.getInputs()
    
    //declaring the sorter, remover and date handler to manipulate the inputs
    val sort: sorter = new sorter
    val remove: remover = new remover
    val dateHandler: dateTimeHandler = new dateTimeHandler
    
    //sorting and removing conflicting requests
    var sortedArray = sort.sortByRequestTime(array)
    var sortedList = sort.toList[Request](array)
    sortedList = remove.removeSameRequests(sortedList)
    
    //removing bookings exceeding office hours
    for(i <- 0 to sortedList.length -1){
      var request = sortedList(i)
      sortedList = dateHandler.addDuration(sortedList,i,request)
    }
    sortedList = remove.removenonOfficeHrs(sortedList)

    //TODO remover.removeOverLap    remover.scala
    
    
    //prints out in the required style
    var i = 0
    var x = 0
    while (i < sortedList.length - 1) {
      var printDate = sortedList(x).requestDate
      var printDateSt = dateHandler.getDateString(printDate)

      var theDate = sortedList(i).requestDate
      var theDateSt = dateHandler.getDateString(theDate)

      if (printDateSt.equals(theDateSt)) {
        println(printDateSt)
        for (index <- 0 to sortedList.length - 1) {
          var rqDate = sortedList(index).requestDate
          var rqDateSt = dateHandler.getDateString(rqDate)

          if (theDateSt.equals(rqDateSt))
            println(dateHandler.getTimeString(rqDate) + " " + sortedList(index).duration + "hours " + sortedList(index).empID)
            
        }
        i = i + 1
        x = x + 1
        println()
      }
    }

  }
}