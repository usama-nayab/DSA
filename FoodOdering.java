import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FoodOdering implements ActionListener {
    JFrame f = new JFrame("Food Odering Management System");
    JComboBox box;
    JButton order = new JButton("Order");
    JButton deliver = new JButton("Delivered");
    JTextArea a = new JTextArea();
    JLabel l = new JLabel("Customer Name");
    JLabel l2 = new JLabel("Food Item");
    JLabel l3 = new JLabel ("Price");
    JLabel l4 = new JLabel ("Address");
    JLabel l5 = new JLabel("Phone Number");
   
    JTextField f4 = new JTextField();
    JTextField f5 = new JTextField();
    JTextField f3 = new JTextField();
    JTextField f1 = new JTextField();
    
    Queue<Object> foodqueue = new LinkedList<>();
    String s1 , s2 , s3 , s4 , s5 , s6;
    int i = 0; 
    
    FoodOdering(){
        String [] food = {"Zinger" , "Roll" , "Chicken Burger"};
        box = new JComboBox(food);
        f.setSize(700,700);
    f.setLayout(null);
    f.setVisible(true);
    l.setBounds(10,10, 150,50);
    l2.setBounds(10,70, 130,50);
    l3.setBounds(10, 140,130 , 50);
    l4.setBounds(10,220 ,150,30);
    l5.setBounds(10,300 ,150,30);
    f1.setBounds(120,20,150,30);
    box.setBounds(120, 80,150,30);
    f3.setBounds(120,150,150,30);
    f4.setBounds(120, 220,150,30);
    f5.setBounds(120, 300, 150,30);
    
    order.setBounds(340, 610,100,50);
    deliver.setBounds(30,610,100,50);
     a.setBounds(1, 350,700,250);
    a.setBackground(Color.WHITE);
    f.add(l);
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(l5);
f.add(f1);
f.add(box);
f.add(f3);
f.add(f4);
f.add(f5);
f.add(order);
f.add(deliver);

//a.setLayout(new GridLayout());
order.addActionListener(this);  
deliver.addActionListener(this);
f.add(a);
   
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource() == order){
	         
	          if( f1.getText().equals("")) {
	        	  JOptionPane.showMessageDialog(f,"Enter Customer Name");
	          }
	          else if( f3.getText().equals("")) {
	        	  JOptionPane.showMessageDialog(f,"Enter Price");
	          }
	          else if( f4.getText().equals("")) {
	        	  JOptionPane.showMessageDialog(f,"Enter Address");
	          }
	          else if( f5.getText().equals("")) {
	        	  JOptionPane.showMessageDialog(f,"Enter Phone Number");
	          }
	          else {
	        	  i++;
	            s1=f1.getText();
	            s2=(String) box.getSelectedItem();
	  	        s3=f3.getText();
	  	        s5=f4.getText();
	  	        s6=f5.getText();
	  	        s4=i+"\t"+s1+"\t"+s2+"\t"+"Price:"+s3+"\t"+s5+"\t"+s6+"\n";
	  	        foodqueue.add(s4);
	  	        a.setText(foodqueue.toString());
	  	        f1.setText(null);
	  	        f3.setText(null);
	  	        f4.setText(null);
	  	        f5.setText(null);
	          }
	   }
   else if(e.getSource() == deliver){
       if(foodqueue.isEmpty()){
                JOptionPane.showMessageDialog(f , "No Order Placed In A Queue");
            } 
            foodqueue.remove();
            a.setText(foodqueue.toString());
        }
   }
    }

