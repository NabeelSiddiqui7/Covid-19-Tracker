import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JButton addButton;
	JButton removeButton;
	JButton calculateButton;
	JComboBox analysisBox;
	JTextField addCountryText;
	JTextField removeCountryText;
	JTextArea countryList;
	JTextArea outputArea;
	ArrayList<String> countries = new ArrayList<String>();
	ArrayList<Double> results = new ArrayList<Double>();

	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 500);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("Covid-19 Tracker");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		FlowLayout flow = new FlowLayout();
		flow.setHgap(50);
		panel3.setLayout(flow);

		panel1.setBackground(Color.lightGray);
		panel3.setBackground(Color.lightGray);
		panel4.setBackground(Color.lightGray);

		panel1.setPreferredSize(new Dimension(100, 80));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(200, 80));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		JLabel label = new JLabel(new ImageIcon("Resources/map.jpg"));
		label.setLayout(new BorderLayout());
		JLabel addCountry = new JLabel("Add a Country");
		JLabel removeCountry = new JLabel("Remove a Country");
		JLabel selectedCountries = new JLabel("Selected Countries");
		JLabel output = new JLabel("Output");
		JLabel selectAnalysis = new JLabel("Choose Analysis Type");

		addCountryText = new JTextField();
		addCountryText.setPreferredSize(new Dimension(150, 20));
		removeCountryText = new JTextField();
		removeCountryText.setPreferredSize(new Dimension(150, 20));

		addButton = new JButton("Add");
		addButton.addActionListener(this);
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(this);

		String[] analysisTypes = { "Total Confirmed Cases per Country", "Total Confirmed Cases per Capita", "Total Deaths per Country", "Total Deaths per Capita" };
		analysisBox = new JComboBox(analysisTypes);

		countryList = new JTextArea(6, 15);
		countryList.setEditable(false);
		outputArea = new JTextArea(6, 15);
		outputArea.setEditable(false);

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.EAST);
		this.add(panel4, BorderLayout.SOUTH);
		this.add(label, BorderLayout.CENTER);
		panel1.add(addCountry);
		panel1.add(addCountryText);
		panel1.add(addButton);
		panel1.add(removeCountry);
		panel1.add(removeCountryText);
		panel1.add(removeButton);
		panel3.add(selectedCountries);
		panel3.add(countryList);
		panel3.add(calculateButton);
		panel3.add(output);
		panel3.add(outputArea);
		panel4.add(selectAnalysis);
		panel4.add(analysisBox);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			countryList.setText("");
			System.out.println("Added " + addCountryText.getText());
			countries.add(addCountryText.getText());
			for (int i = 0; i < countries.size(); i++) {
				countryList.append(countries.get(i) + "\n");
			}
			for (int i = 0; i < countries.size(); i++) {
				System.out.println(countries.get(i));
			}
			addCountryText.setText("");
		}

		if (e.getSource() == removeButton) {
			countryList.setText("");
			System.out.println("Removed " + removeCountryText.getText());
			countries.remove(removeCountryText.getText());
			for (int i = 0; i < countries.size(); i++) {
				countryList.append(countries.get(i) + "\n");
			}
			for (int i = 0; i < countries.size(); i++) {
				System.out.println(countries.get(i));
			}
			removeCountryText.setText("");
		}

		if (e.getSource() == calculateButton){
			/*STRATEGY DESIGN PATTERN - create an context variable to
			 see change in behaviour when it changes its analysis*/
			Context context;
			if (analysisBox.getSelectedItem() == "Total Confirmed Cases per Country"){
				System.out.println("Calculating confirmed cases for list of countries.");
				context = new Context((new TotalCasesPerCountry()));
			}
			else if (analysisBox.getSelectedItem() == "Total Confirmed Cases per Capita"){
				System.out.println("Calculating total confirmed cases per capita.");
				context = new Context((new TotalCasesPerCapita()));
			}
			else if (analysisBox.getSelectedItem() == "Total Deaths per Country"){
				System.out.println("Calculating total deaths for list of countries.");
				context = new Context((new TotalDeathsPerCountry()));
			}
			else /*(analysisBox.getSelectedItem() == "Total Deaths per Capita")*/{
				System.out.println("Calculating total deaths per capita.");
				context = new Context((new TotalDeathsPerCapita()));
			}

			results = context.executeAnalysis(countries);
			outputArea.setText("");
			for (int i = 0; i < countries.size(); i++) {
				outputArea.append(countries.get(i) + ":" + results.get(i) + "\n");
			}
		}

	}

}
