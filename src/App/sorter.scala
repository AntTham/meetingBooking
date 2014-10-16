package App
import Models.Request
import java.text.SimpleDateFormat

class sorter {

  //method sorts Request by the requested time.
  //selection sort. 
  def sortByRequestTime(a: Array[Request]): Array[Request] = {

    for (x <- 0 to (a.length - 1)) {
      var index = x
      for (j <- (x + 1) to (a.length - 1)) {

        var date1 = a(j).requestDate
        var date2 = a(index).requestDate

        if (date1.before(date2)) {
          index = j
        } else if (date1.equals(date2)) { 			//if same time slot is requested
          var subDate1 = a(j).submissionDate 		//Check who requested the slot first
          var subDate2 = a(index).submissionDate
          if (subDate1.before(subDate2)) {
            index = j
          }
        }
      }
      var earilerDate = a(index)
      a(index) = a(x)
      a(x) = earilerDate
    }
    return a
  }

  //convert Array to list.
  def toList[Request](array: Array[Request]): List[Request] = {
    if (array == null || array.length == 0) 
      Nil
    else if (array.length == 1) 
      List(array(0))
    else 
      array(0) :: toList(array.slice(1, array.length))
  }

}