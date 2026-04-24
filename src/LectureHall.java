import java.util.ArrayList;

public class LectureHall extends Venue{

    private static ArrayList<Integer> LecHallTimeTable = new ArrayList<>();

    @Override
    protected ArrayList<Integer> getTimeTable() {
        return LecHallTimeTable;
    }


    public LectureHall(){
        setCapacity(120);
        setLocation("Building 63 - Room 331 Lecture Hall");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}

