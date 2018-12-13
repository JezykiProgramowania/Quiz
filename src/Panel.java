package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.ArrayList;

public class Panel {
	
//List<JPanel> JPanelList = new ArrayList<>();
JPanel panel;
public JButton NextButton;
public JButton ExitButton;
public JTextField textField;
public JRadioButton RadioButtonA;
public JRadioButton RadioButtonB;
public JRadioButton RadioButtonC;
public JRadioButton RadioButtonD;

	JPanel MakePanel(JFrame frame,String question) {
		panel = new JPanel();
		panel.setBounds(0, -33, 432, 286);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		
		NextButton = new JButton("Next question");
		NextButton.setForeground(Color.RED);
		NextButton.setBounds(262, 134, 138, 62);
		panel.add(NextButton);
		
		ExitButton = new JButton("Exit");
		ExitButton.setForeground(Color.RED);
		ExitButton.setBounds(0, 134, 150, 62);
		panel.add(ExitButton);
		/*
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 23));
		textField.setBackground(Color.BLUE);
		textField.setForeground(Color.PINK);
		textField.setBounds(67, 8, 276, 62);
		panel.add(textField);
		textField.setEditable(false);
		textField.setText(question);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(0, 50, 600, 200);
		textPane.setText(question);
		panel.add(textPane);
		panel = new JPanel();
		panel.setBounds(0, 0, 472, 315);
		frame.getContentPane().add(panel);
		*/
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridheight = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		panel.add(textField, gbc_textField_1);
		textField.setColumns(10);
		textField.setText(question);
		textField.setEditable(false);
		
		RadioButtonA = new JRadioButton("odp A");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 1;
		gbc_rdbtnNewRadioButton_2.gridy = 3;
		panel.add(RadioButtonA, gbc_rdbtnNewRadioButton_2);
		
		RadioButtonB = new JRadioButton("odp B");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		panel.add(RadioButtonB, gbc_rdbtnNewRadioButton_1);
		
		RadioButtonC = new JRadioButton("odp C");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 5;
		panel.add(RadioButtonC, gbc_rdbtnNewRadioButton);
		
		RadioButtonD = new JRadioButton("odp D");
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 6;
		panel.add(RadioButtonD, gbc_rdbtnNewRadioButton_3);
		
		NextButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		panel.add(NextButton, gbc_btnNewButton);
		
		ExitButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		panel.add(ExitButton, gbc_btnNewButton_1);
		return panel;
	}
	/*
	JPanel MakePanel(JFrame frame,String question) {
		JPanelList.add(new JPanel());
		JPanel newPanel = JPanelList.get(JPanelList.size() -1);
		newPanel.setBounds(0, -33, 432, 286);
		frame.getContentPane().add(newPanel);
		newPanel.setVisible(false);
		newPanel.setLayout(null);
		
		
		NextButton = new JButton("Next question");
		NextButton.setForeground(Color.RED);
		NextButton.setBounds(262, 134, 138, 62);
		newPanel.add(NextButton);
		
		ExitButton = new JButton("Exit");
		ExitButton.setForeground(Color.RED);
		ExitButton.setBounds(262, 134, 138, 62);
		newPanel.add(ExitButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 23));
		textField.setBackground(Color.BLUE);
		textField.setForeground(Color.PINK);
		textField.setBounds(67, 8, 276, 62);
		newPanel.add(textField);
		textField.setEditable(false);
		textField.setText(question);
		textField.setColumns(10);
		
		return newPanel;
	}
	*/
}
