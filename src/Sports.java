import java.util.Scanner;
public class Sports extends Event {

    private String eventGenre = "Sports";
    private String sportName;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        Decoration.decorate();
        System.out.print("Since you chose a Sports event, you need to provide the sport's name.\nEnter Sport Name:  ");
        sportName = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sport Name:  " + sportName
                + venue.toString();
    }
    @Override
    public String getEventGenre() {
        return eventGenre;
    }
}
