import java.util.Date;
import java.text.SimpleDateFormat;

public class DateClass {
    private int date, month, year;

    public DateClass(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public DateClass() {
        Date todaysDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String todaysDateInString = dateFormatter.format(todaysDate);
        String[] todaysDateAsArray = todaysDateInString.split("/");
        date = Integer.parseInt(todaysDateAsArray[0]);
        month = Integer.parseInt(todaysDateAsArray[1]);
        year = Integer.parseInt(todaysDateAsArray[2]);
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}