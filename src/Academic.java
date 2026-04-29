import java.util.Scanner;
public class Academic extends Event {
    private String eventGenre = "Academic";
    private String lecturer;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("-------------------------------------------------------------------------\nSince you chose an Academic event, you need to provide the lecturer's name.\nEnter Lecturer's Name:  ");
        lecturer = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n"+ "Lecturer:  " + lecturer
                + venue.toString();
    }
    @Override
    public String getEventGenre() {
        return eventGenre;
    }
}