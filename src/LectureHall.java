public class LectureHall extends Venue{


    public LectureHall(){
        setMaxCapacity(120);
        setLocation("Building 63 - Room 331 Lecture Hall");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}

