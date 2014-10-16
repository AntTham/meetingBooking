package App

import java.text.DateFormat
import java.text.SimpleDateFormat
import Models.Request
import java.util.Calendar
/*
 working under the assumption a Database will store the requested inputs
 and an GUI will be used to receive the inputs
 */

//this class acts at a database with data already stored within it
class data {
	
	//fake database
  	val formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
  	
	//time of submission
	val sub1 = formatter.parse("2011-03-17 10:17:06")
	val sub2 = formatter.parse("2011-03-16 12:34:56")
	val sub3 = formatter.parse("2011-03-16 09:28:23")
	val sub4 = formatter.parse("2011-03-17 11:23:45")
	val sub5 = formatter.parse("2011-03-15 17:29:12")
	//requested meeting time
	val reqDate1 = formatter.parse("2011-03-21 09:00:00")
	val reqDate2 = formatter.parse("2011-03-21 09:00:00")
	val reqDate3 = formatter.parse("2011-03-22 14:00:00")
	val reqDate4 = formatter.parse("2011-03-22 16:00:00")
	val reqDate5 = formatter.parse("2011-03-21 16:00:00")
	//duration of meeting in hours
	val dur1 = 2
	val dur2 = 2
	val dur3 = 2
	val dur4 = 1
	val dur5 = 3
	//employee ID
	val ID1 = "EMP001"
	val ID2 = "EMP002"
	val ID3 = "EMP003"
	val ID4 = "EMP004"
	val ID5 = "EMP005"
	//creating the requests
	val rq1 = new Request(sub1,ID1,reqDate1,dur1)
	val rq2 = new Request(sub2,ID2,reqDate2,dur2)
	val rq3 = new Request(sub3,ID3,reqDate3,dur3)
	val rq4 = new Request(sub4,ID4,reqDate4,dur4)
	val rq5 = new Request(sub5,ID5,reqDate5,dur5)
  	
  	val requests = Array(rq1,rq2,rq3,rq4,rq5)
  	
  	//return the array
  	def getInputs()={
  	  requests
  	}

}