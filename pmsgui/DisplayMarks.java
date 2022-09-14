package pmsgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.sql.*;

public class DisplayMarks{

	JFrame dispMarksFrame,f;
	private JTextField grpNumTf;

	
	/**
	 * Create the application.
	 */
	public DisplayMarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dispMarksFrame = new JFrame("Academic Project Management System");
		dispMarksFrame.setBounds(100, 100, 883, 498);
		dispMarksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispMarksFrame.getContentPane().setLayout(null);
		
		f = new JFrame();
		
		JLabel lblNewLabel = new JLabel("Marks Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 26, 279, 32);
		dispMarksFrame.getContentPane().add(lblNewLabel);
		
		JLabel grpNumLbl = new JLabel("Enter Group Number");
		grpNumLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		grpNumLbl.setBounds(92, 91, 160, 14);
		dispMarksFrame.getContentPane().add(grpNumLbl);
		
		grpNumTf = new JTextField();
		grpNumTf.setBounds(251, 89, 47, 20);
		dispMarksFrame.getContentPane().add(grpNumTf);
		grpNumTf.setColumns(10);
		
		JLabel usnLbl = new JLabel("");
		usnLbl.setFont(new Font("Arial", Font.BOLD, 14));
		usnLbl.setBounds(49, 189, 46, 14);
		dispMarksFrame.getContentPane().add(usnLbl);
		
		JLabel rmLbl = new JLabel("");
		rmLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rmLbl.setBounds(178, 188, 119, 14);
		dispMarksFrame.getContentPane().add(rmLbl);
		
		JLabel rm1Lbl = new JLabel("");
		rm1Lbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm1Lbl.setBounds(49, 238, 112, 14);
		dispMarksFrame.getContentPane().add(rm1Lbl);
		
		JLabel rm2Lbl = new JLabel("");
		rm2Lbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm2Lbl.setBounds(49, 263, 112, 14);
		dispMarksFrame.getContentPane().add(rm2Lbl);
		
		JLabel rm3Lbl = new JLabel("");
		rm3Lbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm3Lbl.setBounds(49, 288, 112, 14);
		dispMarksFrame.getContentPane().add(rm3Lbl);
		
		JLabel rm4Lbl = new JLabel("");
		rm4Lbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm4Lbl.setBounds(49, 313, 112, 14);
		dispMarksFrame.getContentPane().add(rm4Lbl);
		
		JLabel rm1OpLbl = new JLabel("");
		rm1OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm1OpLbl.setBounds(206, 238, 46, 14);
		dispMarksFrame.getContentPane().add(rm1OpLbl);
		
		JLabel rm2OpLbl = new JLabel("");
		rm2OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm2OpLbl.setBounds(206, 263, 46, 14);
		dispMarksFrame.getContentPane().add(rm2OpLbl);
		
		JLabel rm3OpLbl = new JLabel("");
		rm3OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm3OpLbl.setBounds(206, 287, 46, 14);
		dispMarksFrame.getContentPane().add(rm3OpLbl);
		
		JLabel rm4OpLbl = new JLabel("");
		rm4OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		rm4OpLbl.setBounds(206, 313, 46, 14);
		dispMarksFrame.getContentPane().add(rm4OpLbl);
		
		JLabel pmLbl = new JLabel("");
		pmLbl.setFont(new Font("Arial", Font.BOLD, 14));
		pmLbl.setBounds(409, 188, 142, 14);
		dispMarksFrame.getContentPane().add(pmLbl);
		
		
		
		JLabel pm1OpLbl = new JLabel("");
		pm1OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		pm1OpLbl.setBounds(469, 238, 46, 14);
		dispMarksFrame.getContentPane().add(pm1OpLbl);
		
		JLabel pm2OpLbl = new JLabel("");
		pm2OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		pm2OpLbl.setBounds(469, 263, 46, 14);
		dispMarksFrame.getContentPane().add(pm2OpLbl);
		
		JLabel pm3OpLbl = new JLabel("");
		pm3OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		pm3OpLbl.setBounds(469, 287, 46, 14);
		dispMarksFrame.getContentPane().add(pm3OpLbl);
		
		JLabel pm4OpLbl = new JLabel("");
		pm4OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		pm4OpLbl.setBounds(469, 313, 46, 14);
		dispMarksFrame.getContentPane().add(pm4OpLbl);
		
		JLabel tmLbl = new JLabel("");
		tmLbl.setFont(new Font("Arial", Font.BOLD, 14));
		tmLbl.setBounds(679, 188, 125, 14);
		dispMarksFrame.getContentPane().add(tmLbl);
		
		
		JLabel tm1OpLbl = new JLabel("");
		tm1OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		tm1OpLbl.setBounds(720, 238, 46, 14);
		dispMarksFrame.getContentPane().add(tm1OpLbl);
		
		JLabel tm2OpLbl = new JLabel("");
		tm2OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		tm2OpLbl.setBounds(720, 263, 46, 14);
		dispMarksFrame.getContentPane().add(tm2OpLbl);
		
		JLabel tm3OpLbl = new JLabel("");
		tm3OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		tm3OpLbl.setBounds(720, 287, 46, 14);
		dispMarksFrame.getContentPane().add(tm3OpLbl);
		
		JLabel tm4OpLbl = new JLabel("");
		tm4OpLbl.setFont(new Font("Arial", Font.BOLD, 14));
		tm4OpLbl.setBounds(720, 313, 46, 14);
		dispMarksFrame.getContentPane().add(tm4OpLbl);
		
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
					
					PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.marks WHERE GNO = (?) AND USER = (?)");
					PreparedStatement ps1 = c.conn.prepareStatement("SELECT * FROM project_management_system.group WHERE GNO = (?) AND USER = (?)");
					ps.setInt(1, grpNum);
					ps.setString(2, user);
					ps1.setInt(1, grpNum);
					ps1.setString(2, user);
					rs = ps.executeQuery();
					ResultSet rs1 = ps1.executeQuery();
				
					while(rs.next() && rs1.next()) {
						
						int rm1 = rs.getInt(2);
						int rm2 = rs.getInt(3);
						int rm3 = rs.getInt(4);
						int rm4 = rs.getInt(5);
						int pm1 = rs.getInt(6);
						int pm2 = rs.getInt(7);
						int pm3 = rs.getInt(8);
						int pm4 = rs.getInt(9);
						
						rm1Lbl.setText(rs1.getString(5));
						rm2Lbl.setText(rs1.getString(6));
						rm3Lbl.setText(rs1.getString(7));
						rm4Lbl.setText(rs1.getString(8));
						
						
						
						rm1OpLbl.setText(Integer.toString(rm1));
						rm2OpLbl.setText(Integer.toString(rm2));
						rm3OpLbl.setText(Integer.toString(rm3));
						rm4OpLbl.setText(Integer.toString(rm4));
						
						pm1OpLbl.setText(Integer.toString(pm1));
						pm2OpLbl.setText(Integer.toString(pm2));
						pm3OpLbl.setText(Integer.toString(pm3));
						pm4OpLbl.setText(Integer.toString(pm4));
						
						tm1OpLbl.setText(Integer.toString(rm1 + pm1));
						tm2OpLbl.setText(Integer.toString(rm2 + pm2));
						tm3OpLbl.setText(Integer.toString(rm3 + pm3));
						tm4OpLbl.setText(Integer.toString(rm4 + pm4));
						
						usnLbl.setText("USN");
						rmLbl.setText("Report Marks");
						pmLbl.setText("Presentation Marks");
						tmLbl.setText("Total Marks");
						
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
					JOptionPane.showMessageDialog(f, "Marks are not assigned for Group "+grpNum);
				}
			}
		});
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		display.setFont(new Font("Times New Roman", Font.BOLD, 14));
		display.setBounds(659, 87, 89, 23);
		dispMarksFrame.getContentPane().add(display);
		
		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {			//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				dispMarksFrame.setVisible(false);
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
		home.setFont(new Font("Times New Roman", Font.BOLD, 14));
		home.setBounds(659, 401, 89, 23);
		dispMarksFrame.getContentPane().add(home);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\pms3.jpg"));
		lblNewLabel_1.setBounds(0, 0, 867, 459);
		dispMarksFrame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
