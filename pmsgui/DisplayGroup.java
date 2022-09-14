package pmsgui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;



public class DisplayGroup{

	JFrame dispGrpFrame,f;
	private JTextField grpNumTf;

	

	/**
	 * Create the application.
	 */
	public DisplayGroup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dispGrpFrame = new JFrame("Academic Project Management System");
		dispGrpFrame.setBounds(100, 100, 723, 650);
		dispGrpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispGrpFrame.getContentPane().setLayout(null);
		
		f = new JFrame();
		
		JLabel lblNewLabel = new JLabel("Group Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(293, 38, 274, 39);
		dispGrpFrame.getContentPane().add(lblNewLabel);
		
		JLabel grpNumLbl = new JLabel("Group Number");
		grpNumLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		grpNumLbl.setBounds(113, 105, 108, 14);
		dispGrpFrame.getContentPane().add(grpNumLbl);
		
		grpNumTf = new JTextField();
		grpNumTf.setBounds(218, 102, 55, 20);
		dispGrpFrame.getContentPane().add(grpNumTf);
		grpNumTf.setColumns(10);
		
		
		
		
		JLabel leadLbl = new JLabel("");
		leadLbl.setFont(new Font("Arial", Font.BOLD, 13));
		leadLbl.setBounds(113, 187, 148, 14);
		dispGrpFrame.getContentPane().add(leadLbl);
		
		JLabel leadNameLbl = new JLabel("");
		leadNameLbl.setFont(new Font("Arial", Font.BOLD, 13));
		leadNameLbl.setBounds(187, 207, 74, 14);
		dispGrpFrame.getContentPane().add(leadNameLbl);
		
		JLabel leadUsnLbl = new JLabel("");
		leadUsnLbl.setFont(new Font("Arial", Font.BOLD, 13));
		leadUsnLbl.setBounds(187, 232, 74, 14);
		dispGrpFrame.getContentPane().add(leadUsnLbl);
		
		JLabel mem1Lbl = new JLabel("");
		mem1Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		mem1Lbl.setBounds(113, 273, 148, 14);
		dispGrpFrame.getContentPane().add(mem1Lbl);
		
		JLabel name1Lbl = new JLabel("");
		name1Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		name1Lbl.setBounds(187, 298, 74, 14);
		dispGrpFrame.getContentPane().add(name1Lbl);
		
		JLabel usn1Lbl = new JLabel("");
		usn1Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		usn1Lbl.setBounds(187, 323, 74, 14);
		dispGrpFrame.getContentPane().add(usn1Lbl);
		
		JLabel mem2Lbl = new JLabel("");
		mem2Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		mem2Lbl.setBounds(113, 359, 148, 14);
		dispGrpFrame.getContentPane().add(mem2Lbl);
		
		JLabel name2Lbl = new JLabel("");
		name2Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		name2Lbl.setBounds(187, 384, 68, 14);
		dispGrpFrame.getContentPane().add(name2Lbl);
		
		JLabel usn2Lbl = new JLabel("");
		usn2Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		usn2Lbl.setBounds(187, 410, 68, 14);
		dispGrpFrame.getContentPane().add(usn2Lbl);
		
		JLabel mem3Lbl = new JLabel("");
		mem3Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		mem3Lbl.setBounds(113, 446, 136, 14);
		dispGrpFrame.getContentPane().add(mem3Lbl);
		
		JLabel name3Lbl = new JLabel("");
		name3Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		name3Lbl.setBounds(187, 467, 74, 14);
		dispGrpFrame.getContentPane().add(name3Lbl);
		
		JLabel usn3Lbl = new JLabel("");
		usn3Lbl.setFont(new Font("Arial", Font.BOLD, 13));
		usn3Lbl.setBounds(187, 492, 68, 14);
		dispGrpFrame.getContentPane().add(usn3Lbl);
		
		JLabel leadNameOpLbl = new JLabel("");
		leadNameOpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		leadNameOpLbl.setBounds(287, 207, 244, 14);
		dispGrpFrame.getContentPane().add(leadNameOpLbl);
		
		JLabel leadUsnOpLbl = new JLabel("");
		leadUsnOpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		leadUsnOpLbl.setBounds(287, 232, 244, 14);
		dispGrpFrame.getContentPane().add(leadUsnOpLbl);
		
		JLabel name1OpLbl = new JLabel("");
		name1OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		name1OpLbl.setBounds(287, 298, 244, 14);
		dispGrpFrame.getContentPane().add(name1OpLbl);
		
		JLabel usn1OpLbl = new JLabel("");
		usn1OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		usn1OpLbl.setBounds(287, 323, 244, 14);
		dispGrpFrame.getContentPane().add(usn1OpLbl);
		
		JLabel name2OpLbl = new JLabel("");
		name2OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		name2OpLbl.setBounds(287, 384, 244, 14);
		dispGrpFrame.getContentPane().add(name2OpLbl);
		
		JLabel usn2OpLbl = new JLabel("");
		usn2OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		usn2OpLbl.setEnabled(true);
		usn2OpLbl.setBounds(287, 410, 244, 14);
		dispGrpFrame.getContentPane().add(usn2OpLbl);
		
		JLabel name3OpLbl = new JLabel("");
		name3OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		name3OpLbl.setEnabled(true);
		name3OpLbl.setBounds(285, 467, 246, 14);
		dispGrpFrame.getContentPane().add(name3OpLbl);
		
		JLabel usn3OpLbl = new JLabel("");
		usn3OpLbl.setFont(new Font("Arial", Font.BOLD, 12));
		usn3OpLbl.setBounds(287, 492, 244, 14);
		dispGrpFrame.getContentPane().add(usn3OpLbl);
		
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
					
					PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.group WHERE GNO = (?) AND USER = (?)");
					ps.setInt(1, grpNum);
					ps.setString(2, user);
					rs = ps.executeQuery();
					
					
						while(rs.next()) {
						
							leadNameOpLbl.setText(rs.getString(1));
							leadUsnOpLbl.setText(rs.getString(5));
							name1OpLbl.setText(rs.getString(2));
							usn1OpLbl.setText(rs.getString(6));
							name2OpLbl.setText(rs.getString(3));
							usn2OpLbl.setText(rs.getString(7));
							name3OpLbl.setText(rs.getString(4));
							usn3OpLbl.setText(rs.getString(8));
							
							leadLbl.setText("Group Leader :");
							leadNameLbl.setText("Name : ");
							leadUsnLbl.setText("USN : ");
							mem1Lbl.setText("Group Member 1 :");
							name1Lbl.setText("Name : ");
							usn1Lbl.setText("USN : ");
							mem2Lbl.setText("Group Member 2 :");
							name2Lbl.setText("Name : ");
							usn2Lbl.setText("USN : ");
							mem3Lbl.setText("Group Member 3 :");
							name3Lbl.setText("Name : ");
							usn3Lbl.setText("USN : ");
							
							flag = true;
					
						}
				
				}catch(NullPointerException e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}catch(ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(f, "Invalid Group Number!!");
				}
				
				try {
					if(!flag)
						throw new GroupNotAddedYetException("Group "+grpNum+" is not added");
				}
				catch(GroupNotAddedYetException e) {
					JOptionPane.showMessageDialog(f, e.getMessage());
				}
				
			}
		});
		
		display.setFont(new Font("Times New Roman", Font.BOLD, 13));
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.setBounds(442, 101, 89, 23);
		dispGrpFrame.getContentPane().add(display);
		
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {		//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				dispGrpFrame.setVisible(false);
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
		home.setFont(new Font("Times New Roman", Font.BOLD, 13));
		home.setBounds(442, 550, 89, 23);
		dispGrpFrame.getContentPane().add(home);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\pms4.jpg"));
		lblNewLabel_1.setBounds(0, 0, 707, 611);
		dispGrpFrame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
