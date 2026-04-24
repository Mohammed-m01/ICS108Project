import java.util.Scanner;

public class Religious extends Event{

    private String eventGenre = "Religious";
    private String Sponsor = "IAS-Dept -- Dr.Ali AlHashem";


    @Override
    public void fillSpecificInfo(Scanner scnr){

    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sponsor:  " + Sponsor
                + venue.toString();
    }
}
