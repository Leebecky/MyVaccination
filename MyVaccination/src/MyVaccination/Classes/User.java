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

    @Override
    public String setFileName() {
        return userId;
    }

    @Override
    public String getFileName() {
     return "User/" +  userId + ".txt";
    }
}
