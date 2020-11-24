import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	JButton button = new JButton("Submit");
	JPanel panel = new JPanel();
	JTextField textField = new JTextField(15);
	JPasswordField jPasswordField = new JPasswordField(15);
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	BufferedReader reader;

	Login() {

		super("Authentification");
		label.setText("Username:");
		label2.setText("Password:");

		this.setSize(300, 200);
		this.setLocation(500, 280);
		this.setTitle("Login");
		panel.setLayout(null);

		label.setBounds(10, 30, 100, 20);
		label2.setBounds(10, 65, 100, 20);
		textField.setBounds(80, 30, 150, 20);
		jPasswordField.setBounds(80, 65, 150, 20);
		button.setBounds(110, 100, 80, 20);

		panel.add(label);
		panel.add(label2);
		panel.add(button);
		panel.add(textField);
		panel.add(jPasswordField);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	public void actionlogin() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String name = textField.getText();
				String pwd = jPasswordField.getText();
				try {
					reader = new BufferedReader(new FileReader("Resources/UsernamesPasswords.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				boolean auth = false;
				String line;
				try {
					while ((line = reader.readLine()) != null) {
						if (line.equals(name + ":" + pwd)) {
							auth = true;
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (auth) {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					textField.setText("");
					jPasswordField.setText("");
					textField.requestFocus();
				}

			}
		});
	}
}
