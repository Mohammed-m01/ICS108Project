import java.util.Scanner;
public abstract class Event {

    // Member Variables
    private String eventName;
    private String SponsorDep;
    private String SponsorPerson;
    protected Venue venue ;





    // Member Methods
    public String getEventName() {
        return eventName;
    }

    public void setEventName (String eventName){
        this.eventName = eventName;

    }


    public void setSponsorPerson(String sponsorPerson) {
        SponsorPerson = sponsorPerson;
    }

    public void setSponsorDep(String sponsorDep) {
        SponsorDep = sponsorDep;
    }

    public abstract void fillSpecificInfo(Scanner scnr);




    @Override
    public String toString(){

        return "Event name:  " + eventName +"\n" + "Sponsor:  "+ SponsorDep +"--"+ SponsorPerson +"\n";

    }
}