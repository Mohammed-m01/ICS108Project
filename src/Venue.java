import java.util.ArrayList;

public class Venue {
    private  int maxCapacity;
    private int capacity;
    private String location;
    protected int startTime;// These values will be stored as a sum of total minutes.
    protected int endTime;
    protected String ST;
    protected String ET;
    private String date;



    public boolean setDate(String date) {
        String[] dateL = date.split("/");

        if (Integer.parseInt(dateL[1]) > 12 || Integer.parseInt(dateL[0]) >31)
            return false;

        else if (Integer.parseInt(dateL[1]) <=0 || Integer.parseInt(dateL[0]) <=0)
            return false;

        else{
            this.date = date;
            return true;}
    }

    public String getDate() {
        return date;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // NOTE: TIME Should be entered as a string in a 24 format similar to 22:30
    public boolean setStartTime(String startTime, ArrayList<Event> eventlist){
        String[] Time = startTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 * Integer.parseInt(Time[0]);

        for (Event event : eventlist) {
            // Skip checking the current event against itself
            if (event.venue == this) continue;

            // Check if the event is at the same venue AND on the same date
            if (event.venue != null && event.venue.getClass() == this.getClass() && this.date.equals(event.venue.getDate())) {

                // If the new start time falls inside an already scheduled event
                if (TotalInMin >= event.venue.startTime && TotalInMin <= event.venue.endTime) {
                    System.out.println("Overlap detected with another event on this date... Input different time \nENTER NEW VALUE :");
                    return false;
                }
            }
        }

        ST = startTime;
        this.startTime = TotalInMin;
        return true;
    }

    public boolean setEndTime(String endTime, ArrayList<Event> eventlist){
        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 * Integer.parseInt(Time[0]);

        if (!validateTime(TotalInMin)) {
            System.out.println("Wrong Time...endTime must be after start\nENTER NEW VALUE :");
            return false;
        }

        for (Event event : eventlist) {
            if (event.venue == this) continue;

            if (event.venue != null && event.venue.getClass() == this.getClass() && this.date.equals(event.venue.getDate())) {

                // If the new end time falls inside an already scheduled event
                if (TotalInMin > event.venue.startTime && TotalInMin <= event.venue.endTime) {
                    System.out.println("Overlap detected with another event on this date... Input different time \nENTER NEW VALUE :");
                    return false;
                }

                // If the new event completely swallows/envelops an existing event
                if (this.startTime <= event.venue.startTime && TotalInMin >= event.venue.endTime) {
                    System.out.println("Overlap detected... Input different time \nENTER NEW VALUE :");
                    return false;
                }
            }
        }

        ET = endTime;
        this.endTime = TotalInMin;
        return true;
    }

    // To ensure the end is after the start.
    private boolean validateTime(int endTime){
        return endTime - startTime >= 0;
    }

    public boolean setCapacity(int capacity){
        if(capacity > maxCapacity){
            return false;
        }
        else if (capacity <= 0){
            return false;
        }
        else{
            this.capacity = capacity;
            return true;
        }
    }


    @Override
    public String toString(){
        return   "\nLocation:  " + location +"\nCapacity: " + capacity +"\nDate: " + date ;
    }

}
