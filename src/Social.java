import java.util.Scanner;
public class Social extends Event {

    private String eventGenre = "Social";
    private String dinnerMeal;

    @Override
    public void fillSpecificInfo(Scanner scnr){
        System.out.print("-------------------------------------------------------------------------\nSince you chose a Social event, you need to provide the dinner meal.\nEnter Dinner Meal:  ");
        dinnerMeal = scnr.nextLine();
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:  " + eventGenre +"\n" + "Dinner Meal:  " + dinnerMeal
                + venue.toString();
    }
    @Override
    public String getEventGenre() {
        return eventGenre;
    }
}
