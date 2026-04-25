public class ConferenceHall extends Venue{


    public ConferenceHall(){
        setCapacity(30);
        setLocation("Building 24-Conference Hall");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }
}
