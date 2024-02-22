import java.io.*;
import javax.swing.*;
import java.awt.*;


class tdeeCalculator{
    public static void main(String[] args) {

        // create instance of JFrame
        JFrame frame = new JFrame("Tdee-Calculator");

        JLabel tdeeCalculator = new JLabel("Tdee-Calculator");
        tdeeCalculator.setBounds(150, 10, 600, 80);
        tdeeCalculator.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(tdeeCalculator);

        // age label
        JLabel age = new JLabel("Age:");
        age.setBounds(100, 50, 120, 80);
        frame.add(age);

        // age text field
        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(220,75,60,30);
        frame.add(ageTextField);

        // years label
        JLabel years = new JLabel("years");
        years.setBounds(300,75,50,30);
        frame.add(years); 

        // gender label
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 100, 60, 80);
        frame.add(gender);

        // gender checkbox
        CheckboxGroup cbg = new CheckboxGroup();  
        Checkbox maleCheckBox = new Checkbox("Male", cbg, false);
        maleCheckBox.setBounds(200,125,50,30);

        Checkbox femaleCheckBox = new Checkbox("Female", cbg, false);
        femaleCheckBox.setBounds(275,125,100,30);
        
        frame.add(maleCheckBox);
        frame.add(femaleCheckBox);

        // weight label
        JLabel weight = new JLabel("Weight:");
        weight.setBounds(100, 150, 120, 80);
        frame.add(weight);

        // weight text field
        JTextField weightTextField = new JTextField();
        weightTextField.setBounds(220, 175, 60, 30);
        frame.add(weightTextField);

        // ibs label
        JLabel ibs = new JLabel("lbs");
        ibs.setBounds(300,175,20,30);
        frame.add(ibs);

        // height label
        JLabel height = new JLabel("Height:");
        height.setBounds(100, 200, 60, 80);
        frame.add(height);

        // height comboBox
        JComboBox<String> heightDropdown = new JComboBox<>(new String[] { "4'10", "4'11",
        "5'0", "5'1", "5'2", "5'3", "5'4", "5'5", "5'6", "5'7", "5'8", "5'9",
        "5'10", "5'11",
        "6'0", "6'1", "6'2", "6'3", "6'4", "6'5", "6'6", "6'7", "6'8", "6'9",
        "7'0" });
        heightDropdown.setBounds(200, 225, 100, 30); // Adjust the bounds as needed
        frame.add(heightDropdown);

        // activity levl label
        JLabel activityLevel = new JLabel("Activity Level:");
        activityLevel.setBounds(100, 250, 100, 80);
        frame.add(activityLevel);

        // height comboBox
        JComboBox<String> activityLevelDropdown = new JComboBox<>(new String[] { "Sedentary (office job)", "Light Exercise (1-2 days/weeks)", "Moderate Exercise (3-5 days/weeks)", "Heavy Exercise (6-7 days/weeks)", "Athlete (2x per day)" });
        activityLevelDropdown.setBounds(200, 275, 220, 30); // Adjust the bounds as needed
        frame.add(activityLevelDropdown);

         // goal label
         JLabel goal = new JLabel("Goal:");
         goal.setBounds(100, 300, 50, 80);
         frame.add(goal);
 
         // goal checkbox
         CheckboxGroup goalcbg = new CheckboxGroup();

         Checkbox cuttingCheckbox = new Checkbox("Cutting", goalcbg, false);
         cuttingCheckbox.setBounds(200,325,75,30);
 
         Checkbox bulkingCheckbox = new Checkbox("Bulking", goalcbg, false);
         bulkingCheckbox.setBounds(275,325,100,30);
         
         frame.add(cuttingCheckbox);
         frame.add(bulkingCheckbox);
        


        // calculate button
        JButton button = new JButton("Calculate");
        button.setBounds(150,380,200,50);
        frame.add(button);

        // GUI
        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}