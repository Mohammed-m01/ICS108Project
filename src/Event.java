import java.util.Scanner;
public abstract class Event {

    // Member Variables
    private String eventName;
    protected Venue venue ;





    // Member Methods
    public String getEventName() {
        return eventName;
    }

    public void setEventName (String eventName){
        this.eventName = eventName;

    }

    public abstract void fillSpecificInfo(Scanner scnr);




    @Override
    public String toString(){

        return "Event name:\t" + eventName +"\n";

    }
}