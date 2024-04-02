
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Buteelt {
	
	public static int DayOfWeek(int year, int month, int day) {
	    int y = year - (14 - month) / 12;
	    int m = month + 12 * ((14 - month) / 12) - 2;
	    int d = (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
	    return d;
	}
	public static int WorkingDays(int year, int month)
    {
        int workingday = 0;
        int daysInMonth = 31;
        for (int day = 1; day <= daysInMonth; day++)
        {
            int dayOfWeek = DayOfWeek(year, month, day);
            if (dayOfWeek >= 1 && dayOfWeek <= 5)
            {
                workingday++;
            }
        }
        return workingday;
    }
	public static int WorkDay(int startYear, int endYear)
    {
        int ajilsnOdor = 0;
        int ajilsnOdor1 = 0;
        for (int year = startYear; year <= endYear - 1; year++)
        {
            for (int month = 9; month <= 12; month++)
            {
                ajilsnOdor += WorkingDays(year, month);
            }
        }
        for (int year = startYear + 1; year <= endYear; year++)
        {
            for (int month = 1; month <= 5; month++)
            {
                ajilsnOdor1 += WorkingDays(year, month);
            }
        }
        return (ajilsnOdor + ajilsnOdor1);
    }
	
	
	
	public static void Asuult31()
    {
        double dadlaga = 40;
        System.out.println("       - Оюутан 4 н жилийн хугацаанд " + dadlaga * 4 + " хоног дадлага хийнэ");
        double day = WorkDay(2018, 2022) / 7 - 4;
        double hari = ((dadlaga * 4) / (day * 22)) * 100;
        System.out.println("       - Оюутан 4 н жилийн хугацаанд " + day * 22 + " цаг суралцана ");
        System.out.println("       - Оюутан 4 н жилийн хугацаанд дадлага хийсэн цагийн харьцуулалт нь " + hari + "% байна");
    }
	public static void main(String[] args) {
	    int WorkDay = WorkDay(2018, 2022);
	    System.out.println(WorkDay);
	}
	
}