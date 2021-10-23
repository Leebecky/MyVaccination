package MyVaccination; 

import MyVaccination.Gson.LocalDateAdapter;
import static MyVaccination.MyVaccination.parseGsonArray;
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
        
        String strDob = "2001-08-16";
        LocalDate dob = LocalDate.parse(strDob);
        People ppl = new People("Lee Wen Xi", dob, "010515070990", "Malaysian", "Not Vaccinated", "Penang", "Female");
        
        ArrayList<People> arrPpl = new ArrayList<People>();
        arrPpl.add(ppl);
        
        //registerTypeAdapter so that the JSON can handle LocalDate type
        Gson g = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

        try {
            FileWriter myWriter = new FileWriter("people.txt");
            myWriter.write(g.toJson(arrPpl));
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // read from file
        try {
            File myObj = new File("people.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                List<People> a = parseGsonArray(data, People[].class);
//                System.out.println(a.get(0).getUsername());
//                System.out.println("User List : " + a);
                
                for(int i=0; i<a.size(); i++){
//                    System.out.println("User List : " + a.get(i));
//                    System.out.println(a.get(i).getUsername() + "," + a.get(i).getPassword());
                    System.out.println(a.get(i).getName() + "," + a.get(i).getDob());
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        // Random Generate Number
        String ranNum = UUID.randomUUID().toString();
        System.out.println("Random Number : " + ranNum);
        System.out.println("Random Number : " + ranNum.substring(24, 36));

    }
}
