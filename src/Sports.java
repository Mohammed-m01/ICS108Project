public class Sports extends Event {
    private String eventGenre = "Sports";
    private String Sponsor = "PE-Dept -- Mr.Jack Roberson";
    private String sportName;
    protected Stadium venue ;

    public Sports(){
        Stadium venue = new Stadium();
    }
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }


}
