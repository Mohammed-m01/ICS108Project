import java.util.ArrayList;

public class Venue {
    private  int capacity;
    private String location;
    protected int startTime;// These values will be stored as a sum of total minutes.
    protected int endTime;
    protected String ST;
    protected String ET;
    private String date;

    protected ArrayList<Integer> TimeTable = new ArrayList<>();

    protected ArrayList<Integer> getTimeTable() {
        return TimeTable;
    }

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // NOTE: TIME Should be entered as a string in a 24 format similar to 22:30
    public boolean setStartTime(String startTime, ArrayList<Event> eventlist){
        boolean dateMatch = false;

        String[] Time = startTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);

        for(Event event : eventlist){
            if(this.date.equals(event.venue.getDate()))
                dateMatch = true;
        }

        if(dateMatch) {

            if (getTimeTable().isEmpty()) {
                ST = startTime;
                this.startTime = TotalInMin;
                getTimeTable().add(TotalInMin);

                return true;
            } else {

                for (int i = 0; i + 1 < getTimeTable().size(); i += 2) {
                    int strt = getTimeTable().get(i);
                    int finsh = getTimeTable().get(i + 1);
                    if (TotalInMin >= strt && TotalInMin <= finsh) {
                        System.out.println("Overlap detected...Input different time \nENTER NEW VALUE :");
                        return false;
                    }
                }
                ST = startTime;
                this.startTime = TotalInMin;
                getTimeTable().add(TotalInMin);
                return true;
            }
        }

        else{
            ST = startTime;
            this.startTime = TotalInMin;
            getTimeTable().add(TotalInMin);
            return true;

        }

    }

    public boolean setEndTime(String endTime, ArrayList<Event> eventlist){
        boolean dateMatch = false;

        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);

        for(Event event : eventlist){
            if (event.venue == this)
                continue;

            if(this.date.equals(event.venue.getDate()))
                dateMatch = true;
        }

        if(!validateTime(TotalInMin)) {
            System.out.println("Wrong Time...endTime must be after start\nENTER NEW VALUE :");
            return false;
        }

        else {

            if(dateMatch) {
                if (getTimeTable().size() == 1) {
                    ET = endTime;
                    this.endTime = TotalInMin;
                    getTimeTable().add(TotalInMin);
                    return true;
                } else {
                    for (int i = 0; i + 1 < getTimeTable().size(); i += 2) {
                        int strt = getTimeTable().get(i);
                        int finsh = getTimeTable().get(i + 1);
                        if (startTime < finsh && TotalInMin > strt) {
                            System.out.println("Overlap detected...Input different time \nENTER NEW VALUE :");
                            return false;
                        }
                    }
                    ET = endTime;
                    this.endTime = TotalInMin;
                    getTimeTable().add(TotalInMin);
                    return true;
                }
            }

            else{
                ET = endTime;
                this.endTime = TotalInMin;
                getTimeTable().add(TotalInMin);
                return true;
            }

        }
    }

    // To ensure the end is after the start.
    private boolean validateTime(int endTime){
        return endTime - startTime >= 0;
    }


    @Override
    public String toString(){
        return   "\nLocation:  " + location +"\nCapacity: " + capacity +"\nDate: " + date ;
    }

}
