public class Sports extends Event {
    private String eventGenre = "Sports";
    private String Sponsor = "PE-Dept -- Mr.Jack Roberson";
    private String sportName;
    protected Stadium venue ;

    public Sports(){
         venue = new Stadium();
    }
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String toString(){
        return super.toString() +"Event Genre:\t" + eventGenre +"\n" + "Sponsor:\t" + Sponsor +"\n" + "Sport Name:\t" + sportName +"\n"
                + venue.toString();
    }

}
