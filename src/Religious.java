import java.util.Scanner;
public class Religious extends Event{

    private String eventGenre = "Religious";
    private String winnersAward;


    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("-------------------------------------------------------------------------\nSince you chose a Religious event, you need to provide the winner's award.\nEnter the winner's award:  ");
        winnersAward = scnr.next();

    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n"  + "Winner's Award:  " + winnersAward
                + venue.toString();
    }
    @Override
    public String getEventGenre() {
        return eventGenre;
    }
}
