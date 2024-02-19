import java.io.*;
import javax.swing.*;
import java.awt.*;


class tdeeCalculator{
    public static void main(String[] args) {

        // create instance of JFrame
        JFrame frame = new JFrame();

        // age label
        JLabel age = new JLabel("Age:");
        age.setBounds(100, 50, 120, 80);
        frame.add(age);

        // age text field
        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(220,70,100,30);
        frame.add(ageTextField);

        // years label
        JLabel years = new JLabel("years");
        years.setBounds(330,70,100,30);
        frame.add(years); 

        // Gender label
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 100, 120, 80);
        frame.add(gender);

        // gender checkbox
        CheckboxGroup cbg = new CheckboxGroup();  
        Checkbox maleCheckBox = new Checkbox("Male", cbg, true);
        maleCheckBox.setBounds(220,100,100,30);

        Checkbox femaleCheckBox = new Checkbox("Female", cbg, false);
        femaleCheckBox.setBounds(220,150,100,30);
        
        frame.add(maleCheckBox);
        frame.add(femaleCheckBox);


        // calculate button
        JButton button = new JButton("Calculate");
        button.setBounds(150,300,220,50);
        frame.add(button);

        // GUI
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}