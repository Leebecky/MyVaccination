/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Helper;
import MyVaccination.Helper_Classes.File_Methods;
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

    public static void Login() {
        //Placeholder code for Login process, maybe return User class?
    }

    public User() {

    }

    //Default user account values
    public User(String userType, boolean forceOverload) {
        userId = "US_" + UUID.randomUUID().toString();
        this.userType = userType;
        this.password = userType + "_" + userId.substring(userId.length() - 4);
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

    public static boolean saveUser(User obj) {
        boolean saveSuccess = File_Helper.saveData(obj, "User_Account");
        return saveSuccess;
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
