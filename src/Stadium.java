import java.util.ArrayList;
public class Stadium extends Venue{
    private int startTime;// These values will be stored as a sum of total minutes.
    private int endTime;

    protected static ArrayList<Integer> TimeTable = new ArrayList<>();

    public Stadium(){
        setCapacity(200);
        setLocation("Building 25-Stadium");
    }


    // NOTE: TIME Should be entered as a string in a 24 format similar to 22:30
    public boolean setStartTime(String startTime){
        String[] Time = startTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);


        if(TimeTable.isEmpty()){
            this.startTime = TotalInMin;
            TimeTable.add(TotalInMin);
            return true;
        }
        else  {
            for (int i = 0; i < TimeTable.size(); i+= 2) {
                int strt  = TimeTable.get(i);
                int finsh = TimeTable.get(i+1);
                if(TotalInMin > strt && TotalInMin < finsh) {
                    return false;
                }
            }
            this.startTime = TotalInMin;
            TimeTable.add(TotalInMin);
            return true;
        }

    }

    public boolean setEndTime(String endTime){

        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[1]) + 60 *Integer.parseInt(Time[0]);

        if(!validateTime(TotalInMin)) {
            System.out.println("Wrong Time");
            return false;
        }

        else {
            if(TimeTable.size() == 1){
                this.endTime = TotalInMin;
                TimeTable.add(TotalInMin);
                return true;
            }
            else  {
                for (int i = 0; i < TimeTable.size(); i += 2) {
                    int strt  = TimeTable.get(i);
                    int finsh = TimeTable.get(i+1);
                    if(TotalInMin > strt && TotalInMin < finsh) {
                        return false;
                    }
                }
                this.endTime = TotalInMin;
                TimeTable.add(TotalInMin);
                return true;
            }

        }
    }

    // To ensure the end is after the start.
    private boolean validateTime(int endTime){
        return endTime - startTime >= 0;
    }



}
