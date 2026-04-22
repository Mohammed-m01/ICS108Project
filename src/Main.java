import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void displayMenu() {

        System.out.println("Welcome to EVENT-MANAGER");

        System.out.println("(1) Add Event");
        System.out.println("(2) Remove Event");
        System.out.println("(3) Display Events");

        getUserOption();
    }

    public static int getUserOption(){
        System.out.println(-1);
        return -1;
    }


    public static void main (String [] args) {
        // IMPORTANT: for accepting . as a separator in doubles.
        java.util.Locale.setDefault(java.util.Locale.US);

        Scanner scnr = new Scanner(System.in);
        displayMenu();

        Stadium test = new Stadium();
        System.out.println(test.setStartTime("11:20"));
        System.out.println(test.setEndTime("20:32"));
        System.out.println(test.setStartTime("18:32"));



    }
}