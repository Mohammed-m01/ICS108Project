public abstract class Event {
    // Member Variables
    private static int eventsNumber = 0;
    private String eventName;
    private int startTime;// These values will be stored as a sum of total minutes.
    private int endTime;

    // Member Methods
    public Event (){
        eventsNumber++;
    }

    public Event (String eventName){
        this.eventName = eventName;
        eventsNumber++;
    }

    // NOTE: TIME Should be entered as a string in a 24 format similar to 22:30
    public void setStartTime(String startTime){
        String[] Time = startTime.split(":");
        int TotalInMin = Integer.parseInt(Time[0]) + 60 *Integer.parseInt(Time[1]);
        this.startTime = TotalInMin;
    }

    public void setEndTime(String endTime){
        String[] Time = endTime.split(":");
        int TotalInMin = Integer.parseInt(Time[0]) + 60 *Integer.parseInt(Time[1]);
        this.endTime = TotalInMin;
    }

    // To ensure the end is after the start.
    private boolean validateTime(){
        return endTime - startTime >= 0;
    }


    @Override
    public String toString(){

        return "Number of events:\t" + eventsNumber + "\nEvent name:\t" + eventName;

    }
}
