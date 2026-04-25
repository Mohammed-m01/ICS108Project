import java.util.Scanner;
public class Social extends Event {

    private String eventGenre = "Social";
    private String Sponsor = "ELD-Dept -- Mr.Art Vandelay";
    private String dinnerMeal;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter Dinner Meal:  ");
        dinnerMeal = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Sponsor:  " + Sponsor +"\n" + "dinner Meal:  " + dinnerMeal
                + venue.toString();
    }
}
