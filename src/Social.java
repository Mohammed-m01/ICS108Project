import java.util.Scanner;
public class Social extends Event {

    private String eventGenre = "Social";
    private String Sponsor = "ELD-Dept -- Mr.Art Vandelay";
    private String sportName;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter Sport Name:  ");
        sportName = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sponsor:  " + Sponsor +"\n" + "Sport Name:  " + sportName
                + venue.toString();
    }
}
