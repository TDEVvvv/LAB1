package main;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;


// 4:44
public class Buteelt {
	static int getWorkingDays(LocalDate start, LocalDate end){
	    return (int)start.datesUntil(end)
	      .map(LocalDate::getDayOfWeek)
	      .filter(day -> !Arrays.asList(DayOfWeek.SATURDAY,DayOfWeek.SUNDAY).contains(day))
	      .count();
	    
	}
	static int getWorkingDaysWithSaturday(LocalDate start, LocalDate end){
	    return (int)start.datesUntil(end)
	      .map(LocalDate::getDayOfWeek)
	      .filter(day -> !Arrays.asList(DayOfWeek.SUNDAY).contains(day))
	      .count();
	    
	}
	private static int calcLessonDuration(int days,int lessonDay,int duration) {
		return (days*duration*lessonDay);
	}
	private static int calcLessonDurationWeek(long week,int weekLesson,int duration) {
		return (int)(week*weekLesson)*duration;
	}
	private static int calcInternDuration2(int workDay,int duration) {
		return 8*workDay*duration*8*4;
	}
	private static int calcInternDuration1(int duration1,int duration2) {
		return 5*((5*duration1+duration2)*8*60);
	}
	
	private static int calcWeeks(LocalDate start, LocalDate end) {
	    int totalWeeks = 0;
	    for (int i = start.getYear(); i < end.getYear(); i++) {
	            totalWeeks = (int) ChronoUnit.WEEKS.between(LocalDate.of(i, 9, 1), LocalDate.of(i + 1, 5, 31));
	            System.out.println(i+" - "+(i+1));
	            System.out.println("Weeks : "+totalWeeks);
	            System.out.println("--------------------------------");
	            totalWeeks =+ totalWeeks; 
	    }
	    return totalWeeks;
	}
	public static void main(String[] args) {
     // Period 1: 1-3
        LocalDate firstStartPeriod1 = LocalDate.of(1978, 9, 1);
        LocalDate firstEndPeriod1 = LocalDate.of(1981, 5, 31);
     // Period 1: 4-8
        LocalDate secondStartPeriod1 = LocalDate.of(1981, 9, 1);
        LocalDate secondEndPeriod1 = LocalDate.of(1986, 5, 31);
     // Period 1: 9-10
        LocalDate thirdStartPeriod1 = LocalDate.of(1986, 9, 1);
        LocalDate thirdEndPeriod1 = LocalDate.of(1988, 5, 31);
     // Period 1: oyutan 1-5
        LocalDate fourthStartPeriod1 = LocalDate.of(1988, 9, 1);
        LocalDate fourthEndPeriod1 = LocalDate.of(1993, 5, 31);
        int totalDays1Period1=calcWeeks(firstStartPeriod1,firstEndPeriod1);
        int totalDays2Period1=calcWeeks(secondStartPeriod1,secondEndPeriod1);
        int totalDays3Period1=calcWeeks(thirdStartPeriod1,thirdEndPeriod1);
        long allWeek1=totalDays1Period1+totalDays2Period1+totalDays3Period1;
        
        int workDays1Period1=getWorkingDaysWithSaturday(firstStartPeriod1,firstEndPeriod1);
        int workDays2Period1=getWorkingDaysWithSaturday(secondStartPeriod1,secondEndPeriod1);
        int workDays3Period1=getWorkingDaysWithSaturday(thirdStartPeriod1,thirdEndPeriod1);
        int workDays4Period1=getWorkingDaysWithSaturday(fourthStartPeriod1,fourthEndPeriod1);
        
        int test=getWorkingDaysWithSaturday(LocalDate.of(1979,9,1),LocalDate.of(1980, 6, 1));
        System.out.println("Test : "+test);
        
        int firstPeriod1=calcLessonDuration(workDays1Period1,4,45);
        
        int secondPeriod1=calcLessonDurationWeek(totalDays2Period1,34,45);
        
        int thirdPeriod1=calcLessonDuration(workDays3Period1,6,45);
        
        int fourthPeriod1=calcLessonDuration(workDays4Period1,3,90);
        
        int period1=firstPeriod1+secondPeriod1+thirdPeriod1+fourthPeriod1;

        int interestLessonPeriod1=calcLessonDurationWeek(allWeek1,4,45);
        
        int internDurationPeriod1=calcInternDuration1(8,6);
        
        
     // Period 2: 1-5
        LocalDate firstStartPeriod2 = LocalDate.of(2006, 9, 1);
        LocalDate firstEndPeriod2 = LocalDate.of(2011, 5, 31);
        
     // Period 2: 6-12
        LocalDate secondStartPeriod2 = LocalDate.of(2011, 9, 1);
        LocalDate secondEndPeriod2 = LocalDate.of(2018, 5, 31);
        
     // Period 2: oyutan 1-4
        LocalDate thirdStartPeriod2 = LocalDate.of(2018, 9, 1);
        LocalDate thirdEndPeriod2 = LocalDate.of(2022, 5, 31);
        
        int totalDays1Period2=calcWeeks(firstStartPeriod2,firstEndPeriod2);
        int totalDays2Period2=calcWeeks(secondStartPeriod2,secondEndPeriod2);
        
        int workDays1Period2=getWorkingDays(firstStartPeriod2,firstEndPeriod2);
        int workDays2Period2=getWorkingDays(secondStartPeriod2,secondEndPeriod2);
        int workDays3Period2=getWorkingDays(thirdStartPeriod2,thirdEndPeriod2);
        long allWeek2=totalDays1Period2+totalDays2Period2;
        
        int firstPeriod2=calcLessonDuration(workDays1Period2,4,30);
        
        int secondPeriod2=calcLessonDuration(workDays2Period2,6,35);
        
        int thirdPeriod2=calcLessonDuration(workDays3Period2,3,90);
        
        System.out.println("2018-2022 --------------------------------"+thirdPeriod2);
        
        int interestLesson1Period2=calcLessonDurationWeek(totalDays1Period2,4,30);
        
        int interestLesson2Period2=calcLessonDurationWeek(totalDays2Period2,4,35);
        
        int internDurationPeriod2=calcInternDuration2(5,60);
        
        int period2=firstPeriod2+secondPeriod2;
        

        System.out.println("--------------------------------");
        System.out.println("1978-1988 (high school) "+period1);
        System.out.println("2006-2018 (high school) "+period2);
        if (period1 > period2) {
        	
            System.out.println("1978-1993 (high school) year was longer lesson duration.");
        } else if (period1 < period2) {
            System.out.println("2006-2022 (high school) year was longer lesson duration.");
        } else {
            System.out.println("It was equal (high school).");
        }
        System.out.println("--------------------------------");
        System.out.println("1988-1993 (university) "+fourthPeriod1);
        System.out.println("2018-2022 (university) "+thirdPeriod2);
        
        if (fourthPeriod1 > thirdPeriod2) {
            System.out.println("1978-1993 (university) year was longer lesson duration.");
        } else if (fourthPeriod1 < thirdPeriod2) {
            System.out.println("2006-2022 (university) year was longer lesson duration.");
        } else {
            System.out.println("It was equal.");
        }
        System.out.println("--------------------------------");
        System.out.println("1978-1993 year");
        System.out.println("Interest lesson : "+ interestLessonPeriod1);
        System.out.println("2006-2022 year");
        System.out.println("Interest Lesson : "+ (interestLesson1Period2+interestLesson2Period2));
        System.out.println("--------------------------------");
        System.out.println("1978-1993 year");
        System.out.println("Intern percentage : "+ (internDurationPeriod1*100/fourthPeriod1));
        System.out.println("2006-2022 year");
        System.out.println("Intern percentage : "+ (internDurationPeriod2*100/thirdPeriod2));
        
        System.out.println(getWorkingDays(LocalDate.of(2018,9,1),LocalDate.of(2019, 5, 31))-40);
    };
	//20:05
}
