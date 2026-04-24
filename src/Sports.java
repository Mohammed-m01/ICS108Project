import java.util.Scanner;

public class Sports extends Event {
    private String eventGenre = "Sports";
    private String Sponsor = "PE-Dept -- Mr.Jack Roberson";
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
