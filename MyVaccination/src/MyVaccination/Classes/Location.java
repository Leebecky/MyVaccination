package MyVaccination.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leebe
 */

public class Location {

    public String address1;
    public String address2;
    public String state;
    public Double longitude;
    public Double latitude;

    //Constructor
    public Location(String addr1, String addr2, String state) {

        address1 = addr1;
        address2 = addr2;
        this.state = state;
    }

    public static String[] getStateList() {
        String[] stateList = {"Johor", "Kedah", "Kelantan", "Kuala Lumpur", "Labuan", "Melaka", "Negeri Sembilan", "Pahang", "Penang", "Perak", "Perlis", "Putrajaya", "Sabah", "Sarawak", "Selangor", "Terengganu"};

        return stateList;
    }
}
