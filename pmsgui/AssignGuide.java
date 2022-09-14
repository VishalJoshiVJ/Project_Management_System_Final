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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.sql.*;



public class AssignGuide{

	JFrame assGdFrame;
	private JTextField nametf;
	private JTextField idTf;
	private JTextField EmailTf;
	private JTextField phoneTf;
	private JTextField grpNoTf;

	

	/**
	 * Create the application.
	 */
	public AssignGuide() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		assGdFrame = new JFrame("Academic Project Management System");
		assGdFrame.setBounds(100, 100, 761, 505);
		assGdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		assGdFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Guide Details");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(272, 25, 261, 40);
		assGdFrame.getContentPane().add(lblNewLabel);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Arial", Font.BOLD, 14));
		nameLbl.setBounds(174, 143, 89, 14);
		assGdFrame.getContentPane().add(nameLbl);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setFont(new Font("Arial", Font.BOLD, 14));
		idLbl.setBounds(174, 192, 46, 14);
		assGdFrame.getContentPane().add(idLbl);
		
		JLabel emailLbl = new JLabel("Email ID");
		emailLbl.setFont(new Font("Arial", Font.BOLD, 14));
		emailLbl.setBounds(174, 239, 74, 14);
		assGdFrame.getContentPane().add(emailLbl);
		
		JLabel phLbl = new JLabel("Phone Number");
		phLbl.setFont(new Font("Arial", Font.BOLD, 14));
		phLbl.setBounds(174, 284, 113, 14);
		assGdFrame.getContentPane().add(phLbl);
		
		nametf = new JTextField();
		nametf.setBounds(331, 141, 222, 20);
		assGdFrame.getContentPane().add(nametf);
		nametf.setColumns(10);
		
		idTf = new JTextField();
		idTf.setBounds(331, 186, 222, 20);
		assGdFrame.getContentPane().add(idTf);
		idTf.setColumns(10);
		
		EmailTf = new JTextField();
		EmailTf.setBounds(331, 233, 222, 20);
		assGdFrame.getContentPane().add(EmailTf);
		EmailTf.setColumns(10);
		
		phoneTf = new JTextField();
		phoneTf.setBounds(331, 278, 222, 20);
		assGdFrame.getContentPane().add(phoneTf);
		phoneTf.setColumns(10);
		
		JButton submit = new JButton("Assign");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gdNum = Integer.parseInt(grpNoTf.getText());
				
				JFrame f = new JFrame();
				
				boolean flag = false;
				boolean flag1 = false;
				String user = null;
				
				try {
					try {
						Conn c = new Conn();
						PreparedStatement ps = c.conn.prepareStatement("SELECT * FROM project_management_system.group");
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()) {
							if(gdNum == rs.getInt(10)) {
								flag1 = true;
								break;
							}
						}
						if(!flag1){
							throw new GroupNotAddedYetException("Group "+gdNum+" is not added yet");
						}
					}catch(GroupNotAddedYetException e1) {
						JOptionPane.showMessageDialog(f, e1.getMessage());
					}
					
				
				if(flag1) {
					try {
						
						Conn c = new Conn();
						ResultSet rs = c.st.executeQuery("SELECT * FROM project_management_system.loggedin");
						while(rs.next()) {
							user = rs.getString(1);
						}
						
						PreparedStatement ps = c.conn.prepareStatement("INSERT INTO project_management_system.guide VALUES(?,?,?,?,?,?)");
						ps.setInt(1,  Integer.parseInt(grpNoTf.getText()));
						ps.setString(2, nametf.getText());
						ps.setString(3, idTf.getText());
						ps.setString(4, EmailTf.getText());
						ps.setString(5, phoneTf.getText());
						ps.setString(6, user);
						ps.executeUpdate();
						flag = true;
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(f, "Something went wrong");
					}
					
					if(flag) {
						JOptionPane.showMessageDialog(f, "Guide assigned successfully to Group number "+gdNum);
					}
					
				}
				
				
				
				
				
				assGdFrame.setVisible(false);
				
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
				
			}catch(Exception e1) {
				
			}
		}});
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		submit.setBounds(234, 383, 89, 23);
		assGdFrame.getContentPane().add(submit);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {		//Return to Home Page
			public void actionPerformed(ActionEvent e) {
				assGdFrame.setVisible(false);
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
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cancel.setBounds(403, 383, 89, 23);
		assGdFrame.getContentPane().add(cancel);
		
		JLabel grpNoLbl = new JLabel("Enter Group Number");
		grpNoLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		grpNoLbl.setBounds(62, 91, 146, 14);
		assGdFrame.getContentPane().add(grpNoLbl);
		
		grpNoTf = new JTextField();
		grpNoTf.setBounds(234, 89, 46, 20);
		assGdFrame.getContentPane().add(grpNoTf);
		grpNoTf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\pms5.jpg"));
		lblNewLabel_1.setBounds(0, 0, 745, 466);
		assGdFrame.getContentPane().add(lblNewLabel_1);
	}
}
