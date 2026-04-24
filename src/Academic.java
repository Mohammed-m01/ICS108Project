import java.util.Scanner;
public class Academic extends Event {
    private String eventGenre = "Sports";
    private String Sponsor = "PHYS-Dept -- Dr.Khalid Abdullah";
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