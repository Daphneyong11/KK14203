//DAPHNE YONG ZHI XUAN
//BI19110065
//KK14203 INDIVIDUAL PROJECT
//HOTEL MANAGEMENT SYSTEM
import java.util.Scanner;
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

class login extends JPanel {
    private JLabel line1;
    private JLabel line2;
    private JLabel line3;
    JPasswordField password;
    JTextField username;
    private JButton b_login;

    public login() {
        line1 = new JLabel ("Login");
        line2 = new JLabel ("Username");
        line3 = new JLabel ("Password");
        password = new JPasswordField (20);
        username = new JTextField (20);
        b_login = new JButton ("Login");

        setPreferredSize (new Dimension (624, 366));
        setLayout (null);

        add (line1);
        add (line2);
        add (line3);
        add (password);
        add (username);
        add (b_login);

        line1.setBounds (260, 40, 100, 25);
        line2.setBounds (130, 85, 100, 25);
        line3.setBounds (130, 125, 100, 25);
        password.setBounds (230, 125, 200, 25);
        username.setBounds (230, 85, 200, 25);
        b_login.setBounds (235, 175, 100, 25);
   
        b_login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if(username.getText().equals("user")&&password.getText().equals("1234")){
                  JOptionPane.showMessageDialog(null, "Login successfully"); 
                  JFrame f2 = new JFrame("Main menu");
                  f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  menu m=new menu();
                  f2.add(m,BorderLayout.CENTER);
                  f2.setSize(400,300);
                  f2.setVisible (true);
                  setVisible(false);
               }
               else
                  JOptionPane.showMessageDialog(null, "Username and password incorrect","ERROR",JOptionPane.ERROR_MESSAGE);
            }
         }); 
   }
}

class menu extends JPanel {
    private JLabel line1;
    private JButton b_new;
    private JButton b_view;
    
    String output="";
    String filePath="data.txt";

    public menu() {
        line1 = new JLabel ("Menu");
        b_new = new JButton ("Create new data");
        b_view = new JButton ("Check register record");

        setPreferredSize (new Dimension (336, 197));
        setLayout (null);

        add (line1);
        add (b_new);
        add (b_view);

        line1.setBounds (140, 20, 100, 25);
        b_new.setBounds (75, 60, 200, 25);
        b_view.setBounds (75, 105, 200, 25);
        
        b_new.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               JFrame f3 = new JFrame("Create new data");
               f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               create c=new create();
               f3.add(c,BorderLayout.CENTER);
               f3.setSize(700,500);
               f3.setVisible (true);
             }
         });
         
         b_view.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               JFrame f4 = new JFrame("Record");
               f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               view v = new view();
               f4.add(v, BorderLayout.CENTER);
               f4.setSize(700,500);
               f4.setVisible(true);
             }
         });
   }
}

class create extends JPanel {
    private JLabel line1;
    private JTextField name;
    private JLabel line2;
    private JTextField tel;
    private JLabel line3;
    private JTextField day;
    private JLabel line4;
    private JLabel line5;
    private JButton b_submit;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    JLabel output_field;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    String output="";
    int room=0;
    String roomtype="";

    public create() {
        line1 = new JLabel ("Customer Name");
        name = new JTextField (30);
        line2 = new JLabel ("Telephone Number");
        tel = new JTextField (20);
        line3 = new JLabel ("Days Stayed");
        day = new JTextField (5);
        line4 = new JLabel ("Booking for Hotel");
        b_submit = new JButton ("Submit");
        line5 = new JLabel ("Type of room");
        r1 = new JRadioButton ("Single (RM170)");
        r2 = new JRadioButton ("Double (RM220)");
        r3 = new JRadioButton ("Family(RM300)");
        output_field = new JLabel("");
        output_field.setPreferredSize(new Dimension(15, 20));
        
        setPreferredSize (new Dimension (667, 609));
        setLayout (null);

        add (line1);
        add (name);
        add (line2);
        add (tel);
        add (line3);
        add (day);
        add (output_field);
        add (line4);
        add (b_submit);
        add (line5);
        add (r1);
        add (r2);
        add (r3);

        line1.setBounds (105, 65, 100, 25);
        name.setBounds (230, 65, 200, 25);
        line2.setBounds (105, 95, 111, 25);
        tel.setBounds (230, 95, 200, 25);
        line3.setBounds (105, 125, 100, 25);
        day.setBounds (230, 125, 200, 25);
        output_field.setBounds (35, 210, 600, 270);
        line4.setBounds (250, 10, 256, 25);
        b_submit.setBounds (245, 180, 100, 25);
        line5.setBounds (105, 150, 100, 25);
        r1.setBounds (230, 155, 120, 25);
        r2.setBounds (350, 155, 120, 25);
        r3.setBounds (470, 155, 120, 25);
        output_field.setVerticalAlignment(JLabel.TOP);
        output_field.setBorder(border);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        b_submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if (r1.isSelected()){
                 roomtype="Single room";
                 room=1;
               }
              else if (r2.isSelected()){
                 roomtype="Double room";
                 room=2;
               }
              else if (r3.isSelected()){
                 roomtype="Family room";
                 room=3;
               }
              else
              room=0;
              if(printOutput()){
                  writeInput(); 
                  name.setText("");
                  tel.setText("");
                  day.setText("");
                  bg.clearSelection();
              }
             }
         });  
    }
    
    public boolean printOutput(){
      output = "<html>";
      output += "Thank you for choosing Fortune Hotel<br><br>"; 
      output += "Customer Name: " + name.getText() + "<br>";
      if(name.getText().equals("")){
         output_field.setText("Customer name is not entered!");
         return false;
      }
      output += "Telephone number: " + tel.getText() + "<br>";
      if(tel.getText().equals("")){
         output_field.setText("Telephone number is not entered!");
         return false;
      }
      if(isInteger(day.getText()))
      output += "Day(s) Stayed: " + day.getText() + "<br>";
      else
      output_field.setText("Days stayed needs to be number!");
      if(day.getText().equals("")){
         output_field.setText("Days stayed is not selected!");
         return false;
      }
      output += "Room Type: " + roomtype + "<br>";
      if(room==0){
         output_field.setText("Room type is not selected!");
         return false;
      }
      output += "Price: RM" + calculateprice(day.getText(),room) +"<br>";
      output += "</html>";         
      JOptionPane.showMessageDialog(null, "The data is saved successfully.",  "INFORMATION",JOptionPane.INFORMATION_MESSAGE); 
      output_field.setText(output);
      return true;
    }
    
    private boolean isInteger(String input) {
       try {
          Integer.parseInt( input );
          return true;
        }catch( Exception e ) {
          return false;
        }
   }
   
    private int calculateprice(String day, int room){
         int daynum = Integer.parseInt(day);
         int price;
         if(room==1)
         price = daynum*170;
         else if(room==2)
         price = daynum*220;
         else
         price = daynum*300;
         return price;
    }
    
    public void writeInput(){
      BufferedReader reader;
      BufferedWriter br = null;
      String data="";
      try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line = reader.readLine();
			while (line != null) {
				data += line+"\n";
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException io) {
         output_field.setText(io.toString());
		}

      String input = name.getText() + ", " + tel.getText() + ", " + day.getText() + ","+roomtype+", RM" + calculateprice(day.getText(), room);
		try {
			br = new BufferedWriter(new FileWriter("data.txt"));
         br.write(data+input);
		} catch (IOException e) {			
         output_field.setText(e.toString());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				output_field.setText(e.toString());
			}
		}
    }
}

class view extends JPanel{
   private JLabel line1;
   private JLabel sale;
   JScrollPane jsp;
   Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

   public view(){
      line1 = new JLabel("Fortune Hotel Record");
      sale = new JLabel("");
      sale.setPreferredSize(new Dimension(667, 366));
      sale.setBorder(border);
      sale.setVerticalAlignment(JLabel.TOP);
      jsp = new JScrollPane(sale);
      String output="<html>";
      add (line1);
      add (sale);
      add (jsp);
      
      line1.setBounds(210, 10, 200, 25);
      sale.setBounds(45, 50, 500, 205);
      BufferedReader reader;
      try {
			   reader = new BufferedReader(new FileReader("data.txt"));
		      String line = reader.readLine();
            while (line != null) {
            output += line+"<br>";
            line = reader.readLine();
			}
            reader.close();
		      } catch (IOException io) {
		      	JOptionPane.showMessageDialog(null,io.toString());
		      }
            sale.setText(output);
   }
}

public class HotelManagement{ 
   public static void main(String[]args){
      JFrame f1 = new JFrame("Fortune Hotel Login");
      f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      login l=new login();
      f1.add(l, BorderLayout.CENTER);
      f1.setSize(550,350);
      f1.setVisible(true);
   }
}   