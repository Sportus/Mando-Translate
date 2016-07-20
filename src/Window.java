import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Window extends JFrame {
	private JTextField translationLabel = new JTextField(30);
	private JTextField wordEnterField = new JTextField(25);
	private JButton translate = new JButton("Translate");
	public Window() {
		Container panel1 = wordChooseContainer();
		Container panel2 = translationContainer();
		setLayout(new GridLayout(1, 2));
		add(panel1);
		add(panel2);

		this.getRootPane().setDefaultButton(translate);
		
		setSize(1200, 300);
		setVisible(true);
	}
	private Container wordChooseContainer() {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Attributes"));
		GridLayout layout = new GridLayout(2, 2);
		JPanel panel = new JPanel();
		JLabel text = new JLabel("Word");
		panel.add(text);
		Font font = new Font("ComicSans", Font.BOLD, 25);
		wordEnterField.setHorizontalAlignment(SwingConstants.CENTER);
		wordEnterField.setFont(font);
		panel.add(wordEnterField);
		translate.addActionListener(new ButtonHandler(this.wordEnterField, this.translationLabel));
		container.add(panel);
		container.add(translate);
		container.setLayout(layout);
		return container;
	}

	private Container translationContainer() {
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createTitledBorder("Translation"));
		BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
		container.add(translationLabel);
		translationLabel.setSize(100, 100);
		Font font = new Font("SansSerif", Font.BOLD, 20);
		translationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		translationLabel.setFont(font);
		container.setLayout(layout);
		return container;
	}
	public void setPasswordText(String passwordText) {
		translationLabel.setText(passwordText);
	}
}
