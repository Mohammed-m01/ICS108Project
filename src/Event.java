public abstract class Event {
    // Member Variables
    private static int eventsNumber = 0;
    private String eventName;





    // Member Methods
    public Event (){
        eventsNumber++;
    }

    public void setEventName (String eventName){
        this.eventName = eventName;

    }




    @Override
    public String toString(){

        return "Number of events:\t" + eventsNumber + "\nEvent name:\t" + eventName;

    }
}
