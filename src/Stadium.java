import java.util.ArrayList;
public class Stadium extends Venue{
    private int startTime;// These values will be stored as a sum of total minutes.
    private int endTime;
    private String ST;
    private String ET;

    private static ArrayList<Integer> TimeTable = new ArrayList<>();

    public Stadium(){
        setCapacity(200);
        setLocation("Building 25-Stadium");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:    " + ST +"  " + "End Time:    " + ET +"\n" ;
    }



}
