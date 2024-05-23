import java.time.DayOfWeek;

public class Timeslot {

    private final int timeslotId;
    private final String timeslot;
    private final DayOfWeek dayOfWeek;
    
    public Timeslot(int timeslotId, String timeslot, DayOfWeek dayOfWeek) {
        this.timeslotId = timeslotId;
        this.timeslot = timeslot;
        this.dayOfWeek = dayOfWeek;
    }
    public int getTimeslotId() {
        return timeslotId;
    }
    public String getTimeslot() {
        return timeslot;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    
}
