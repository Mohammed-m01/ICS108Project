import java.util.ArrayList;

public class UniversityBeach extends Venue{

    private static ArrayList<Integer> UniBeachTimeTable = new ArrayList<>();

    @Override
    protected ArrayList<Integer> getTimeTable() {
        return UniBeachTimeTable;
    }


    public UniversityBeach(){
        setCapacity(180);
        setLocation("University Beach");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}
