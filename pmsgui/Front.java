package pmsgui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Front {

	JFrame frontFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front window = new Front();
					window.frontFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
			
		frontFrame = new JFrame("Academic Project Management System");
		frontFrame.getContentPane().setBackground(Color.WHITE);
		frontFrame.setBounds(100, 100, 1168, 628);
		frontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frontFrame.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("PROJECT MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		lblNewLabel.setBounds(42, 21, 1072, 86);
		frontFrame.getContentPane().add(lblNewLabel);
			
		
		
		Button button = new Button("Click To Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frontFrame.setVisible(false);
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
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 14));
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setBounds(482, 470, 189, 55);
		frontFrame.getContentPane().add(button);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Vishal Joshi\\eclipse-workspace\\PROJECT_MANAGEMENT_SYSTEM_GUI\\src\\images\\project management.jpg"));
		lblNewLabel_1.setBounds(80, 125, 1000, 439);
		frontFrame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
