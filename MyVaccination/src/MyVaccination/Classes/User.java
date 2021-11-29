/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.File_Methods;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author leebe
 */
public class User implements File_Methods {

    private String userId;
    public String username;
    private String password;
    protected String userType;
    protected String email;
    protected String contactNumber;

//    public User() {
//
//    }
    //Default user account values
    public User() {
        userId = "US_" + UUID.randomUUID().toString();
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String id, String name, String pass, String type) {
        this.userId = "US_" + id;
        this.username = name;
        this.password = pass;
        this.userType = type;
    }

    public void Login(String id, String name, String pass, String type) {
        this.userId = "US_" + id;
        this.username = name;
        this.password = pass;
        this.userType = type;
    }

    public User getUser() {
        return this;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setUserId(String id) {
        this.userId = "US_" + id;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public void setUserType(String type) {
        this.userType = type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public static boolean saveUser(User obj) {
        boolean saveSuccess = File_Helper.saveData(obj, "User_Account");
        return saveSuccess;
    }

    //Find user given username
    public static User findUser(String username) {
        List<People> peopleList = People.getFolderData();
        List<Personnel> personnelList = Personnel.getFolderData();

        List<User> userList = new ArrayList<>();
        userList.addAll(peopleList);
        userList.addAll(personnelList);

        Optional<User> checkUser = userList.stream().filter(d -> (d.getUsername().equals(username))).findFirst();
        User myUser = (checkUser.isPresent()) ? checkUser.get() : null;
        return myUser;
    }

    public String getDefaultPassword(User obj) {
        String defaultPassword = "";
        if (obj.userType.equals("Personnel")) {
            String username = obj.getUsername().replace(" ", "");
            defaultPassword = username.concat("_" + obj.getUserId().substring(obj.getUserId().length() - 4));
        } else {
            People p = (People) obj;
            String dob = p.getDob().toString().replace("-", "");

            defaultPassword = p.getUsername().concat("_" + dob);
        }
        return defaultPassword;
    }

    //Registering new User by Personnel
    public static boolean registerUser_Personnel(User obj) {
        String defaultPassword = obj.getDefaultPassword(obj);
        obj.setPassword(defaultPassword);

        return saveUser(obj);

    }

    @Override
    public String getFileName() {
        return "User_Account/" + userId + ".txt";
    }

    @Override
    public String setFileName() {
        return "" + userId;
    }

}
