import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int date, month, year;

    public Date(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Date() {
        Calendar now = Calendar.getInstance();
        date = now.get(Calendar.DATE);
        month = now.get(Calendar.MONTH) + 1;
        year = now.get(Calendar.YEAR);
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