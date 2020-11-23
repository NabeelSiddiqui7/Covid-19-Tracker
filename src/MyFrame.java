import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JButton button;
	JButton button2;
	JButton button3;
	JTextField textField;
	JTextField textField2;
	JTextArea textArea;
	JTextArea textArea2;

	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 500);
		this.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		panel1.setBackground(Color.lightGray);
		panel3.setBackground(Color.lightGray);
		panel4.setBackground(Color.lightGray);

		panel1.setPreferredSize(new Dimension(100, 80));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(200, 80));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		JLabel label = new JLabel(new ImageIcon("C:\\Users\\nabee\\eclipse-workspace\\Covid-19 Tracker\\src\\map.jpg"));
		label.setLayout(new BorderLayout());

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, 20));
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(150, 20));

		button = new JButton("Submit");
		button.addActionListener(this);
		button2 = new JButton("Remove");
		button2.addActionListener(this);
		button3 = new JButton("Calculate");
		button3.addActionListener(this);

		String[] analysisTypes = { "Analysis 1", "Analysis 2", "Analysis 3" };
		JComboBox comboBox = new JComboBox(analysisTypes);

		textArea = new JTextArea(6, 15);
		textArea2 = new JTextArea(6, 15);

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.EAST);
		this.add(panel4, BorderLayout.SOUTH);
		this.add(label, BorderLayout.CENTER);
		panel1.add(textField);
		panel1.add(button);
		panel1.add(textField2);
		panel1.add(button2);
		panel3.add(textArea);
		panel3.add(button3);
		panel3.add(textArea2);
		panel4.add(comboBox);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("Added " + textField.getText());
			textArea.append(textField.getText() + "\n");
			textField.setText("");
		}

		if (e.getSource() == button2) {
			System.out.println("Removed " + textField2.getText());
			textArea.setText(textArea.getText().replace(textField2.getText(), ""));
			textField2.setText("");
		}

	}

}
