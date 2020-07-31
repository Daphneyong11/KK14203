import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

class HeaderPanel extends JPanel{
   private JLabel header;
   public HeaderPanel(){
      	header = new JLabel("Course Evaluation Form");
      	add(header);
   }
}

//Form Panel
class FormPanel extends JPanel implements ActionListener, ItemListener{
   //list all UI components for the panel
   JLabel lbl_name;
   JTextField name;
   JLabel lbl_matric;
   JTextField matric;
   JLabel lbl_code;
   JComboBox<String> code;
   JLabel lbl_rating;
   JLabel lbl_outcome;
   JButton b_submit;
   JButton b_clear;
   JCheckBox c1;
   JCheckBox c2;
   JLabel lbl_output; 
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
   
   //global variable 
   String output="";
   String code_selection="";
   String rb_selection="";
   String cb_selection="";
   String filePath="data.txt"; //in the same directory
      
   public FormPanel(){   
      setLayout(new FlowLayout(FlowLayout.LEFT));     
      
      lbl_name = new JLabel("Name");
      lbl_name.setPreferredSize(new Dimension(150, 20));
      lbl_name.setBorder(border);
      
      add(lbl_name);
      name = new JTextField(20);
      add(name);
      
      lbl_matric = new JLabel("Matric No.");
      lbl_matric.setPreferredSize(new Dimension(150, 20));
      add(lbl_matric);
      matric = new JTextField(15);
      add(matric);   
      
      String[] courses={"[Select]", "KK14203 Java", "KT14203 Mathematics"};
      
      lbl_code = new JLabel("Course Code");
      lbl_code.setPreferredSize(new Dimension(150, 20));
      add(lbl_code);
      code = new JComboBox<String>(courses);
      add(code); 
      
      code.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            code_selection = (String) code.getSelectedItem();
         }
      });  
      
      lbl_rating = new JLabel("Rating");
      lbl_rating.setPreferredSize(new Dimension(150, 20));
      add(lbl_rating);
      
      //Radio buttons and action listener
      JRadioButton rb1 = new JRadioButton("1");
      rb1.addActionListener(this);
      JRadioButton rb2 = new JRadioButton("2");
      rb2.addActionListener(this);
      JRadioButton rb3 = new JRadioButton("3");
      rb3.addActionListener(this);
      JRadioButton rb4 = new JRadioButton("4");
      rb4.addActionListener(this);
      JRadioButton rb5 = new JRadioButton("5");
      rb5.addActionListener(this);
      add(rb1);
      add(rb2);
      add(rb3);
      add(rb4);
      add(rb5);
      
      //define button group
      ButtonGroup bg = new ButtonGroup();
      bg.add(rb1);
      bg.add(rb2);
      bg.add(rb3);
      bg.add(rb4);
      bg.add(rb5);
      
      lbl_outcome = new JLabel("Outcome");
      lbl_outcome.setPreferredSize(new Dimension(150, 20));
      add(lbl_outcome);
      
      //checkbox and  item listener
      c1 = new JCheckBox("Basic knowledge");
      c1.addItemListener(this);
      c2 = new JCheckBox("Advanced knowledge");
      c2.addItemListener(this);
      add(c1);
      add(c2);
      
      b_submit = new JButton("Submit");
      add(b_submit);
      b_clear = new JButton("Clear");
      add(b_clear);

      b_submit.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            if (rb1.isSelected())
               rb_selection="1";
            else if (rb2.isSelected())
               rb_selection="2";
            else if (rb3.isSelected())
               rb_selection="3";
            else if (rb4.isSelected())
               rb_selection="4";
            else if (rb5.isSelected())
               rb_selection="5";
            else
               rb_selection = "0";
               
            if(c1.isSelected()&&c2.isSelected())
               cb_selection="Basic Knowledge , Advanced Knowledge";
            else if (c1.isSelected())
               cb_selection="Basic Knowledge";
            else if (c2.isSelected())
               cb_selection="Advanced Knowledge";
            else
               cb_selection="0";
            
            if(printOutput())
               writeInput();     
         }  
      });
      
      b_clear.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            lbl_output.setText("Output");  
            name.setText("");
            matric.setText(""); 
            code.setSelectedIndex(0);
            bg.clearSelection();
            c1.setSelected(false);
            c2.setSelected(false);
         }  
      });
      
      lbl_output = new JLabel("Output");
      lbl_output.setBorder(border);
      lbl_output.setVerticalAlignment(JLabel.TOP);
      
      //add output label to scrollpane
      jsp = new JScrollPane(lbl_output);
      jsp.setPreferredSize(new Dimension(410,120));
      add(jsp);     
   }
   
   //handle radio button selection
   public void actionPerformed(ActionEvent ae) {
      rb_selection = ae.getActionCommand();    	   
   }
   
   //handle item listener for checkbox
   public void itemStateChanged(ItemEvent ie) {
      JCheckBox check = (JCheckBox)ie.getSource();
      cb_selection += check.getText() + " ";   
   }
   
   //method to print output to lbl_output
   public boolean printOutput(){
      output = "<html>";
      output += "Thank you for your evaluation<br><br>"; 
      output += "Name: " + name.getText() + "<br>";
      if(name.getText().equals("")){
         lbl_output.setText("Name is not entered.");
         return false;
      }
      output += "Matric: " + matric.getText() + "<br>";
      if(matric.getText().equals("")){
         lbl_output.setText("Matric no. is not entered.");
         return false;
      }
      output += "Course: " + code_selection + "<br>";
      if(code_selection.equals("[Select]") || code_selection.equals("")){
         lbl_output.setText("Course code is not selected.");
         return false;
      }
      output += "Rating: " + rb_selection + "<br>";
      if(rb_selection.equals("0")){
         lbl_output.setText("Rating is not selected.");
         return false;
      }
      output += "Outcome: " + cb_selection + "<br>";
      if(cb_selection.equals("0")){
         lbl_output.setText("Outcome is not selected.");
         return false;
      }
      output += "</html>";         
      JOptionPane.showMessageDialog(null, "The data is saved successfully.",  "INFORMATION",JOptionPane.INFORMATION_MESSAGE); 
      lbl_output.setText(output);
      jsp.getViewport().revalidate();
      return true;
    }
    
    //write to file
    public void writeInput(){
      File file = new File(filePath);
      BufferedWriter br = null;
      String input = name.getText() + ", " + matric.getText() + ", " + code_selection + ", " + rb_selection + ", " + cb_selection;
		try {
			br = new BufferedWriter(new FileWriter(file));
         br.write(input);
		} catch (IOException e) {			
         lbl_output.setText(e.toString());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				lbl_output.setText(e.toString());
			}
		}
    }
}

class MenuActionListener implements ActionListener {
   FormPanel fp;
   //receive FormPanel class to this constructor
   public MenuActionListener(FormPanel p){
      fp = p;
   }
   
   public void actionPerformed(ActionEvent e) {
      BufferedReader reader;
	   try {
			reader = new BufferedReader(new FileReader(fp.filePath));
			String line = reader.readLine();
         String output="<html>";
			while (line != null) {
				output += line + "<br>";
				// read next line
				line = reader.readLine();
			}
         output += "<br>";
         fp.lbl_output.setText(output);
			reader.close();
		} catch (IOException io) {
			fp.lbl_output.setText(io.toString());
		}
  }
}

public class CourseEvaluationApp {  
   public static void main(String[] 	args) {  
      JFrame f = new JFrame("Evaluation");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      HeaderPanel h = new 	HeaderPanel();
      HeaderPanel h2 = new 	HeaderPanel();
      FormPanel fp = new FormPanel();
      
      JMenuBar mb = new JMenuBar();  
      JMenu x = new JMenu("Menu"); 
      
      JMenuItem m1 = new JMenuItem("Load Data"); 
      m1.addActionListener(new MenuActionListener(fp));
      
      JMenuItem m2 = new JMenuItem("Exit");  
      m2.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
         int input = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
         if (input==0)
         System.exit(0);
          }  
      });
      x.add(m1); 
      x.add(m2);
      mb.add(x); 
      f.setJMenuBar(mb);        
      f.add(h,BorderLayout.NORTH);
      f.add(fp, BorderLayout.CENTER);
      f.setSize(460,400);
      f.setVisible(true);
   }  
}

