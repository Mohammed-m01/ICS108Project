import java.util.ArrayList;

public class Venue {
    private int maxCapacity;
    private int capacity;
    private String location;
    protected int startTime;// These values will be stored as a sum of total minutes.
    protected int endTime;
    protected String ST;
    protected String ET;
    private String date;


    public boolean setDate(String date) {
        if (!date.contains("/")) {
            return false;
        }
        String[] dateL = date.split("/"); // Ex: If the input (dd/mm) is in the format 23/12, the string will split into "23" and "12"

        if (Integer.parseInt(dateL[1]) > 12 || Integer.parseInt(dateL[0]) >31) // Convert the string to integer, and validate it. Index 1 is for months, Index 0 is for days
            return false;

        else if (Integer.parseInt(dateL[1]) <=0 || Integer.parseInt(dateL[0]) <=0) // Check if non-negative.
            return false;

        else{ // Return the correct date if it passes the checks
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
        if (!startTime.contains(":")) {
            return false;
        }
        String[] Time = startTime.split(":"); // Ex: If the input is 11:30, split it into "11" and "30"
        int TotalInMin = Integer.parseInt(Time[1]) + 60 * Integer.parseInt(Time[0]); // Convert the event's time to minutes for easy comparisons

        for (Event event : eventlist) {
            // Skip checking the current event against itself
            if (event.venue == this) continue;

            // Check if the event is at the same venue AND on the same date
            if (event.venue != null && event.venue.getClass() == this.getClass() && this.date.equals(event.venue.getDate())) {

                // If the new start time falls inside an already scheduled event
                if (TotalInMin >= event.venue.startTime && TotalInMin <= event.venue.endTime) {
                    System.out.println("Overlap detected with another event on this date...");
                    return false;
                }
            }
        }

        ST = startTime; // The original time entered (Ex: 11:30) for printing purposes
        this.startTime = TotalInMin; // Assign the start time to the venue
        return true;
    }

    public boolean setEndTime(String endTime, ArrayList<Event> eventlist){
        if (!endTime.contains(":")) {
            return false;
        }
        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 * Integer.parseInt(Time[0]);

        if (!validateTime(TotalInMin)) { // If validateTime is false, it means that the end time is before the starting time which will trigger the code below
            System.out.println("Wrong Time...end time must be after starting time...");
            return false;
        }

        for (Event event : eventlist) {
            if (event.venue == this) continue;

            if (event.venue != null && event.venue.getClass() == this.getClass() && this.date.equals(event.venue.getDate())) {

                // If the new end time falls inside an already scheduled event
                if (TotalInMin > event.venue.startTime && TotalInMin <= event.venue.endTime) {
                    System.out.println("Overlap detected with another event on this date...");
                    return false;
                }

                // If the new event completely swallows/envelops an existing event
                if (this.startTime <= event.venue.startTime && TotalInMin >= event.venue.endTime) {
                    System.out.println("Overlap detected...");
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
        return endTime - startTime >= 0; // Since we converted the time to minutes, we can easily check
    }

    // Check if the capacity entered is sufficient for the venue's designated amount
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
