import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void displayMenu() {

        System.out.println("Welcome to EVENT-MANAGER");

        System.out.println("(1) Add Event");
        System.out.println("(2) Edit Scheduled Events");
        System.out.println("(3) Remove Event");
        System.out.println("(4) Display Events");

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




    }
}