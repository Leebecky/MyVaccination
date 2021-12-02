package MyVaccination.Classes;

/**
 *
 * @author leebe
 */
public class Location {

    private String address1;
    private String address2;
    private String state;

    //Constructor
    public Location() {

    }

    public Location(String addr1, String addr2, String state) {

        address1 = addr1;
        address2 = addr2;
        this.state = state;
    }

    //List of states available
    public static String[] getStateList() {
        String[] stateList = {"Johor", "Kedah", "Kelantan", "Kuala Lumpur", "Labuan", "Melaka", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Putrajaya", "Sabah", "Sarawak", "Selangor", "Terengganu"};

        return stateList;
    }

    //Getters
    public String getAddress1() {
        return (this.address1 == null) ? "" : this.address1;
    }

    public String getAddress2() {
        return (this.address2 == null) ? "" : this.address2;
    }

    public String getState() {
        return (this.state == null) ? "" : this.state;
    }

}
