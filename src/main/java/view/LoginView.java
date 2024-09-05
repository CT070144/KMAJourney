package view;


import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.LoginControl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	


	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 711);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 this.setLocationRelativeTo(null);

		this.setTitle("KMA Journey");
		URL url = LoginView.class.getResource("Image.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/view/0011.jpg")));
		lblNewLabel.setBounds(134, 102, 276, 268);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 45));
		lblNewLabel_1.setBounds(674, 159, 162, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UserName");
		lblNewLabel_2.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(578, 283, 126, 21);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(578, 228, 339, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_2_1.setBounds(578, 359, 126, 21);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("ACADEMY OF CRYPTOGRAPHY TECHNIQUES");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(65, 410, 448, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("KMA Journey - JAVA SWING");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(174, 456, 210, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Developby BeeNguyen");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(848, 643, 178, 21);
		contentPane.add(lblNewLabel_4_1);
		LoginControl actionListener = new LoginControl(this);
		JButton login = new JButton("Login");
		login.addActionListener(actionListener);
		login.setBackground(new Color(220, 220, 220));
	
		login.setFont(new Font("Arial", Font.BOLD, 16));
		
		login.setBounds(696, 446, 91, 31);
		contentPane.add(login);
		
		JLabel lblNewLabel_5 = new JLabel("Forgot password ?");
		lblNewLabel_5.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_5.setBounds(578, 573, 146, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Create your account");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_5_1.setBounds(578, 597, 146, 21);
		contentPane.add(lblNewLabel_5_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(578, 616, 146, 2);
		contentPane.add(separator_1);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 16));
		username.setBackground(new Color(255, 255, 255));
		username.setBounds(578, 304, 339, 35);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(578, 387, 339, 35);
		contentPane.add(password);
		this.setVisible(true);
	}
	
	public void check2() {
		if(username.getText().equals("CT070144")&&password.getText().equals("123123")) {
			JOptionPane.showMessageDialog(this, "Login Successfully");
			
			KMAJourneyView ex = new KMAJourneyView();
		
			this.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid username");

		}
		
	}
}
