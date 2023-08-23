/*
 * CMPSCI 221 GUI Layout Lab
 * GUILayoutLab.java  
 * Purpose: To practice Java layouts
 *  
 * @author Mark Garas  
 * @version 1.0 3/4/2021
 */
package guilayoutlab;

// Importing necessary libraries
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseEvent;

public class GUILayoutLab extends JFrame{
    
    public static void main(String[] args) {
        
        ActionListener actionListener;
        
        // Creating, sizing, locating, adding exiting on close, and making look
        // nice
        JFrame frame = new JFrame("Printer");
        frame.setSize(650, 260);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creating first label, locating, and adding
        JLabel label1 = new JLabel("Printer: MyPrinter");
        label1.setBounds(50, 20, 200, 30);
        frame.add(label1);
        
        // Creating first textbox, locating, and adding
        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(50, 60, 100, 100);
        frame.add(textArea1);
        
        JTextArea textArea2 = new JTextArea();
        textArea2.setBounds(230, 60, 100, 100);
        frame.add(textArea2);
        
        JTextArea textArea3 = new JTextArea();
        textArea3.setBounds(410, 60, 100, 100);
        frame.add(textArea3);
        
        JLabel label2 = new JLabel("Print Quality: ");
        label2.setBounds(50, 170, 200, 30);
        frame.add(label2);
        
        // Creating first combo box (drop down menu), making the options array
        // for it, preselecting an option, locating, and adding
        String[] options = {"High", "Medium", "Low"};
        JComboBox comboBox1 = new JComboBox(options);
        comboBox1.setSelectedIndex(0);
        comboBox1.setBounds(150, 170, 75, 40);
        frame.add(comboBox1);
        
        JCheckBox checkBox4 = new JCheckBox("Print to File");
        checkBox4.setBounds(275, 170, 100, 15);
        frame.add(checkBox4);
        
        
        
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String str = event.getActionCommand();
                switch (str) {
                    case "button1":
                        textArea3.setText("OK pressed");
                        label1.setBounds(0, 0, 300, 30);
                        label1.setText("THIS WAS MOVED BY OK BUTTON!");
                        break;
                    case "button2":
                        textArea3.setText("Cancel pressed");
                        comboBox1.setSelectedIndex(1);
                        break;
                    case "button3":
                        textArea3.setText("Setup... pressed");
                        frame.setLocation(200, 200);
                        break;
                    case "button4":
                        textArea3.setText("Help pressed\n");
                        JFrame frameHelp = new JFrame("Printer");
                        frameHelp.setSize(100, 100);
                        frameHelp.setLocation(100, 100);
                        frameHelp.setDefaultCloseOperation
                                (JFrame.EXIT_ON_CLOSE);
                        JLabel label4 = new JLabel("No help Available...");
                        label4.setBounds(0, 0, 200, 15);
                        frameHelp.add(label4);
                        frameHelp.setLayout(null);
                        frameHelp.setVisible(true);
                        break;
                    case "checkBox1":
                        textArea1.setText("Image pressed");
                        break;
                    case "checkBox2":
                        textArea1.setText("Text pressed");
                        break;
                    case "checkBox3":
                        textArea1.setText("Code pressed");
                        break;
                    case "radio1":
                        textArea2.setText("Selection pressed");
                        break;
                    case "radio2":
                        textArea2.setText("All pressed");
                        break;
                    case "radio3":
                        textArea2.setText("Applet pressed");
                        break;
                }
            }
        };
        
        // Creating first button, locating, and adding (with actions)
        JButton button1 = new JButton("OK");
        button1.setBounds(530, 45, 80, 30);
        button1.setActionCommand("button1");
        button1.addActionListener(actionListener);
        frame.add(button1);
        
        JButton button2 = new JButton("Cancel");
        button2.setBounds(530, 85, 80, 30);
        button2.setActionCommand("button2");
        button2.addActionListener(actionListener);
        frame.add(button2);
        
        JButton button3 = new JButton("Setup...");
        button3.setBounds(530, 125, 80, 30);
        button3.setActionCommand("button3");
        button3.addActionListener(actionListener);
        frame.add(button3);
        
        JButton button4 = new JButton("Help");
        button4.setBounds(530, 165, 80, 30);
        button4.setActionCommand("button4");
        button4.addActionListener(actionListener);
        frame.add(button4);
        
        // Creating first check box, locating, and adding
        JCheckBox checkBox1 = new JCheckBox("Image");
        checkBox1.setBounds(150, 60, 75, 15);
        checkBox1.setActionCommand("checkBox1");
        checkBox1.addActionListener(actionListener);
        frame.add(checkBox1);
        
        JCheckBox checkBox2 = new JCheckBox("Text");
        checkBox2.setBounds(150, 75, 75, 15);
        checkBox2.setActionCommand("checkBox2");
        checkBox2.addActionListener(actionListener);
        frame.add(checkBox2);
        
        JCheckBox checkBox3 = new JCheckBox("Code");
        checkBox3.setBounds(150, 90, 75, 15);
        checkBox3.setActionCommand("checkBox3");
        checkBox3.addActionListener(actionListener);
        frame.add(checkBox3);
        
        // Creating first radio button, locating, and adding
        JRadioButton radio1 = new JRadioButton("Selection");
        radio1.setBounds(330, 60, 80, 15);
        radio1.setActionCommand("radio1");
        radio1.addActionListener(actionListener);
        frame.add(radio1);
        
        JRadioButton radio2 = new JRadioButton("All");
        radio2.setBounds(330, 75, 80, 15);
        radio2.setActionCommand("radio2");
        radio2.addActionListener(actionListener);
        frame.add(radio2);
        
        JRadioButton radio3 = new JRadioButton("Applet");
        radio3.setBounds(330, 90, 80, 15);
        radio3.setActionCommand("radio3");
        radio3.addActionListener(actionListener);
        frame.add(radio3);
        
        // Letting me set it up manually, and showing it
        frame.setLayout(null);
        frame.setVisible(true);
    }
}