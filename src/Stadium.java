import java.util.ArrayList;
public class Stadium extends Venue{

    private static ArrayList<Integer> stadiumTimeTable = new ArrayList<>();

    @Override
    protected ArrayList<Integer> getTimeTable() {
        return stadiumTimeTable;
    }


    public Stadium(){
        setCapacity(200);
        setLocation("Building 25-Stadium");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }



}
