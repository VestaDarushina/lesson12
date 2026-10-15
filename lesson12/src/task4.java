import java.util.Comparator;

public class task4 {
    public static void main(String[] args) {
        RentedFilm film1 = new RentedFilm(
                "Терминатор",
                new DateTime(20, 11, 2021, 10, 0, 0),
                new DateTime(27, 11, 2021, 23, 58, 58)
        );
        System.out.println("Фильм Терминатор взят в аренду: " + film1.getTimeOfRent());
        System.out.println("Фильм должен быть вернут до: " + film1.getTimeOfReturn());


        DateTime today = new DateTime(27, 11, 2021, 23, 58, 59);

        System.out.println("Сегодняшнее число: " + today);

        DateTimeComparator comparator = new DateTimeComparator();
        boolean shouldAlreadyBeReturned = comparator.compare(today, film1.getTimeOfReturn()) > 0;

        System.out.println("Прошло ли время возврата? " + (shouldAlreadyBeReturned ? "Да!" : "Нет!"));
    }
}
class DateTime {
    public final int day;
    public final int month;
    public final int year;

    public final int hours;
    public final int minutes;
    public final int seconds;

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
class RentedFilm {
    private final String name;
    private final DateTime timeOfRent;
    private final DateTime timeOfReturn;

    public RentedFilm(String name, DateTime timeOfRent, DateTime timeOfReturn) {
        this.name = name;
        this.timeOfRent = timeOfRent;
        this.timeOfReturn = timeOfReturn;
    }

    public String getName() {
        return name;
    }

    public DateTime getTimeOfRent() {
        return timeOfRent;
    }

    public DateTime getTimeOfReturn() {
        return timeOfReturn;
    }
}
class DateTimeComparator implements Comparator<DateTime> {

    @Override
    public int compare(DateTime dt1, DateTime dt2) {
        int result = Integer.compare(dt1.year, dt2.year);
        if (result != 0) return result;

        result = Integer.compare(dt1.month, dt2.month);
        if (result != 0) return result;

        result = Integer.compare(dt1.day, dt2.day);
        if (result != 0) return result;

        result = Integer.compare(dt1.hours, dt2.hours);
        if (result != 0) return result;

        result = Integer.compare(dt1.minutes, dt2.minutes);
        if (result != 0) return result;

        return Integer.compare(dt1.seconds, dt2.seconds);
    }
}
