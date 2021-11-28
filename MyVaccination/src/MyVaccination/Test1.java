package MyVaccination; 

import MyVaccination.Gson.LocalDateAdapter;
import MyVaccination.Classes.*;
import MyVaccination.Helper_Classes.File_Helper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

//    user1.Login("010515-07-0390", "Chang", "chang06", "Non-Citizen");
//    user2.setLogin(UUID.randomUUID().toString(), "Tan", "tan02", "Non-Citizen");
//    user3.setLogin(UUID.randomUUID().toString(), "Lim", "lim03", "Personnel");

    // Create file
//    File_Helper.saveData(user1, "User_Account");
//    File_Helper.saveData(user2, "User_Account");
//    File_Helper.saveData(user3, "User_Account");

    // Read single file
//    String objFile = user1.getFileName();
//    String userData = File_Helper.readFile(user1.getFileName());
//    User userFromFile = File_Helper.gsonWriter.fromJson(userData, User.class);
//    System.out.println(userFromFile.getUserId());
//    System.out.println(userFromFile.getUsername());
//    System.out.println(userFromFile.getPassword());
//    System.out.println(userFromFile.getUserType());

    // Read folder
//    List<String> userDataArray = File_Helper.readFolder("User_Account");
//    List<User> userList = new ArrayList();
//
//    userDataArray.forEach(fileInFolder -> {
//        userList.add(File_Helper.gsonWriter.fromJson(fileInFolder, User.class));
//    });
//
//    userList.forEach(f ->  {
//            System.out.println("Record : " + f.getUserId() + ", " + f.getUsername() + ", " + f.getPassword() + ", " + f.getUserType());
//    });

    // Convert String to LocalDate
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd Month yyyy");
//    String date = "2001-01-01";
//    LocalDate localDate = LocalDate.parse(date, formatter);
//    System.out.println(localDate.toString());
    
    // Test using parent method with child class
//    People ppl = new People();
//    People ppl = new People("chlide", localDate, "010919-04-1234", "Malaysian", "Not Vaccinated", "KL", "Male");
//    ppl.Login("childeID", "010919-04-1234", "childe123", "Citizen");  
////    User acc = ppl.getUser();
//    File_Helper.saveData(ppl, "User_Account");    
    
//    System.out.println(ppl.getUserId());
//    System.out.println(ppl.getUsername());
//    System.out.println(ppl.getName());
//    System.out.println(ppl.getDob());

//    // Get Vaccination Centre List from Appointment text file
//        // Read folder
//        List<String> appDataArray = File_Helper.readFolder("Appointment");
//        List<Appointment> appointmentList = new ArrayList();
//        ArrayList<String> arrApp = new ArrayList<String>();
//
//        appDataArray.forEach(fileInFolder -> {
//            appointmentList.add(File_Helper.gsonWriter.fromJson(fileInFolder, Appointment.class));
//        });
//
//        // Get centre ID
//        appointmentList.forEach(f ->  {
//            if("Public".equals(f.getAppointmentType())){
//                arrApp.add(f.getCentreId());
//            }
//        });
//        
//        // Remove duplicate centre ID
//        ArrayList<String> centreList = new ArrayList<String>();
//  
//        for (String element : arrApp) {
//            if (!centreList.contains(element)) {
//  
//                centreList.add(element);
//            }
//        }
//        
//        System.out.println("arrApp: " + arrApp);
//        System.out.println("centreList: " + centreList);
//        
//        // Get centre Name
//        List<String> centreDataArray = File_Helper.readFolder("Vaccination_Centre");
//        List<Vaccination_Centre> centreNameList = new ArrayList();
//        ArrayList<String> arrCentreName = new ArrayList<String>();
//        ArrayList<String> showCentreName = new ArrayList<String>();
//
//        centreDataArray.forEach(fileInFolder -> {
//            centreNameList.add(File_Helper.gsonWriter.fromJson(fileInFolder, Vaccination_Centre.class));
//        });
//        
//        // Traverse through the first list
//        for (String element : centreList) {
//            for (Vaccination_Centre centre: centreNameList){
//                if (centre.getCentreId().equals(element)) {
//                    showCentreName.add(centre.getName());
//                }
//            }
//        }
//        
//        System.out.println("showCentreName: " + showCentreName);

    // Get wait time
    String id = "US_a0c7f37a-9c42-44f5-ad28-8d467c4bb56c";
    String userData = File_Helper.readFile("User_Account/" + id + ".txt");
    People userFromFile = File_Helper.gsonWriter.fromJson(userData, People.class);
    List<String> vacHistory = userFromFile.getVacHistory();
    String apt = userFromFile.getVacHistory().get(0);
    
    
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
