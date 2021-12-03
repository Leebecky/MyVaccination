/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Helper_Classes;

import static MyVaccination.Helper_Classes.File_Helper.gsonWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author leebe
 */
public class Logger {


    public static void logToFile(LocalDate date, LocalTime time, String message, String origin) {
        try {

            //Path and filename to be saved
            String fileName = "MyVaccination_Log.txt";

            File pathToFile = new File(fileName);
            if (!pathToFile.exists()) {
                pathToFile.getParentFile().mkdirs();
            }

            try ( FileWriter fileWriter = new FileWriter(fileName, true)) {
                String msg = date.toString() + " " + time.toString() + ": " + origin + " - " + message;
                fileWriter.write(msg);
            }

        } catch (IOException e) {

            System.out.println("File_Helper, saveData: " + e.getMessage());
        }
    }
}
