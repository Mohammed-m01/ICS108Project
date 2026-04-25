import java.util.Scanner;
public class Academic extends Event {
    private String eventGenre = "Sports";
    private String Sponsor = "PHYS-Dept -- Dr.Khalid Abdullah";
    private String lecturer;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter Lecturer's Name:  ");
        lecturer = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sponsor:  " + Sponsor +"\n" + "Lecturer:  " + lecturer
                + venue.toString();
    }
}