package cyy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Account {

	private JFrame frame;
	public JTextField userName;
	private JTextField password;
	public CarAssistant car;
	public static String account="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account window = new Account();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account() {
		initialize();
		car=new CarAssistant();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 390, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel userNameLable = new JLabel("UserName");
		userNameLable.setBounds(10, 25, 64, 29);
		frame.getContentPane().add(userNameLable);
		
		JLabel passwordLable = new JLabel("Password");
		passwordLable.setBounds(10, 64, 64, 23);
		frame.getContentPane().add(passwordLable);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!userName.getText().equals("") && !password.getText().equals("")) {
					account=userName.getText();
//					car.open();
				}else {
					JOptionPane.showMessageDialog(frame, "Please input correct UserName and Password!", "Notic",JOptionPane.WARNING_MESSAGE); 
				}
	
	
			}
		});
		login.setBounds(141, 101, 93, 31);
		frame.getContentPane().add(login);
		
		userName = new JTextField();
		userName.setBounds(84, 22, 254, 31);
		frame.getContentPane().add(userName);
		userName.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(84, 60, 254, 31);
		frame.getContentPane().add(password);
	}
}
