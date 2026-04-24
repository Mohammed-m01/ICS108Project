import java.util.ArrayList;

public class ConferenceHall extends Venue{

    private static ArrayList<Integer> ConfHallTimeTable = new ArrayList<>();

    @Override
    protected ArrayList<Integer> getTimeTable() {
        return ConfHallTimeTable;
    }


    public ConferenceHall(){
        setCapacity(30);
        setLocation("Building 24-Conference Hall");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}
