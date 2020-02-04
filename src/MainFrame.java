
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MainFrame {
	
	public MainFrame() {
		
		JFrame frame = new JFrame("Secure Login Test");
		
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(4, 4, 10, 10));
		
	//Create Panel 1
		JPanel panel1 = new JPanel(new GridBagLayout());
		
		panel1.setBorder(new LineBorder(Color.BLACK, 1));
		panel1.setPreferredSize(new Dimension(300, 200));
		left.add(panel1);
		
		JLabel label1 = new JLabel("Login");
		label1.setFont(new Font("Arial", Font.PLAIN, 20));
		panel1.add(label1);
		
		JLabel username = new JLabel("username");
		JTextField text1 = new JTextField(10);
		JLabel password = new JLabel("password");
		JTextField text2 = new JTextField(10);
		JButton btn1 = new JButton("Submit");
		
		
		
		GridBagConstraints p1 = new GridBagConstraints();
		p1.insets = new Insets(10, 10, 10, 10);
		
		
		p1.gridx = 0;
		p1.gridy = 1;
		panel1.add(username, p1);
		
		p1.gridx = 1;
		p1.gridy = 1;
		panel1.add(text1, p1);
		
		p1.gridx = 0;
		p1.gridy = 2;
		panel1.add(password, p1);
		
		p1.gridx = 1;
		p1.gridy = 2;
		panel1.add(text2, p1);
		
		p1.gridx = 1;
		p1.gridy = 3;
		panel1.add(btn1, p1);
		
        
	//Create Panel 2
		JPanel panel2 = new JPanel(new GridBagLayout());
		
		panel2.setBorder(new LineBorder(Color.BLACK, 1));
		panel2.setPreferredSize(new Dimension(300, 200));
		left.add(panel2);
		
        JLabel label2 = new JLabel("Create Login");
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        panel2.add(label2);
        
        JLabel new_username = new JLabel("username");
		JTextField text3 = new JTextField(10);
		JLabel new_password = new JLabel("password");
		JTextField text4 = new JTextField(10);
		JButton btn2 = new JButton("Submit");
		
		
		GridBagConstraints p2 = new GridBagConstraints();
		p2.insets = new Insets(10, 10, 10, 10);
        
		p2.gridx = 0;
		p2.gridy = 1;
		panel2.add(new_username, p2);
		
		p2.gridx = 1;
		p2.gridy = 1;
		panel2.add(text3, p2);
		
		p2.gridx = 0;
		p2.gridy = 2;
		panel2.add(new_password, p2);
		
		p2.gridx = 1;
		p2.gridy = 2;
		panel2.add(text4, p2);
		
		p2.gridx = 1;
		p2.gridy = 3;
		panel2.add(btn2, p2);
        
        
        
    // Create GridBagLayout for panel1 and panel2
        
        JPanel main = new JPanel(new GridBagLayout());
       
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		main.add(panel1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		main.add(panel2, gbc);
		
        frame.add(main);
		frame.setSize(700, 300);
		frame.setLocation(700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
