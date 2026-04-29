import java.util.Scanner;
public abstract class Event {

    // Member Variables
    private String eventName;
    private String SponsorDep;
    private String SponsorPerson;
    protected Venue venue; // Protected so we can inherit it in subclasses. If it was private, the variable would not be accessible in other subclasses

    // Member Methods
    public String getEventName() {
        return eventName;
    }
    public String getSponsorDep() {
        return SponsorDep;
    }
    public String getSponsorPerson() {
        return SponsorPerson;
    }

    public void setEventName (String eventName){
        this.eventName = eventName;
    }

    public void setSponsorPerson(String sponsorPerson) {
        this.SponsorPerson = sponsorPerson;
    }

    public void setSponsorDep(String sponsorDep) {
        this.SponsorDep = sponsorDep;
    }

    public abstract String getEventGenre();

    public abstract void fillSpecificInfo(Scanner scnr); // This method is abstract because every subclass MUST provide its own implementation of it

    @Override
    public String toString(){
        return "Event name:  " + eventName +"\n" + "Sponsor:  "+ SponsorDep +" Dept. By: "+ SponsorPerson +"\n";
    }
}