/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author leebe
 */
public class MyVaccination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatIntelliJLaf.install();
        // Change to Login.java
        Login login = new Login();
        login.setVisible(true);

        //Main end
    }

//Class end
}
