/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Classes;

import MyVaccination.Helper_Classes.File_Methods;

/**
 *
 * @author leebe
 */
public class User implements File_Methods{

    private String userId;
    public String username;
    private String password;
    protected String userType;

    public static void Login() {
        //Placeholder code for Login process, maybe return User class?
    }
    
    public User(){
        
    }
    
    public User(String id, String name, String pass, String type){
        this.userId = id;
        this.username = name;
        this.password = pass;
        this.userType = type;
    }
    
    public void setLogin(String id, String name, String pass, String type){
        this.userId = "US_" + id;
        this.username = name;
        this.password = pass;
        this.userType = type;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getUserType(){
        return this.userType;
    }

    @Override
    public String setFileName() {
        return userId;
    }

    @Override
    public String getFileName() {
        return "UserAccount/" +  userId + ".txt";
    }
}
