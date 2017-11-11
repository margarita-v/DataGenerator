package generators;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.NoSuchElementException;

public class DateGenerator extends BaseGenerator<LocalDate> {

    private LocalDate currentDate;

    private LocalDate maxDate;

    private TypeOfDay typeOfDay;

    public DateGenerator(Date minDate, Date maxDate, TypeOfDay typeOfDay) {
        if (minDate.before(maxDate)) {
            this.currentDate = convertToLocalDate(minDate);
            this.maxDate = convertToLocalDate(maxDate);
        }
        else {
            this.currentDate = convertToLocalDate(maxDate);
            this.maxDate = convertToLocalDate(minDate);
        }
        this.typeOfDay = typeOfDay;
    }

    /**
     * Convert date to local date format
     * @param date Date which will be converted
     * @return Date in the local date format
     */
    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    //region BaseGenerator implementation
    public boolean hasNext() {
        return currentDate.isBefore(maxDate);
    }

    public LocalDate getNext() {
        if (hasNext()) {

            // Return current date and increment its value
            if (typeOfDay == TypeOfDay.ALL) {
                LocalDate result = currentDate;
                currentDate = currentDate.plusDays(1);
                return result;
            }

            // Get date with a correct type of day
            while (hasNext()) {
                currentDate = currentDate.plusDays(1);
                if (TypeOfDay.getTypeOfDay(currentDate) == typeOfDay)
                    return currentDate;
            }
        }
        throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }
    //endregion

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
