import java.util.Calendar;

public class FindDayOfWeek {

	public static String findDayOfWeek(int year, int month, int dayOfMonth) {
		Calendar cal = Calendar.getInstance();
		String res = "";

		if (month < 1 || month > 12) {
			return "입력 오류! 달의 범위는 1~12입니다.";
		}else {			
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
		}
		
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (dayOfMonth > maxDay) {
			return "입력 오류! " + year + "년 " + month + "월은 " + maxDay + "일까지입니다.";
		}else {
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);			
		}


		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
			case Calendar.SUNDAY:	res = "일요일";	break;
			case Calendar.MONDAY:	res = "월요일";	break;
			case Calendar.TUESDAY:	res = "화요일";	break;
			case Calendar.WEDNESDAY:	res = "수요일";	break;
			case Calendar.THURSDAY:	res = "목요일";	break;
			case Calendar.FRIDAY:	res = "금요일";	break;
			case Calendar.SATURDAY:	res = "토요일";	break;
		}
		return res;
	}

	// 요일을 배열인덱스로 쓰기 위한 메소드
	public static int get_dayOfWeek_Index(String dayOfWeek) {
		if(dayOfWeek.equals("월요일")) return 0;
		else if (dayOfWeek.equals("화요일")) return 1;
		else if (dayOfWeek.equals("수요일")) return 2;
		else if (dayOfWeek.equals("목요일")) return 3;
		else if (dayOfWeek.equals("금요일")) return 4;
		else if (dayOfWeek.equals("토요일")) return 5;
		else  return 6;
	}
	
	// 입력값이 올바른 입력인지 체크하는 메소드
	public static Boolean check_dayOfWeek(String dayOfWeek) {
		if(dayOfWeek.equals("월요일")) return true;
		else if (dayOfWeek.equals("화요일")) return true;
		else if (dayOfWeek.equals("수요일")) return true;
		else if (dayOfWeek.equals("목요일")) return true;
		else if (dayOfWeek.equals("금요일")) return true;
		else if (dayOfWeek.equals("토요일")) return true;
		else if (dayOfWeek.equals("일요일")) return true;
		else  return false;
	}
}

