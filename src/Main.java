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
        Decoration.decorate();
        System.out.println("<< Main Menu >>\n");

        System.out.println("\uD835\uDFCF Add Event");
        System.out.println("\uD835\uDFD0 Remove Event");
        System.out.println("\uD835\uDFD1 Display Events");

        return getUserOption(scnr); // Calls getUserOption method to read input
    }

    // Method to ask the user for input, validate it, and returns the answer as an integer
    public static int getUserOption(Scanner scnr){
        int input =0;
        System.out.print("\nSelect an option:  ");

        if(scnr.hasNextInt()) { // Checks if the input is valid
            input = scnr.nextInt();
        }
        else {
            scnr.next(); // Clears false input from the input buffer
            input = -1; // Mark input as invalid
        }
        scnr.nextLine(); // Clears rest of the line from the input buffer
        return input; // Return user's option
    }

    // Same logic as above, used to validate a numerical input
    public static int getUserNumInput(Scanner scnr){
        int input;
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
        return scnr.nextLine();
    }

    // Method to receive the type of event
    public static int ChooseEvent(Scanner scnr){
        Decoration.decorate();
        System.out.println("[CREATING EVENT] To return to the main menu, press \uD835\uDFCE.");
        System.out.println("Choose an event genre:");

        System.out.println("\uD835\uDFCF Sports");
        System.out.println("\uD835\uDFD0 Social");
        System.out.println("\uD835\uDFD1 Religious ");
        System.out.println("\uD835\uDFD2 Academic");

        return getUserOption(scnr); // Calls the above method to receive the input from the user

    }

    // Method to assign the venue
    public static int ChooseVenue(Scanner scnr){
        Decoration.decorate();
        System.out.println("[CHOOSING VENUE] To return to the main menu, press \uD835\uDFCE.");
        System.out.println("Choose a venue to host the event on: ");

        System.out.println("\uD835\uDFCF Stadium");
        System.out.println("\uD835\uDFD0 University Beach");
        System.out.println("\uD835\uDFD1 Conference Hall");
        System.out.println("\uD835\uDFD2 Lecture Hall");

        return getUserOption(scnr);

    }

    // Method to print "X event created!"
    public static void printEvent(String eventName) {
        Decoration.decorate();
        System.out.println(eventName + " Event Created!");
    }

    // Method to print "Done. This event will be hosted in X."
    public static void printVenue(String venueName) {
        System.out.println("Sweet! This event will be hosted in the " + venueName + ".");
    }


    public static void createEventObject(Scanner scnr, ArrayList<Event> eventList){
        while (true) {
            int userEvent = ChooseEvent(scnr); // userEvent is the user input

            switch(userEvent) {
                case 0:
                    System.out.println("Returning to the main menu...");
                    return;
                case 1: // If the user inputs 1, a Sports event is created
                    eventList.add(new Sports()); // Event is added to the event list
                    printEvent("Sports"); // Print ------------ Sports event created! using the method above
                    return;
                case 2:
                    eventList.add(new Social());
                    printEvent("Social");
                    return;
                case 3:
                    eventList.add(new Religious());
                    printEvent("Religious");
                    return;
                case 4:
                    eventList.add(new Academic());
                    printEvent("Academic");
                    return;
                default: // If the above cases fail, then the input is definitely invalid
                    System.out.println("⚠ ERROR ⚠ Invalid Input. Please provide valid integer.");
                    break;
            }
        }
    }

    public static boolean specifyVenueObject(Scanner scnr, ArrayList<Event> eventList, int eventNum) {
        while (true) {
            int userVenue = ChooseVenue(scnr); // After choosing the event, the venue is now also selected.
            Event event = eventList.get(eventNum); // Takes the previously created event from the list to specify venue.

            switch (userVenue) {
                case 0:
                    System.out.println("Returning to the main menu...");
                    return false;
                case 1:
                    event.venue = new Stadium(); // The venue is assigned to the event
                    printVenue("Stadium");
                    return true;
                case 2:
                    event.venue = new UniversityBeach();
                    printVenue("University Beach");
                    return true;
                case 3:
                    event.venue = new ConferenceHall();
                    printVenue("Conference Hall");
                    return true;
                case 4:
                    event.venue = new LectureHall();
                    printVenue("Lecture Hall");
                    return true;
                default:
                    System.out.println("⚠ ERROR ⚠ Invalid Input. Please provide a correct input.");
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

                    // Store current number of events before trying to create a new one
                    int oldSize = eventList.size();
                    createEventObject(scnr, eventList); // Adds the event to the list

                    // If size increased, that means a valid event was created; therefore, if the user types invalid input, the code below won't run
                    if(eventList.size() > oldSize) {
                        int eventNum = eventList.size() - 1; // Get the created event; It is last item in the list, so we -1 to get its index
                        Event cEvent = eventList.get(eventNum); // Get the event by its index. Could be sports object, religious object, etc

                        System.out.print("Now, please provide information about this event so we proceed further.\nEvent Name:  ");
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
                        // This is real time polymorphism: it behaves differently depending on the chosen
                        cEvent.fillSpecificInfo(scnr);

                        // Make sure the events don't overlap
                        Decoration.decorate();
                        Decoration.DateTimeDecoration();

                        System.out.print("Enter Event Date (Ex:dd/mm):");
                        while(!cEvent.venue.setDate(getUserInput(scnr))){
                            Decoration.CustomErrorMessage("Invalid Date");
                            System.out.print("Enter Event Date (Ex:dd/mm):   ");
                        }

                        System.out.print("Enter Start Time in this format(Ex: 11:23):  ");
                        while (!cEvent.venue.setStartTime(getUserInput(scnr), eventList)) {
                            Decoration.CustomErrorMessage("Invalid Start Time");
                            System.out.print("Enter Start Time (Ex: 11:23):   ");
                        }

                        System.out.print("Enter End Time (Ex: 13:23):  ");
                        while (!cEvent.venue.setEndTime(getUserInput(scnr), eventList)) {
                            Decoration.CustomErrorMessage("Invalid End Time");
                            System.out.print("Enter End Time (Ex: 13:23):   ");
                        }

                        Decoration.decorate();
                        Decoration.CapacityDecoration(cEvent.getEventName(),cEvent.venue.getLocation(),cEvent.venue.getMaxCapacity());
                        System.out.print("Enter Event's Capacity:  ");


                        while (!cEvent.venue.setCapacity(getUserNumInput(scnr))) {
                            Decoration.CustomErrorMessage("Invalid Capacity");
                            System.out.print("Enter Event's Capacity:  ");
                        }
                        System.out.println("Event Created! :) Thanks for using Event Manager. We hope to see you soon. ~Mohammed & Hassan");
                    }
                    break;




                case 2: // Remove an event
                    if (eventList.isEmpty()) {
                        System.out.println("⚠ ERROR ⚠ There are no events to remove. Please create an event first.");
                    }
                    else {
                        Decoration.decorate();
                        System.out.println("[⌫ EVENT REMOVAL] To return to the main menu, press \uD835\uDFCE");

                        int pos;
                        for (int i = 0; i < eventList.size(); ++i) {
                            pos = i + 1;
                            Decoration.displayED(pos, eventList.get(i).getEventName(), eventList.get(i).getEventGenre());
                        }
                        System.out.print("\nChoose # of event to remove:  ");
                        int indexToRemove = getUserOption(scnr);

                        switch (indexToRemove) {
                                case 0: // if 0 is chosen, return to main menu
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    if (indexToRemove > eventList.size() || indexToRemove < 0 ) { // if input number is not included in the list
                                        Decoration.CustomErrorMessage("Invalid Input","Make sure your # is included in the list");
                                        break;
                                    }
                                    eventList.remove(indexToRemove-1);
                                    System.out.println("You have successfully removed this event!");
                            }
                    }
                    break;




                case 3: // Display all the events
                    if (eventList.isEmpty()) {
                        Decoration.CustomErrorMessage("There are no events to display","Create an event first!");
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
                    Decoration.CustomErrorMessage("Invalid Input","Make sure you select either 1, 2 or 3.");
                    break;
            }
        }
    }
}