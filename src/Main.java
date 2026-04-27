import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void asciiLogo(){
        System.out.println("███████╗██╗   ██╗███████╗███╗   ██╗████████╗    ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗ \n" +
                "██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗\n" +
                "█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║       ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝\n" +
                "██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║       ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗\n" +
                "███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║       ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║\n" +
                "╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝");
    }

    public static int displayMenu(Scanner scnr) {

        System.out.println("Welcome to EVENT-MANAGER MainMenu\n");

        System.out.println("(1)-Add Event");
        System.out.println("(2)-Remove Event");
        System.out.println("(3)-Display Events");

        return getUserOption(scnr);
    }

    public static int getUserOption(Scanner scnr){
        int input =0;
        System.out.print("\nSelect an option (EX 1):  ");

        if(scnr.hasNextInt()) {
            input = Integer.parseInt(scnr.next());
        }
        else {
            scnr.next();
            input = -1;
        }
        scnr.nextLine();
        return input;
    }

    public static int getUserNumInput(Scanner scnr){
        int input =0;


        if(scnr.hasNextInt()) {
            input = Integer.parseInt(scnr.next());
        }
        else {
            scnr.next();
            input = -1;
        }
        scnr.nextLine();
        return input;
    }

    public static String getUserInput(Scanner scnr){
        String input = scnr.nextLine();
        return input;
    }

    public static int ChooseEvent(Scanner scnr){
        System.out.println("\nChoose an event genre\n");

        System.out.println("(1) Sports");
        System.out.println("(2) Social");
        System.out.println("(3) Religious");
        System.out.println("(4) Academic");

        return getUserOption(scnr);

    }

    public static int ChooseVenue(Scanner scnr){
        System.out.println("\nChoose a venue to host the event\n");

        System.out.println("(1) Stadium");
        System.out.println("(2) University Beach");
        System.out.println("(3) Conference Hall");
        System.out.println("(4) Lecture Hall");

        return getUserOption(scnr);

    }

    public static void createEventObject(Scanner scnr, ArrayList<Event> eventList){
        int userEvent = ChooseEvent(scnr);

        switch(userEvent){
            case 1:
                eventList.add(new Sports());
                System.out.println("done sports");
                break;
            case 2:
                eventList.add(new Social());
                System.out.println("done social");
                break;
            case 3:
                eventList.add(new Religious());
                System.out.println("done religious");
                break;
            case 4:
                eventList.add(new Academic());
                System.out.println("done academic");
                break;
            default:
                System.out.println("Invalid-Input");
                break;

        }



    }

    public static void specifyVenueObject(Scanner scnr, ArrayList<Event> eventList, int eventNum){
        int userVenue = ChooseVenue(scnr);
        Event event = eventList.get(eventNum);

        switch(userVenue){
            case 1:
                event.venue = new Stadium();
                System.out.println("done Stadium");
                break;
            case 2:
                event.venue = new UniversityBeach();
                System.out.println("done UniversityBeach");
                break;
            case 3:
                event.venue = new ConferenceHall();
                System.out.println("Conference Hall");
                break;
            case 4:
                event.venue = new LectureHall();
                System.out.println("done LectureHall");
                break;
            default:
                System.out.println("Invalid-Input");
                break;

        }



    }


    public static void main (String [] args) {
        // IMPORTANT: for accepting . as a separator in doubles.
        java.util.Locale.setDefault(java.util.Locale.US);

        Scanner scnr = new Scanner(System.in);
        ArrayList<Event> eventList = new ArrayList<>();
        asciiLogo();



        while(true){
            switch (displayMenu(scnr)){
                case 1:
                    System.out.println("Adding Event");
                    createEventObject(scnr, eventList);
                    if(eventList.size()>0) {
                        int eventNum = eventList.size() - 1;
                        Event cEvent = eventList.get(eventNum);

                        System.out.print("Enter Event Name:  ");
                        cEvent.setEventName(getUserInput(scnr));

                        System.out.print("Enter Sponsor Department:  ");
                        cEvent.setSponsorDep(getUserInput(scnr));

                        System.out.print("Enter Sponsor Person:  ");
                        cEvent.setSponsorPerson(getUserInput(scnr));

                        specifyVenueObject(scnr, eventList, eventNum);
                        cEvent.fillSpecificInfo(scnr);

                        System.out.print("Enter Event Date (Ex:dd/mm):");
                        while(!cEvent.venue.setDate(getUserInput(scnr))){
                            System.out.print("Invalid Date, Please Input Correct Values:   ");
                        }

                        System.out.print("Enter Start Time in this format(EX 11:23):  ");
                        while (!cEvent.venue.setStartTime(getUserInput(scnr), eventList)) {}

                        System.out.print("Enter End Time in this format(EX 13:23):  ");
                        while (!cEvent.venue.setEndTime(getUserInput(scnr), eventList)) {}

                        System.out.print("Enter Event's Capacity:  ");
                        while (!cEvent.venue.setCapacity(getUserNumInput(scnr))) {
                            System.out.print("Invalid Capacity, MAXIMUM is "+cEvent.venue.getMaxCapacity()+"\nEnter new value:  ");
                        }


                    }
                    break;

                case 2:
                    System.out.println("Removing Event");
                    for(int i = 0; i < eventList.size();++i){
                        System.out.println(eventList.get(i).getEventName()+" #"+i);
                    }
                    System.out.println("Enter # of event to remove:  ");
                    int indexToRemove = scnr.nextInt();
                    scnr.nextLine();
                    eventList.remove(indexToRemove);
                    break;

                case 3:
                    System.out.println("Displaying Events");
                    System.out.println("Number of Events :" + eventList.size());

                    for(Event event : eventList){
                        System.out.println("\n=====================================");
                        System.out.println(event.toString());
                        System.out.println("=====================================\n");
                    }
                    break;

                default:
                    System.out.println("Invalid-Input");
                    break;
            }
        }



    }
}