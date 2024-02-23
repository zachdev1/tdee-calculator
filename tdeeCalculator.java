import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * TODO: output BMR and TDEE to GUI
 */

class tdeeCalculator{
    private static JTextField ageTextField;
    private static Checkbox maleCheckbox;
    private static Checkbox femaleCheckbox;
    private static JTextField weightTextField;
    private static JComboBox<String> heightDropdown;
    private static JComboBox<String> activityLevelDropdown;
    private static Checkbox cuttingCheckbox;
    private static Checkbox bulkingCheckbox; 


    public static int calculateBMR(){
        int bmr = 0;

        // Get values from text fields and checkboxes
        int age = Integer.parseInt(ageTextField.getText());
        double weight = Double.parseDouble(weightTextField.getText());
        String selectedHeight = (String) heightDropdown.getSelectedItem();
        double heightInCm = convertHeight(selectedHeight);
        boolean isMale = maleCheckbox.getState();
        boolean isFemale = femaleCheckbox.getState();

        // convert weight to kg
        weight /= 2.205; 

        // Calculate BMR based on gender
        if(isMale){
            bmr = (int) ((10 * weight) + (6.25 * heightInCm) - (5 * age) + 5);
        } else if (isFemale){
            bmr = (int) ((10 * weight) + (6.25 * heightInCm) - (5 * age) - 161);
        }

        return bmr; 
    }

    public static int calculateTDEE(){
        int tdee = 0;
        int bmr = calculateBMR();

        String selectedActivity = (String) activityLevelDropdown.getSelectedItem();

        if(selectedActivity.equals("Sedentary (office job)")){
            tdee = (int) (bmr * 1.2);
        } else if(selectedActivity.equals("Light Exercise (1-2 days/weeks)")){
            tdee = (int) (bmr * 1.375);
        } else if(selectedActivity.equals("Moderate Exercise (3-5 days/weeks)")){
            tdee = (int) (bmr * 1.55);
        } else if(selectedActivity.equals("Heavy Exercise (6-7 days/weeks)")){
            tdee = (int) (bmr * 1.725);
        } else if(selectedActivity.equals("Athlete (2x per day)")){
            tdee = (int) (bmr * 1.9);
        } 
        return tdee; 
    }

    public static int deficitOrSurplus(){
        boolean cutting = cuttingCheckbox.getState();
        boolean bulking = bulkingCheckbox.getState();

        int kcals = 0;
        int tdee = calculateTDEE(); 

        if(cutting){
            kcals = tdee - 500; 
        } else if(bulking){
            kcals = tdee + 500;
        }

        return kcals; 
    }

    private static int convertHeight(String height){
        // Convert height from format X'Y" to centimeters
        String[] parts = height.split("'");
        int feet = Integer.parseInt(parts[0]);
        int inches = Integer.parseInt(parts[1].replace("\"", ""));
        return (int) ((feet * 30.48) + (inches * 2.54));
    }

    public static void main(String[] args){

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
        ageTextField = new JTextField();
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
        maleCheckbox = new Checkbox("Male", cbg, false);
        maleCheckbox.setBounds(200,125,50,30);

        femaleCheckbox = new Checkbox("Female", cbg, false);
        femaleCheckbox.setBounds(275,125,100,30);
        
        frame.add(maleCheckbox);
        frame.add(femaleCheckbox);

        // weight label
        JLabel weight = new JLabel("Weight:");
        weight.setBounds(100, 150, 120, 80);
        frame.add(weight);

        // weight text field
        weightTextField = new JTextField();
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
        heightDropdown = new JComboBox<>(new String[] { "4'10", "4'11",
        "5'0", "5'1", "5'2", "5'3", "5'4", "5'5", "5'6", "5'7", "5'8", "5'9",
        "5'10", "5'11",
        "6'0", "6'1", "6'2", "6'3", "6'4", "6'5", "6'6", "6'7", "6'8", "6'9",
        "7'0" });
        heightDropdown.setBounds(200, 225, 100, 30); // Adjust the bounds as needed
        frame.add(heightDropdown);

        // activity level label
        JLabel activityLevel = new JLabel("Activity Level:");
        activityLevel.setBounds(100, 250, 100, 80);
        frame.add(activityLevel);

        // activityLevel comboBox
        activityLevelDropdown = new JComboBox<>(new String[] { "Sedentary (office job)", "Light Exercise (1-2 days/weeks)", "Moderate Exercise (3-5 days/weeks)", "Heavy Exercise (6-7 days/weeks)", "Athlete (2x per day)" });
        activityLevelDropdown.setBounds(200, 275, 220, 30); // Adjust the bounds as needed
        frame.add(activityLevelDropdown);

        // goal label
        JLabel goal = new JLabel("Goal:");
        goal.setBounds(100, 300, 50, 80);
        frame.add(goal);

        // goal checkbox
        CheckboxGroup goalcbg = new CheckboxGroup();

        cuttingCheckbox = new Checkbox("Cutting", goalcbg, false);
        cuttingCheckbox.setBounds(200,325,75,30);

        bulkingCheckbox = new Checkbox("Bulking", goalcbg, false);
        bulkingCheckbox.setBounds(275,325,100,30);
        
        frame.add(cuttingCheckbox);
        frame.add(bulkingCheckbox);
        


        // calculate button
        JButton button = new JButton("Calculate");
        button.setBounds(150,380,200,50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int bmr = calculateBMR();
                int tdee = calculateTDEE();
                int kcals = deficitOrSurplus();

                // DEBUG
                System.out.println(bmr);
                System.out.println(tdee);
                System.out.println(kcals);
            }
        });

        frame.add(button);

        // GUI
        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}