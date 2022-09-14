package pmsgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class User {

	JFrame userFrame;
	/**
	 * Create the application.
	 */
	public User() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userFrame = new JFrame("Academic Project Management System");
		userFrame.setBounds(100, 100, 941, 596);
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 925, 32);
		userFrame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Student");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		//Action listener for Add student Frame
		JMenuItem mntmNewMenuItem = new JMenuItem("Add new Student");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddStudent window = new AddStudent();
							window.addStdFrame.setVisible(true);
							//std.initialize();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		//Action listener for Display student Frame
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Display Student");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayStudent window = new DisplayStudent();
							window.displayStdFrame.setVisible(true);
							//dispstd.initialize();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Group");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		//Action Listener for Add Group Frame
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Group");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddGroup window = new AddGroup();
							window.addGrpFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		//Action Listener for Display Group Frame
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Display Group");
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayGroup window = new DisplayGroup();
							window.dispGrpFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_19);
		
		JMenu mnNewMenu_3 = new JMenu("Guide");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		//Action Listener for Assign Guide Frame
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Assign Guide");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AssignGuide window = new AssignGuide();
							window.assGdFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		//Action Listener for Display Guide Frame
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Display Guide");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayGuide window = new DisplayGuide();
							window.dispGdFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("Project");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		
		//Action Listener for Assign Project Frame
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Assign Project");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AssignProject window = new AssignProject();
							window.assProjectFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		//Action Listener for Display Project Frame
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Display Project");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayProject window = new DisplayProject();
							window.dispProjectFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_7 = new JMenu("Marks");
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_7);
		
		//Action Listener for Assign Marks Frame
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Assign Final Marks");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AssignMarks window = new AssignMarks();
							window.assMarksFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_16);
		
		//Action Listener for Display Marks Frame
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Display Total Marks");
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayMarks window = new DisplayMarks();
							window.dispMarksFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_17);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame();
				userFrame.setVisible(false);
				try {
					Conn c = new Conn();
					PreparedStatement ps = c.conn.prepareStatement("UPDATE project_management_system.loggedin SET username = (?), password = (?)");
					ps.setString(1, "anonymous");
					ps.setString(2, "anonymous");
					ps.executeUpdate();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Login window = new Login();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(f, "Something went wrong");
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		menuBar.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(367, 88, 157, 40);
		userFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select the Operation You want to perform from above Menu");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(453, 139, 379, 19);
		userFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\project-management.jpg"));
		lblNewLabel_2.setBounds(0, 30, 925, 527);
		userFrame.getContentPane().add(lblNewLabel_2);
	}
}
