public abstract class Event {
    // Member Variables
    private String eventName;





    // Member Methods
    public Event (){

    }

    public void setEventName (String eventName){
        this.eventName = eventName;

    }




    @Override
    public String toString(){

        return "Event name:\t" + eventName +"\n";

    }
}
