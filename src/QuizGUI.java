package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JTextPane;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.Insets;

import javax.swing.JEditorPane;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


public class QuizGUI extends JFrame {

	
    public JFrame frame;
	private JTextField textField;
	private JButton ExitButton;
	
	private int CorrectAns = 0;
	private String filename;
	Container contentPane;
	private JPanel MenuPanel;
	
	
	//public Panel panel;
	public static int currentQuestion = 0;
	private JPanel QuestionPanel;
	private JButton NextButton;
	private JButton ExitButtonQuestion;
	private JTextArea QuestionText;
	private JPanel ScorePanel;
	private JTextArea textAreaScore;
	private JPanel CategoryMenu;
	private JTextArea txtrPleaseChooseA;
	private JButton MathButton;
	private JButton biologyButton;
	private JButton ChemistryButton;
	private JButton EditButton;
	private JPanel EditCategory;
	private JButton EditBiologyButton;
	private JButton EditMathButton;
	private JButton EditChemistry;
	private JTextArea txtrWhichCategoryDo;
	private JPanel Edit;
	private JButton SaveButton;
	
	
	
	/////////////////////////////////////////////////
	//////////////////////////
	public List<Question> Setup(String filename) {
		Interface inter = new Interface();
		List<Question> QuestionList = new ArrayList<>();
		try { 
			QuestionList = inter.OpenFile(filename);
		} catch(IOException e) {
			
		}
		
		
		return QuestionList;
	}
	
	void showCategories() {
		MenuPanel.setVisible(false);
		CategoryMenu.setVisible(true);
		
	}
	void resetRadio(JRadioButton rbtn, JRadioButton rbtn2, JRadioButton rbtn3 ,JRadioButton rbtn4) {
		rbtn.setSelected(false);
		rbtn2.setSelected(false);
		rbtn3.setSelected(false);
		rbtn4.setSelected(false);
	}
	
	
	public static void load(JTextComponent text, String inputFile) {
			 
		FileReader inputReader = null;
		try {
			inputReader = new FileReader(inputFile);
			  text.read(inputReader, inputFile);
			  inputReader.close();
		} catch (Exception e){
			
		}
			  
			    }
	
	
	public static void save(JTextComponent text, String inputFile) {
	  FileWriter writer = null;
		try {
			 writer = new FileWriter(inputFile);
				text.write(writer);
				writer.close();
		} catch (Exception e) {
			
		}
	 
			    }
	//////////////////////////
	/////////////////////////////////////////////////
	//Changing Panels
	public void ChangePanel(List<Question> QuestionList) {
		if(currentQuestion == QuestionList.size()) {
			for(Question q : QuestionList) {
				System.out.println("ile poprawnych: " + q.isCorrect);
				QuestionPanel.setVisible(false);
				ScorePanel.setVisible(true);
				textAreaScore.setText("Congratulations!!! \n You have scored " + CorrectAns + " points out of " + QuestionList.size() + " total");
				currentQuestion = 0;
			}	
		}
		else{
			CategoryMenu.setVisible(false);
			QuestionPanel.setVisible(true);	
			//if(QuestionList.get(currentQuestion).getAns().equals())
			QuestionText.setText(QuestionList.get(currentQuestion).getQuestion());
			
			
			currentQuestion++;
		}
			
     }
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizGUI window = new QuizGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuizGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 728, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	     
		
		final List<Question> QuestionListMath = Setup("math.txt");
		final List<Question> QuestionListBiology = Setup("biology.txt");
	    List<Question> QuestionList;
		
		Edit = new JPanel();
		Edit.setBackground(new Color(153, 102, 153));
		Edit.setBounds(0, 0, 710, 418);
		frame.getContentPane().add(Edit);
		Edit.setVisible(false);
		
		final JTextPane editorPane = new JTextPane();
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setBounds(0, 0, 698, 266);
		Edit.add(editorPane);
		
		
		SaveButton = new JButton("Save Changes");
		SaveButton.setBounds(57, 290, 176, 115);
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save(editorPane,filename);
				Edit.setVisible(false);
				MenuPanel.setVisible(true);
			}
		});
		Edit.setLayout(null);
		SaveButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Edit.add(SaveButton);
		
		
		
		
		
		
		MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(153, 153, 102));
		MenuPanel.setForeground(Color.WHITE);
		MenuPanel.setBounds(0, 0, 710, 429);
		frame.getContentPane().add(MenuPanel);
		MenuPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 23));
		textField.setBackground(Color.BLUE);
		textField.setForeground(Color.PINK);
		textField.setBounds(99, 30, 276, 62);
		MenuPanel.add(textField);
		textField.setEditable(false);
		textField.setText("Welcome to our Quiz");
		textField.setColumns(10);
		
		ExitButton = new JButton("New button");
		ExitButton.setForeground(Color.RED);
		ExitButton.setBounds(453, 319, 138, 62);
		MenuPanel.add(ExitButton);
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitButton.setText("EXIT");
		
		
		JButton StartButton = new JButton("New button");
		StartButton.setForeground(Color.DARK_GRAY);
		StartButton.setBounds(68, 317, 145, 62);
		MenuPanel.add(StartButton);
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showCategories();
				//ChangePanel(QuestionList);
				
			}
		});
		StartButton.setText("NEW QUIZ");
		StartButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		EditButton = new JButton("Edit Question");
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPanel.setVisible(false);
				EditCategory.setVisible(true);
			}
		});
		EditButton.setBounds(242, 218, 168, 56);
		MenuPanel.add(EditButton);
		
		ScorePanel = new JPanel();
		ScorePanel.setBounds(0, 0, 710, 418);
		frame.getContentPane().add(ScorePanel);
		ScorePanel.setLayout(null);
		ScorePanel.setVisible(false);
		
		textAreaScore = new JTextArea();
		textAreaScore.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textAreaScore.setBackground(new Color(204, 153, 153));
		textAreaScore.setForeground(new Color(0, 0, 0));
		textAreaScore.setBounds(120, 59, 454, 252);
		ScorePanel.add(textAreaScore);
		
		EditCategory = new JPanel();
		EditCategory.setBackground(new Color(204, 153, 204));
		EditCategory.setBounds(0, 0, 710, 418);
		frame.getContentPane().add(EditCategory);
		EditCategory.setLayout(null);
		EditCategory.setVisible(false);
		
		EditBiologyButton = new JButton("Biology");
		
		EditBiologyButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		EditBiologyButton.setBounds(60, 239, 135, 62);
		EditCategory.add(EditBiologyButton);
		
		EditMathButton = new JButton("Mathematics");
		
		EditMathButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		EditMathButton.setBounds(242, 239, 154, 62);
		EditCategory.add(EditMathButton);
		
		EditChemistry = new JButton("Chemistry");
		EditChemistry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		EditChemistry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EditChemistry.setBounds(473, 239, 128, 62);
		EditCategory.add(EditChemistry);
		
		txtrWhichCategoryDo = new JTextArea();
		txtrWhichCategoryDo.setBackground(new Color(204, 102, 51));
		txtrWhichCategoryDo.setFont(new Font("Monospaced", Font.PLAIN, 22));
		txtrWhichCategoryDo.setText("Which Category do you want to edit?");
		txtrWhichCategoryDo.setEditable(false);
		txtrWhichCategoryDo.setBounds(0, 0, 710, 116);
		EditCategory.add(txtrWhichCategoryDo);
		
		EditMathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditCategory.setVisible(false);
				Edit.setVisible(true);
				filename = "math.txt";
				load(editorPane, filename);
			}
		});
		
		EditBiologyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditCategory.setVisible(false);
				Edit.setVisible(true);
				filename = "biology.txt";
				load(editorPane, filename);
				
			}
		});
		CategoryMenu = new JPanel();
		CategoryMenu.setBackground(new Color(153, 102, 102));
		CategoryMenu.setBounds(0, 0, 710, 418);
		frame.getContentPane().add(CategoryMenu);
		CategoryMenu.setLayout(null);
		CategoryMenu.setVisible(false);
		
		txtrPleaseChooseA = new JTextArea();
		txtrPleaseChooseA.setBackground(new Color(0, 204, 51));
		txtrPleaseChooseA.setFont(new Font("Monospaced", Font.BOLD, 29));
		txtrPleaseChooseA.setText("Please choose a category");
		txtrPleaseChooseA.setBounds(12, 35, 686, 49);
		CategoryMenu.add(txtrPleaseChooseA);
		
		MathButton = new JButton("Mathematics");
		MathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePanel(QuestionListMath);
				filename = "math.txt";
			}
		});
		MathButton.setBackground(new Color(51, 204, 153));
		MathButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		MathButton.setBounds(57, 180, 137, 70);
		CategoryMenu.add(MathButton);
		
		biologyButton = new JButton("Biology");
		biologyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePanel(QuestionListBiology);
				filename = "biology.txt";
			}
		});
		biologyButton.setBackground(new Color(51, 204, 0));
		biologyButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		biologyButton.setBounds(278, 180, 127, 70);
		CategoryMenu.add(biologyButton);
		
		ChemistryButton = new JButton("Chemistry");
		ChemistryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ChangePanel(QuestionListChemistry);
			}
		});
		ChemistryButton.setBackground(new Color(0, 204, 51));
		ChemistryButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ChemistryButton.setBounds(503, 180, 114, 70);
		CategoryMenu.add(ChemistryButton);
		
		QuestionPanel = new JPanel();
		QuestionPanel.setBounds(0, 0, 710, 418);
		frame.getContentPane().add(QuestionPanel);
		QuestionPanel.setLayout(null);
		QuestionPanel.setVisible(false);
		NextButton = new JButton("Next Question");
		
		NextButton.setBounds(43, 325, 125, 54);
		QuestionPanel.add(NextButton);
		
		ExitButtonQuestion = new JButton("Exit Quiz");
		ExitButtonQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ExitButtonQuestion.setBounds(180, 325, 125, 54);
		QuestionPanel.add(ExitButtonQuestion);
		
		final JRadioButton RadioButtonC = new JRadioButton("C");
		RadioButtonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans = "";
				if(filename == "math.txt") { ans = QuestionListMath.get(currentQuestion - 1).getAns();}
				if(filename == "biology.txt") { ans = QuestionListBiology.get(currentQuestion - 1).getAns();}
				if( ans.trim().equals("c")) {
					QuestionListMath.get(currentQuestion - 1).isCorrect = true;
					CorrectAns++;
					System.out.println("POPRAWNA?: " + QuestionListMath.get(currentQuestion - 1).getAns());
					
				} 
			}
		});
		
		RadioButtonC.setBounds(414, 295, 127, 25);
		QuestionPanel.add(RadioButtonC);
		
		final JRadioButton RadioButtonD = new JRadioButton("D");
		
		RadioButtonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ans = "";
				if(filename == "math.txt") { ans = QuestionListMath.get(currentQuestion - 1).getAns();}
				if(filename == "biology.txt") { ans = QuestionListBiology.get(currentQuestion - 1).getAns();}
				if( ans.trim().equals("d")) {
					QuestionListMath.get(currentQuestion - 1).isCorrect = true;
					System.out.println("Radio D dziala: " + QuestionListMath.get(currentQuestion - 1).getAns());
					CorrectAns++;
				}
			}
		});
		RadioButtonD.setBounds(414, 325, 127, 25);
		QuestionPanel.add(RadioButtonD);
		
		final JRadioButton RadioButtonB = new JRadioButton("B");
		RadioButtonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans = "";
				if(filename == "math.txt") { ans = QuestionListMath.get(currentQuestion - 1).getAns();}
				if(filename == "biology.txt") { ans = QuestionListBiology.get(currentQuestion - 1).getAns();}
				if( ans.trim().equals("b")) {
					QuestionListMath.get(currentQuestion - 1).isCorrect = true;
					//System.out.println("POPRAWNA?: " + QuestionList.get(currentQuestion - 1).getAns());
					CorrectAns++;
				}
			}
		});
		RadioButtonB.setBounds(414, 265, 127, 25);
		QuestionPanel.add(RadioButtonB);
		
		final JRadioButton RadioButtonA = new JRadioButton("A");
		RadioButtonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans = "";
				if(filename == "math.txt") { ans = QuestionListMath.get(currentQuestion - 1).getAns();}
				if(filename == "biology.txt") { ans = QuestionListBiology.get(currentQuestion - 1).getAns();}
				if( ans.trim().equals("a")) {
					QuestionListMath.get(currentQuestion - 1).isCorrect = true;
					//System.out.println("POPRAWNA?: " + QuestionList.get(currentQuestion - 1).getAns());
					CorrectAns++;
				}
			}
		});
		RadioButtonA.setBounds(414, 226, 127, 25);
		QuestionPanel.add(RadioButtonA);
		
		QuestionText = new JTextArea();
		QuestionText.setFont(new Font("Monospaced", Font.PLAIN, 14));
		QuestionText.setEditable(false);
		QuestionText.setBounds(0, 0, 698, 211);
		QuestionPanel.add(QuestionText);

		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(filename == "biology.txt")ChangePanel(QuestionListBiology);
				else if(filename == "math.txt") ChangePanel(QuestionListMath);
				resetRadio(RadioButtonA, RadioButtonB, RadioButtonC, RadioButtonD);
			}
		});
		
		
	}
}

