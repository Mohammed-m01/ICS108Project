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

    public void setDate(String date) {
        this.date = date;
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
    public boolean setStartTime(String startTime){

        String[] Time = startTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);


        if(getTimeTable().isEmpty()){
            ST = startTime;
            this.startTime = TotalInMin;
            getTimeTable().add(TotalInMin);

            return true;
        }
        else  {

            for (int i = 0; i + 1 < getTimeTable().size(); i+= 2) {
                int strt  = getTimeTable().get(i);
                int finsh = getTimeTable().get(i+1);
                if(TotalInMin >= strt && TotalInMin <= finsh) {
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

    public boolean setEndTime(String endTime){

        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);

        if(!validateTime(TotalInMin)) {
            System.out.println("Wrong Time...endTime must be after start\nENTER NEW VALUE :");
            return false;
        }

        else {
            if(getTimeTable().size() == 1){
                ET = endTime;
                this.endTime = TotalInMin;
                getTimeTable().add(TotalInMin);
                return true;
            }
            else  {
                for (int i = 0; i + 1 < getTimeTable().size(); i += 2) {
                    int strt  = getTimeTable().get(i);
                    int finsh = getTimeTable().get(i+1);
                    if(TotalInMin >= strt && TotalInMin <= finsh) {
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
