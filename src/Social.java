import java.util.Scanner;
public class Social extends Event {

    private String eventGenre = "Social";
    private String dinnerMeal;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("Enter Dinner Meal:  ");
        dinnerMeal = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "dinner Meal:  " + dinnerMeal
                + venue.toString();
    }
}
