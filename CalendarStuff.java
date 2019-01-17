public class CalendarStuff {
	//is a leap year if divisible by 4 and divisible by 400 (so 1900 is not one)
	public static boolean isLeap(int year) {
	  if (year % 4 != 0) {
	    return false;
	  } else if (year % 400 == 0) {
	    return true;
	  } else if (year % 100 == 0) {
	    return false;
	  } else {
	    return true;
	  }
	}

  //Validity check
  public static boolean isValid (int month, int day, int year){
		if (year > 0){
			if (month >= 1 && month <= 12){
				if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
					if (day >= 1 && day <= 31){
						return true;
					}
				}
				if (month == 2){
					if (isLeap(year) == true && day <= 29 && day >= 1){
						return true;
					}
					else if (isLeap(year) == false && day <= 28 && day >= 1){
						return true;
					}
					else {
						return false;
					}
				}
				else if (day >= 1 && day <= 30){
					return true;
			}
			}
	  else {
			return false;
		}
}
else {
	return false;
}
return false;
}


//is true if dates are valid and the first date is the same or earlier than the second date
	public static boolean inOrder (int month1, int day1, int year1, int month2, int day2, int year2){
		if (isValid(month1, day1, year1) == true && isValid(month2, day2, year2) == true){
			if (year2 < year1){
				return true;
			}
			else if (year1 == year2){
				if (month1 < month2){
					return true;
				}
				else if (month1 == month2){
					if (day1 <= day2){
						return true;
					}
					else if (day1 > day2){
						return false;
					}
				}
			}
			else if (year2 > year1) {
				return false;
			}
		}
		else {
			return false;
		}
  return false;
		}


  public static int daysInMonth(int month, int year){
		switch (month){
			case 4:
			case 6:
			case 9:
			case 11: return 30;

			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: return 31;

			case 2:
			if (isLeap(year) == true){
				return 29;
			}
			else {
				return 28;
			}
			}
		return 0;
		}

	public static void main ( String[] args ) {

	}
}
