public class Venue {
    private  int capacity;
    private String location;




    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return "Capacity:\t" + capacity +"\n" + "Location:\t" + location +"\n" ;
    }


}
