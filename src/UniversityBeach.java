public class UniversityBeach extends Venue{

    public UniversityBeach(){
        setCapacity(180);
        setLocation("University Beach");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}
