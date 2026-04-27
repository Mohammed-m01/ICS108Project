public class Stadium extends Venue{

    public Stadium(){
        setMaxCapacity(200);
        setLocation("Building 25-Stadium");
    }

    @Override
    public String toString(){
        return super.toString() +"\nStart Time:  " + ST +"  " + "End Time:  " + ET  ;
    }



}
