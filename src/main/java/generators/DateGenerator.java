package generators;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateGenerator extends BaseGenerator<LocalDate> {

    /**
     * Current date
     */
    private LocalDate currentDate;

    /**
     * Max date for generated values
     */
    private LocalDate maxDate;

    /**
     * Type of days which should be returned in getNext() method
     */
    private TypeOfDay typeOfDay;

    public DateGenerator(LocalDate minDate, LocalDate maxDate, TypeOfDay typeOfDay) {
        if (minDate.isBefore(maxDate)) {
            this.currentDate = minDate;
            this.maxDate = maxDate;
        }
        else {
            this.currentDate = maxDate;
            this.maxDate = minDate;
        }
        this.typeOfDay = typeOfDay;
    }

    @Override
    public boolean hasNext() {
        return currentDate.isBefore(maxDate);
    }

    @Override
    public LocalDate getNext() {
        LocalDate result;

        if (hasNext() && typeOfDay == TypeOfDay.ALL) {
            result = currentDate;
            currentDate = currentDate.plusDays(1);
            return result;
        }

        while (hasNext()) {
            result = currentDate;
            currentDate = currentDate.plusDays(1);
            if (TypeOfDay.getTypeOfDay(result) == typeOfDay)
                return result;
        }

        return null;
    }

    /**
     * Enum for a type of a day
     */
    public enum TypeOfDay {
        ALL,        // any days
        WORKING,    // working days
        FREE;       // weekends

        public static TypeOfDay getTypeOfDay(LocalDate date) {
            return date.getDayOfWeek() == DayOfWeek.SATURDAY
                    || date.getDayOfWeek() == DayOfWeek.SUNDAY
                    ? FREE : WORKING;
        }
    }
}
