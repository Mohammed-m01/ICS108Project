import java.util.Scanner;
public class Academic extends Event {
    private String eventGenre = "Sports";
    private String lecturer;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter Lecturer's Name:  ");
        lecturer = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n"+ "Lecturer:  " + lecturer
                + venue.toString();
    }
}