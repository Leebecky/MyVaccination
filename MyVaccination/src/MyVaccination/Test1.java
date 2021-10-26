package MyVaccination; 

import MyVaccination.Gson.LocalDateAdapter;
import MyVaccination.Classes.*;
//import MyVaccination.Classes.User;
import MyVaccination.Helper_Classes.File_Helper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Test1 {
    public static void main(String[] args) {
    // new FileHelper write read fie
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    user1.setLogin(UUID.randomUUID().toString(), "Lee", "lee01", "Citizen");
    user2.setLogin(UUID.randomUUID().toString(), "Tan", "tan02", "Non-Citizen");
    user3.setLogin(UUID.randomUUID().toString(), "Lim", "lim03", "Personnel");
//    user1.getFileName();
//    user1.getUserType();

//    ArrayList<User> user = new ArrayList<User>();
//    user.add(user1);
//    user.add(user2);
//    user.add(user3);
    
//    AstraZeneca az = new AstraZeneca();
//    Pfizer pf = new Pfizer();
//    List<Stock> stock = new ArrayList<>();
//    stock.add(new Stock(pf));
//    stock.add(new Stock(az));
//    Vaccination_Centre vc = new Vaccination_Centre();
//    vc.setStock(stock);
//    vc.centreId = UUID.randomUUID().toString();
//    vc.name = "Test";
//    File_Helper.saveData(vc, "Vaccination_Centre");

//    File_Helper.saveData(user1, "UserAccount");
    File_Helper.saveData(user2, "UserAccount");
    File_Helper.saveData(user3, "UserAccount");

//    String vcData = File_Helper.readFile(user1.getFileName());
//    System.out.println("vcData: " + vcData);
//    MyVaccination.Classes.Vaccination_Centre vcFromFile = File_Helper.gsonWriter.fromJson(vcData, MyVaccination.Classes.Vaccination_Centre.class);
//    List<Stock> stock2 = vcFromFile.getStock();
//    System.out.println(stock2.get(0).getVaccine().getBatchNumber());
//
//    List<String> vcDataArray = File_Helper.readFolder("Vaccination_Centre");
//    List<MyVaccination.Classes.Vaccination_Centre> vcList = new ArrayList();
//
//    vcDataArray.forEach(fileInFolder -> {
//        vcList.add(File_Helper.gsonWriter.fromJson(fileInFolder, MyVaccination.Classes.Vaccination_Centre.class));
//    });
//
//    vcList.forEach(f -> {
//        f.getStock().forEach(s -> {
//            System.out.println(s.getVaccine().getBatchNumber());
//        });
//    });
        
//  ===========================================
        
    // old Gson write file read file 
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        
//        user1.setLogin("U01", "Lee", "lee01", "Citizen");
//        user2.setLogin("U02", "Tan", "tan02", "Non-Citizen");
//        user3.setLogin("U03", "Lim", "lim03", "Personnel");
//        
//        ArrayList<User> user = new ArrayList<User>();
//        user.add(user1);
//        user.add(user2);
//        user.add(user3);
//        
//        System.out.println("User Array List: " + user);
//        System.out.println("User Array List: " + user1);
//        System.out.println("User Array List: " + user2);
//        System.out.println("User Array List: " + user3);

//        user.forEach(v -> {
//            System.out.println(v.username);
//            System.out.println(v.password);
//        }); 
        
//        String strDob = "2001-08-16";
//        LocalDate dob = LocalDate.parse(strDob);
//        People ppl = new People("Lee Wen Xi", dob, "010515070990", "Malaysian", "Not Vaccinated", "Penang", "Female");
//        
//        ArrayList<People> arrPpl = new ArrayList<People>();
//        arrPpl.add(ppl);
//        
//        //registerTypeAdapter so that the JSON can handle LocalDate type
//        Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
//
//        try {
//            FileWriter myWriter = new FileWriter("people.txt");
//            myWriter.write(g.toJson(arrPpl));
//            
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        // read from file
//        try {
//            File myObj = new File("people.txt");
//            Scanner myReader = new Scanner(myObj);
//            
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//
//                List<People> a = File_Helper.parseGsonArray(data, People[].class);
////                System.out.println(a.get(0).getUsername());
////                System.out.println("User List : " + a);
//                
//                for(int i=0; i<a.size(); i++){
////                    System.out.println("User List : " + a.get(i));
////                    System.out.println(a.get(i).getUsername() + "," + a.get(i).getPassword());
//                    System.out.println(a.get(i).getName() + "," + a.get(i).getDob());
//                }
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        
//        // Random Generate Number
//        String ranNum = UUID.randomUUID().toString();
//        System.out.println("Random Number : " + ranNum);
//        System.out.println("Random Number : " + ranNum.substring(24, 36));

    }
}
