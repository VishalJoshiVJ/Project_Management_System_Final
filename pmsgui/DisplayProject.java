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

public class DisplayProject{

	JFrame dispProjectFrame,f;
	private JTextField grpNumTf;

	

	/**
	 * Create the application.
	 */
	public DisplayProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dispProjectFrame = new JFrame("Academic Project Management System");
		dispProjectFrame.setBounds(100, 100, 732, 344);
		dispProjectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispProjectFrame.getContentPane().setLayout(null);
		
		f = new JFrame();
		
		JLabel lblNewLabel = new JLabel("Project Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(289, 11, 232, 33);
		dispProjectFrame.getContentPane().add(lblNewLabel);
		
		JLabel grpNumLbl = new JLabel("Enter Group Number");
		grpNumLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		grpNumLbl.setBounds(88, 68, 155, 14);
		dispProjectFrame.getContentPane().add(grpNumLbl);
		
		grpNumTf = new JTextField();
		grpNumTf.setBounds(259, 66, 45, 20);
		dispProjectFrame.getContentPane().add(grpNumTf);
		grpNumTf.setColumns(10);
		
		JLabel titleLbl = new JLabel("");
		titleLbl.setFont(new Font("Arial", Font.BOLD, 15));
		titleLbl.setBounds(152, 124, 104, 14);
		dispProjectFrame.getContentPane().add(titleLbl);
		
		JLabel taskLbl = new JLabel("");
		taskLbl.setFont(new Font("Arial", Font.BOLD, 15));
		taskLbl.setBounds(152, 178, 91, 14);
		dispProjectFrame.getContentPane().add(taskLbl);
		
		JLabel titleOpLbl = new JLabel("");
		titleOpLbl.setFont(new Font("Arial", Font.BOLD, 15));
		titleOpLbl.setBounds(266, 125, 352, 23);
		dispProjectFrame.getContentPane().add(titleOpLbl);
		
		JLabel taskOpLbl = new JLabel("");
		taskOpLbl.setFont(new Font("Arial", Font.BOLD, 15));
		taskOpLbl.setBounds(266, 178, 352, 33);
		dispProjectFrame.getContentPane().add(taskOpLbl);
		
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
					
					PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.project WHERE GNO = (?) AND USER = (?)");
					ps.setInt(1, grpNum);
					ps.setString(2, user);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						titleOpLbl.setText(rs.getString(2));
						taskOpLbl.setText(rs.getString(3));
						
						titleLbl.setText("Project Title :");
						taskLbl.setText("Task : ");
						
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
					JOptionPane.showMessageDialog(f, "Project is not assigned for Group "+grpNum);
				}
			}
		});
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Times New Roman", Font.BOLD, 14));
		display.setBounds(508, 64, 89, 23);
		dispProjectFrame.getContentPane().add(display);
		
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {			//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				dispProjectFrame.setVisible(false);
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
		home.setForeground(Color.WHITE);
		home.setBackground(Color.BLACK);
		home.setFont(new Font("Times New Roman", Font.BOLD, 15));
		home.setBounds(508, 242, 89, 23);
		dispProjectFrame.getContentPane().add(home);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\sppot light.jpg"));
		lblNewLabel_1.setBounds(0, 0, 716, 305);
		dispProjectFrame.getContentPane().add(lblNewLabel_1);
	}

}
