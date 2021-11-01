/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination.Helper_Classes;

import MyVaccination.Gson.LocalDateAdapter;
import MyVaccination.Gson.LocalTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

final public class File_Helper {

    final static private String defaultFilePath = "src/MyVaccination/Database/";
    final static public Gson gsonWriter = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()).create();

    //Checks if the file path exists, and creates the folders if not
    private static void checkPathExistance(String path) {
        try {
            File pathToFile = new File(path);
            if (!pathToFile.exists()) {
                pathToFile.getParentFile().mkdirs();
            }

        } catch (Exception e) {
            System.out.println("Error at Save_Helper: " + e.getMessage());
        }
    }

    //For the parsing of array objects
    public static <T> List<T> parseGsonArray(String json, Class<T[]> model) {
        return Arrays.asList(gsonWriter.fromJson(json, model));
    }

    // To save the given object to textfile
    public static boolean saveData(Object obj, String className) {
        //Referenced from W3Schools

        try {

            //Cast the (dynamic) object to the interface File_Methods to obtain the filename as defined per class
            File_Methods objFile = (File_Methods) obj;

            //Path and filename to be saved
            String fileName = defaultFilePath + className + "/" + objFile.setFileName() + ".txt";

            checkPathExistance(fileName);

            try ( FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(gsonWriter.toJson(obj));
            }

            return true;
        } catch (IOException e) {
            //TODO proper exception handling implementation needed
            System.out.println("File_Helper, saveData: " + e.getMessage());
        }

        return false;
    }

    //To read from the given file (singular)
    public static String readFile(String filename) {
        try {
            String filePath = defaultFilePath + filename;
            File file = new File(filePath);

            if (!file.exists()) {
                return null;
            }

            // Only 1 line is available within the textfile since its written in JSON
            try ( Scanner fileReader = new Scanner(file)) {
                String data = "";
                while (fileReader.hasNextLine()) {
                    data = fileReader.nextLine();
                }
                return data;
            }

        } catch (FileNotFoundException e) {
            //TODO proper exception handling implementation needed
            System.out.println("File_Helper, readFile: " + e.getMessage());
        }
        return null;
    }

    // To read all files in the folder
    public static List<String> readFolder(String folderName) {
        try {
            String folderPath = defaultFilePath + folderName;
            File folder = new File(folderPath);
            List<String> data = new ArrayList();

            if (!folder.exists() || !folder.isDirectory()) {
                return null;
            }

            // Only 1 line is available within the textfile since its written in JSON
            for (File fileInFolder : folder.listFiles()) {
                if (fileInFolder.isDirectory()) {
                    continue;
                }
                try ( Scanner fileReader = new Scanner(fileInFolder)) {
                    while (fileReader.hasNextLine()) {
                        data.add(fileReader.nextLine());
                    }
                }
            }

            return data;
        } catch (FileNotFoundException e) {
            //TODO proper exception handling implementation needed
            System.out.println("File_Helper, readFolder: " + e.getMessage());
        }
        return null;
    }

    //Method for deleting the given file
    public static boolean deleteFile(String fileName) {
        //TODO proper exception handling implementation needed
        String filePath = defaultFilePath + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }

        // Try to delete the file
        return file.delete();
    }

    //end Save_Helpers
}
