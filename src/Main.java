import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void asciiLogo(){
        System.out.println("\n /$$$$$$$$ /$$    /$$ /$$$$$$$$ /$$   /$$ /$$$$$$$$      /$$      /$$  /$$$$$$  /$$   /$$  /$$$$$$   /$$$$$$  /$$$$$$$$ /$$$$$$$ \n" +
                "| $$_____/| $$   | $$| $$_____/| $$$ | $$|__  $$__/     | $$$    /$$$ /$$__  $$| $$$ | $$ /$$__  $$ /$$__  $$| $$_____/| $$__  $$\n" +
                "| $$      | $$   | $$| $$      | $$$$| $$   | $$        | $$$$  /$$$$| $$  \\ $$| $$$$| $$| $$  \\ $$| $$  \\__/| $$      | $$  \\ $$\n" +
                "| $$$$$   |  $$ / $$/| $$$$$   | $$ $$ $$   | $$ /$$$$$$| $$ $$/$$ $$| $$$$$$$$| $$ $$ $$| $$$$$$$$| $$ /$$$$| $$$$$   | $$$$$$$/\n" +
                "| $$__/    \\  $$ $$/ | $$__/   | $$  $$$$   | $$|______/| $$  $$$| $$| $$__  $$| $$  $$$$| $$__  $$| $$|_  $$| $$__/   | $$__  $$\n" +
                "| $$        \\  $$$/  | $$      | $$\\  $$$   | $$        | $$\\  $ | $$| $$  | $$| $$\\  $$$| $$  | $$| $$  \\ $$| $$      | $$  \\ $$\n" +
                "| $$$$$$$$   \\  $/   | $$$$$$$$| $$ \\  $$   | $$        | $$ \\/  | $$| $$  | $$| $$ \\  $$| $$  | $$|  $$$$$$/| $$$$$$$$| $$  | $$\n" +
                "|________/    \\_/    |________/|__/  \\__/   |__/        |__/     |__/|__/  |__/|__/  \\__/|__/  |__/ \\______/ |________/|__/  |__/\n" +
                "                                                                                                                                 \n" +
                "                                                                                                                                 \n" +
                "                                                                                                                                 ");
    }
    public static int displayMenu(Scanner scnr) {

        System.out.println("Welcome to EVENT-MANAGER MainMenu\n");

        System.out.println("(1) Add Event");
        System.out.println("(2) Remove Event");
        System.out.println("(3) Display Events");

        return getUserOption(scnr);
    }

    public static int getUserOption(Scanner scnr){
        System.out.println("\nSelect an option (EX 1) :");
        int input = scnr.nextInt();
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
                    int i = eventList.size()-1;

                    System.out.println("Enter Event Name:");
                    eventList.get(i).setEventName(getUserInput(scnr));

                    if(eventList.get(i) instanceof Sports){
                        Sports sportsE = (Sports) eventList.get(i);
                        System.out.println("Enter Sport Name:");
                        sportsE.setSportName(getUserInput(scnr));

                        System.out.println("Enter Start Time in this format(EX 11:23):");
                        while(!sportsE.venue.setStartTime(getUserInput(scnr))){}

                        System.out.println("Enter End Time in this format(EX 13:23):");
                        while(!sportsE.venue.setEndTime(getUserInput(scnr))){}

                    }
                    else if (eventList.get(i) instanceof Social){


                    }
                    else if (eventList.get(i) instanceof Religious){


                    }
                    else if (eventList.get(i) instanceof Academic){


                    }





                    break;
                case 2:
                    System.out.println("Removing Event");


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
                    System.out.println("Wrong option");
                    break;
            }
        }







    }
}