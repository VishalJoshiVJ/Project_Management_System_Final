package pmsgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.sql.*;

public class DisplayGuide{

	JFrame dispGdFrame,f;
	private JTextField grpNumTf;

	

	/**
	 * Create the application.
	 */
	public DisplayGuide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dispGdFrame = new JFrame("Academic Project Management System");
		dispGdFrame.setBounds(100, 100, 714, 505);
		dispGdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispGdFrame.getContentPane().setLayout(null);
		
		f = new JFrame();
		
		JLabel lblNewLabel = new JLabel("Guide Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(272, 32, 209, 38);
		dispGdFrame.getContentPane().add(lblNewLabel);
		
		JLabel grpNumLbl = new JLabel("Enter Group Number");
		grpNumLbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		grpNumLbl.setBounds(67, 100, 141, 14);
		dispGdFrame.getContentPane().add(grpNumLbl);
		
		grpNumTf = new JTextField();
		grpNumTf.setBounds(233, 98, 54, 20);
		dispGdFrame.getContentPane().add(grpNumTf);
		grpNumTf.setColumns(10);
		
		JLabel nameLbl = new JLabel("");
		nameLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameLbl.setBounds(180, 167, 77, 14);
		dispGdFrame.getContentPane().add(nameLbl);
		
		JLabel idLbl = new JLabel("");
		idLbl.setFont(new Font("Arial", Font.BOLD, 14));
		idLbl.setBounds(180, 214, 77, 14);
		dispGdFrame.getContentPane().add(idLbl);
		
		JLabel emailLbl = new JLabel("");
		emailLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailLbl.setBounds(180, 257, 77, 14);
		dispGdFrame.getContentPane().add(emailLbl);
		
		JLabel phoneLbl = new JLabel("");
		phoneLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phoneLbl.setBounds(180, 307, 116, 14);
		dispGdFrame.getContentPane().add(phoneLbl);
		
		JLabel nameOpLbl = new JLabel("");
		nameOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameOpLbl.setBounds(341, 167, 234, 23);
		dispGdFrame.getContentPane().add(nameOpLbl);
		
		JLabel idOpLbl = new JLabel("");
		idOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		idOpLbl.setBounds(341, 214, 234, 20);
		dispGdFrame.getContentPane().add(idOpLbl);
		
		JLabel emailOpLbl = new JLabel("");
		emailOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailOpLbl.setBounds(341, 257, 234, 23);
		dispGdFrame.getContentPane().add(emailOpLbl);
		
		JLabel phoneOpLbl = new JLabel("");
		phoneOpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phoneOpLbl.setBounds(341, 307, 234, 23);
		dispGdFrame.getContentPane().add(phoneOpLbl);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int grpNum = Integer.parseInt(grpNumTf.getText());
				
				boolean flag = false;
				String user = null;
				
				try {
					
					Conn c = new Conn();
					
					ResultSet rs = c.st.executeQuery("SELECT * FROM project_management_system.loggedin");
					while(rs.next()) {
						user = rs.getString(1);
					}
					
					PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.guide WHERE GNO = (?) AND USER = (?)");
					ps.setInt(1, grpNum);
					ps.setString(2, user);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						nameOpLbl.setText(rs.getString(2));
						idOpLbl.setText(rs.getString(3));
						emailOpLbl.setText(rs.getString(4));
						phoneOpLbl.setText(rs.getString(5));
						
						nameLbl.setText("Name");
						idLbl.setText("ID");
						emailLbl.setText("Email ID");
						phoneLbl.setText("Phone Number");
						
						flag = true;
				
					}
				
				}catch(NullPointerException e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}catch(ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}
				
				if(!flag) {
					JOptionPane.showMessageDialog(f, "Guide is not assigned for Group "+grpNum);
				}
			}
		});
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Times New Roman", Font.BOLD, 14));
		display.setBounds(525, 97, 89, 23);
		dispGdFrame.getContentPane().add(display);
		
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {			//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				dispGdFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							User window = new User();
							window.userFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		home.setBackground(Color.BLACK);
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Times New Roman", Font.BOLD, 14));
		home.setBounds(525, 399, 89, 23);
		dispGdFrame.getContentPane().add(home);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\pms4.jpg"));
		lblNewLabel_1.setBounds(0, 0, 698, 466);
		dispGdFrame.getContentPane().add(lblNewLabel_1);
	}

}
