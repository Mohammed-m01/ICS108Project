import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Method to print website logo
    public static void asciiLogo(){
        System.out.println("███████╗██╗   ██╗███████╗███╗   ██╗████████╗    ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗██████╗ \n" +
                "██╔════╝██║   ██║██╔════╝████╗  ██║╚══██╔══╝    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝██╔══██╗\n" +
                "█████╗  ██║   ██║█████╗  ██╔██╗ ██║   ██║       ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██████╔╝\n" +
                "██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║       ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██╔══██╗\n" +
                "███████╗ ╚████╔╝ ███████╗██║ ╚████║   ██║       ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║  ██║\n" +
                "╚══════╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝");
    }
    // Method to display user options
    public static int displayMenu(Scanner scnr) {

        System.out.println("-------------------------------------------------------------------------\n<< Main Menu >>\n");

        System.out.println("\uD835\uDFCF Add Event");
        System.out.println("\uD835\uDFD0 Remove Event");
        System.out.println("\uD835\uDFD1 Display Events");

        return getUserOption(scnr); // Calls the getUserOption method to read the input
    }
    // Method to ask the user for input, validate it, and returns the answer as an integer
    public static int getUserOption(Scanner scnr){
        int input =0;
        System.out.print("\nSelect an option:  ");

        if(scnr.hasNextInt()) { // Checks if the input is valid
            input = scnr.nextInt(); // If valid, set it as the input variable to be returned
        }
        else {
            scnr.next(); // Clears false input from the input buffer
            input = -1; // // Mark input as invalid
        }
        scnr.nextLine(); // Clears the rest of the line from the input buffer
        return input; // Return the user's option
    }
    // Same logic as above, used to validate a numerical input
    public static int getUserNumInput(Scanner scnr){
        int input =0;

        if(scnr.hasNextInt()) {
            input = scnr.nextInt();
        }
        else {
            scnr.next();
            input = -1;
        }
        scnr.nextLine();
        return input;
    }
    // Used to receive a string input from a user
    public static String getUserInput(Scanner scnr){
        String input = scnr.nextLine();
        return input;
    }
    // Method to receive the type of event
    public static int ChooseEvent(Scanner scnr){
        System.out.println("-------------------------------------------------------------------------\n[\uD83D\uDD28 CREATING EVENT] To return to the main menu, press \uD835\uDFCE.\nChoose an event genre:");

        System.out.println("\uD835\uDFCF Sports");
        System.out.println("\uD835\uDFD0 Social");
        System.out.println("\uD835\uDFD1 Religious ");
        System.out.println("\uD835\uDFD2 Academic");

        return getUserOption(scnr); // Calls the above method to receive the input from the user

    }
    // Method to assign the venue
    public static int ChooseVenue(Scanner scnr){
        System.out.println("-------------------------------------------------------------------------\n[\uD83D\uDCCD CHOOSING VENUE] To return to the main menu, press \uD835\uDFCE.\nChoose a venue to host the event on: \n");

        System.out.println("\uD835\uDFCF Stadium");
        System.out.println("\uD835\uDFD0 University Beach");
        System.out.println("\uD835\uDFD1 Conference Hall");
        System.out.println("\uD835\uDFD2 Lecture Hall");

        return getUserOption(scnr);

    }

    public static void createEventObject(Scanner scnr, ArrayList<Event> eventList){
        while (true) {
            int userEvent = ChooseEvent(scnr); // userEvent is the user input

            switch(userEvent) {
                case 0:
                    System.out.println("Returning to the main menu...");
                    return;
                case 1: // If the user inputs 1, a Sports event is created
                    eventList.add(new Sports()); // The event is added to the event list
                    System.out.println("-------------------------------------------------------------------------\nSports Event Created!");
                    return;
                case 2:
                    eventList.add(new Social());
                    System.out.println("-------------------------------------------------------------------------\nSocial Event Created!");
                    return;
                case 3:
                    eventList.add(new Religious());
                    System.out.println("-------------------------------------------------------------------------\nReligious Event Created!");
                    return;
                case 4:
                    eventList.add(new Academic());
                    System.out.println("-------------------------------------------------------------------------\nAcademic Event Created!");
                    return;
                default: // If the above cases fail, then the input is definitely invalid
                    System.out.println("⚠ ERROR ⚠ Invalid Input. Please make sure you provide an integer.");
                    break;
            }
        }
    }

    public static boolean specifyVenueObject(Scanner scnr, ArrayList<Event> eventList, int eventNum) {
        while (true) {
            int userVenue = ChooseVenue(scnr); // After choosing the event, the venue is now also selected.
            Event event = eventList.get(eventNum); //

            switch (userVenue) {
                case 0:
                    System.out.println("Returning to the main menu...");
                    return false;
                case 1:
                    event.venue = new Stadium(); // The venue is assigned to the event
                    System.out.println("Sweet! This event will be hosted in the Stadium.");
                    return true;
                case 2:
                    event.venue = new UniversityBeach();
                    System.out.println("Sweet! This event will be hosted in the University Beach.");
                    return true;
                case 3:
                    event.venue = new ConferenceHall();
                    System.out.println("Sweet! This event will be hosted in the Conference Hall.");
                    return true;
                case 4:
                    event.venue = new LectureHall();
                    System.out.println("Sweet! This event will be hosted in the Lecture Hall.");
                    return true;
                default:
                    System.out.println("⚠ ERROR ⚠ Invalid Input. Please make sure you provide a correct input.");
                    break;
            }
        }
    }

    public static void main (String [] args) {
        // IMPORTANT: for accepting . as a separator in doubles.
        Locale.setDefault(Locale.US);

        Scanner scnr = new Scanner(System.in); // Create a scanner object
        ArrayList<Event> eventList = new ArrayList<>(); // Create an ArrayList to store the events
        asciiLogo(); // Print the website logo

        // Core program
        while(true){
            switch (displayMenu(scnr)){ // Prints the menu options and asks for an input (1-3)
                case 1: // 1 is for creating a new event
                    int oldSize = eventList.size(); // Store current number of events before trying to create a new one
                    createEventObject(scnr, eventList); // Adds the event to the list
                    if(eventList.size() > oldSize) { // If size increased, that means a valid event was created; therefore, if the user types invalid input, the code below won't run
                        int eventNum = eventList.size() - 1; // Get the created event; It is at the last spot of the list, therefore we subtract by 1 to get its index
                        Event cEvent = eventList.get(eventNum); // Get the event by its index. Could be sports object, religious object, etc

                        System.out.print("Now, please provide the required information about this event so we can proceed further.\nEvent Name:  ");
                        cEvent.setEventName(getUserInput(scnr)); // Set the event name

                        System.out.print("Enter Sponsor Department:  ");
                        cEvent.setSponsorDep(getUserInput(scnr)); // Set the academic department sponsor

                        System.out.print("Enter Sponsor Person:  ");
                        cEvent.setSponsorPerson(getUserInput(scnr)); // Set the sponsor's name
                        System.out.println("Successfully created Event '" + cEvent.getEventName() + "' with sponsor '" + cEvent.getSponsorPerson() + "' from the '" + cEvent.getSponsorDep() + "' department!");

                        boolean venueSelected = specifyVenueObject(scnr, eventList, eventNum); // Assign a venue for the event
                        if (!venueSelected) {
                            eventList.remove(eventNum); // Remove the event because the event creation process was cancelled
                            break; // Return to the main menu
                        }
                        cEvent.fillSpecificInfo(scnr); // This is polymorphism in real time: it behaves differently depending on the user input

                        // Make sure the events don't overlap
                        System.out.print("-------------------------------------------------------------------------\nGood stuff! Now, please provide the date and time for this event.\nEnter Event Date (Ex:dd/mm):");
                        while(!cEvent.venue.setDate(getUserInput(scnr))){
                            System.out.print("⚠ ERROR ⚠ Invalid Date. Please make sure you follow the correct entry format.\nEnter Event Date (Ex:dd/mm):   ");
                        }

                        System.out.print("Enter Start Time in this format(Ex: 11:23):  ");
                        while (!cEvent.venue.setStartTime(getUserInput(scnr), eventList)) {
                            System.out.print("⚠ ERROR ⚠ Invalid Start Time. Please make sure you follow the correct entry format.\nEnter Start Time in this format(Ex: 11:23):   ");
                        }

                        System.out.print("Enter End Time (Ex: 13:23):  ");
                        while (!cEvent.venue.setEndTime(getUserInput(scnr), eventList)) {
                            System.out.print("⚠ ERROR ⚠ Invalid End Time. Please make sure you follow the correct entry format.\nEnter End Time (Ex: 13:23):   ");
                        }

                        System.out.print("-------------------------------------------------------------------------\nFinally, how many people are attending this "
                                + cEvent.getEventName() + " " + cEvent.getEventGenre()
                                + " event? Keep in mind that the " + cEvent.venue.getLocation()
                                + " can only host a maximum amount of " + cEvent.venue.getMaxCapacity()
                                + " people.\nEnter Event's Capacity:  ");
                        while (!cEvent.venue.setCapacity(getUserNumInput(scnr))) {
                            System.out.print("⚠ ERROR ⚠ Invalid Capacity. Make sure you enter a number that the venue can handle.\nEnter Event's Capacity:  ");
                        }
                        System.out.println("Event Created! \uD83D\uDE0A Thank you for using our Event Manager. We hope to see you again soon. ~Mohammed & Hassan");
                    }
                    break;

                case 2: // Remove an event
                    if (eventList.size() == 0) {
                        System.out.println("⚠ ERROR ⚠ There are no events to remove. Please create an event first.");
                    } else {
                        System.out.println("-------------------------------------------------------------------------\n[⌫ EVENT REMOVAL] To return to the main menu, press \uD835\uDFCE");
                        int pos = 0;
                        for (int i = 0; i < eventList.size(); ++i) {
                            pos = i + 1;
                            System.out.println("(" + pos + ") '"+ eventList.get(i).getEventName() + "' " + eventList.get(i).getEventGenre() + " Event");
                        }
                        System.out.print("\nChoose # of event to remove:  ");
                        int indexToRemove = getUserOption(scnr);
                            switch (indexToRemove) {
                                case 0:
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    eventList.remove(indexToRemove-1);
                                    System.out.println("You have successfully removed this event!");
                            }
                    }
                    break;

                case 3: // Display all the events
                    if (eventList.size() == 0) {
                        System.out.println("⚠ ERROR ⚠ There are no events to display. Please create an event first!");
                    } else {
                        System.out.println("Displaying Events...");
                        System.out.println("Number of Events: " + eventList.size());

                        for (Event event : eventList) {
                            System.out.println("\n=====================================");
                            System.out.println(event.toString());
                            System.out.println("=====================================\n");
                        }
                    }
                    break;

                default:
                    System.out.println("⚠ ERROR ⚠ Invalid Input. Please make sure you select either 1, 2 or 3.");
                    break;
            }
        }
    }
}