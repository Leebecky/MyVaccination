/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Gson.LocalDateAdapter;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//import org.json.JSONObject;
import com.google.gson.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author leebe
 */
public class MyVaccination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FlatIntelliJLaf.install();
        Test2 test = new Test2();
        test.setVisible(true);

        AstraZeneca az = new AstraZeneca();
        Pfizer pf = new Pfizer();
//        System.out.println(az.getName());
//        System.out.println(pf.getName());

        ArrayList<Vaccine> stock = new ArrayList<>();
        stock.add(pf);
        stock.add(az);
//        System.out.println(stock);
//        stock.forEach(v -> {
//            System.out.println(v.batchNumber);
//            System.out.println(v.waitTime);
//            System.out.println(v.getWaitTime());
//        }); 

// Sample code for JSON object creation and write to file

        Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        //registerTypeAdapter so that the JSON can handle LocalDate type

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(g.toJson(stock));
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                List<Vaccine> a = parseGsonArray(data, Vaccine[].class);
                System.out.println(a.get(0).getDosesRequired());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

//Main end
    }

    public static <T> List<T> parseGsonArray(String json, Class<T[]> model) {
        Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        return Arrays.asList(g.fromJson(json, model));
    }

//Class end
}
