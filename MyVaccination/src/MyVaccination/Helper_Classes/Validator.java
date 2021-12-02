package MyVaccination.Helper_Classes;

import java.awt.HeadlessException;
import java.util.regex.*;
import javax.swing.*;

public class Validator extends InputVerifier {
//Class for validating input fields
    JFrame mainComponent;
    
  public  Validator() {
        this.mainComponent = null;
    }
    
  public  Validator(JFrame mainComponent) {
        this.mainComponent = mainComponent;
    }
    

    @Override
    public boolean verify(JComponent input) {
        String type = (input.getName());
        String text = ((JTextField) input).getText();
        Pattern regexPattern;
        Matcher regexMatcher;
        try {
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(mainComponent, "Please do not leave this textfield empty", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            //Validating input...
            switch (type) {
                case "Email" -> {
                    regexPattern = Pattern.compile("(.*)@\\D*.\\D*");
                    regexMatcher = regexPattern.matcher(text);
                    if (regexMatcher.matches()) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(mainComponent, "Invalid format. Please ensure that your email address is of a valid format", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                case "Name" -> {
                    regexPattern = Pattern.compile("\\A\\D*\\Z");
                    regexMatcher = regexPattern.matcher(text);
                    if (regexMatcher.matches()) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(mainComponent, "Invalid format. Please ensure that your input does not have numbers.", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
                case "Phone" -> {
                    regexPattern = Pattern.compile("\\d{3}-\\d{7,8}");
                    regexMatcher = regexPattern.matcher(text);
                    if (regexMatcher.matches()) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(mainComponent, "Invalid format. Please ensure that your phone number follows this format: 999-9999999", "Invalid Format", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }

                default -> {
                    return true;
                }
            }
        } catch (HeadlessException e) {
            System.err.println("Verification error: " + e);
            return false;
        }
    }
}
