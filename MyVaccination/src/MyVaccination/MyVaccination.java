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
//        Test2 test = new Test2();
//        test.setVisible(true);

        
// Sample code for JSON object creation and write to file

//        AstraZeneca az = new AstraZeneca();
//        Pfizer pf = new Pfizer();
//
//        List<Stock> stock = new ArrayList<>();
//        stock.add(new Stock(pf));
//        stock.add(new Stock(az));
//        Vaccination_Centre vc = new Vaccination_Centre();
//        vc.setStock(stock);
//        vc.centreId = UUID.randomUUID().toString();
//        vc.name = "Test";
//
//        File_Helper.saveData(vc, "Vaccination_Centre");
//
//        String vcData = File_Helper.readFile(vc.getFileName());
//        Vaccination_Centre vcFromFile = File_Helper.gsonWriter.fromJson(vcData, Vaccination_Centre.class);
//        List<Stock> stock2 = vcFromFile.getStock();
//        System.out.println(stock2.get(0).getVaccine().getBatchNumber());
//        
//        List<String> vcDataArray = File_Helper.readFolder("Vaccination_Centre");
//        List<Vaccination_Centre> vcList = new ArrayList();
//
//        vcDataArray.forEach(fileInFolder -> {
//            vcList.add(File_Helper.gsonWriter.fromJson(fileInFolder, Vaccination_Centre.class));
//        });
//
//        vcList.forEach(f -> {
//            f.getStock().forEach(s -> {
//                System.out.println(s.getVaccine().getBatchNumber());
//            });
//
//        });


        //Main end
    }

//Class end
}
