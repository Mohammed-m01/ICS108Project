import java.util.Scanner;

public class Religious extends Event{

    private String eventGenre = "Religious";
    private String Sponsor = "IAS-Dept -- Dr.Ali AlHashem";
    private String winnersAward;


    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter the winner's award:  ");
        winnersAward = scnr.next();

    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sponsor:  " + Sponsor+"\n" + "Winner's Award:  " + winnersAward
                + venue.toString();
    }
}
