public class Decoration {

    public static void decorate() {
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void CapacityDecoration(String eventName, String BuildingName, int maxCapacity) {

        System.out.print("Finally, how many people are attending " + eventName + " event ? ");
        System.out.print("put in mind that the " + BuildingName);
        System.out.println(" maximum is " + maxCapacity + " people.");
    }

    public static void DateTimeDecoration() {
        System.out.println("Now, please provide the date and time for this event.");
    }

    public static void CustomErrorMessage(String cMessage) {
        System.out.println("⚠ ERROR ⚠ " + cMessage + ". Please input acceptable value.");
    }

    public static void CustomErrorMessage(String cMessage, String extensive) {
        System.out.println("⚠ ERROR ⚠ " + cMessage + ". " + extensive + ".");
    }

    public static void displayED(int position, String eventName, String eventGenre) {
        System.out.println("(" + position + ") '" + eventName + "' " + eventGenre + " Event");

    }

}



