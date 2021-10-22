/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyVaccination;

import MyVaccination.Classes.Vaccine_Pfizer;
import MyVaccination.Classes.Vaccine;
import MyVaccination.Classes.Vaccine_AstraZeneca;
import MyVaccination.Classes.Stock;
import MyVaccination.Classes.Vaccination_Centre;
import MyVaccination.Gson.LocalDateAdapter;
import MyVaccination.Helper_Classes.File_Helper;
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
import java.util.UUID;

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
        Test2 test = new Test2();
        test.setVisible(true);

        
// Sample code for JSON object creation and write to file
/*
        AstraZeneca az = new AstraZeneca();
        Pfizer pf = new Pfizer();

        List<Stock> stock = new ArrayList<>();
        stock.add(new Stock(pf));
        stock.add(new Stock(az));
        Vaccination_Centre vc = new Vaccination_Centre();
        vc.setStock(stock);
        vc.centreId = UUID.randomUUID().toString();
        vc.name = "Test";

        File_Helper.saveData(vc, "Vaccination_Centre");

        String vcData = File_Helper.readFile(vc.getFileName());
        Vaccination_Centre vcFromFile = File_Helper.gsonWriter.fromJson(vcData, Vaccination_Centre.class);
        List<Stock> stock2 = vcFromFile.getStock();
        System.out.println(stock2.get(0).getVaccine().getBatchNumber());
        List<String> vcDataArray = File_Helper.readFolder("Vaccination_Centre");
        List<Vaccination_Centre> vcList = new ArrayList();

        vcDataArray.forEach(fileInFolder -> {
            vcList.add(File_Helper.gsonWriter.fromJson(fileInFolder, Vaccination_Centre.class));
        });

        vcList.forEach(f -> {
            f.getStock().forEach(s -> {
                System.out.println(s.getVaccine().getBatchNumber());
            });

        });
*/

        //Main end
    }

//Class end
}
