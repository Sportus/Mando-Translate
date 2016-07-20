import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ButtonHandler implements ActionListener{

	private JTextField wordToEnterField;
	private JTextField translatedWordField;
	public ButtonHandler(JTextField wordEnter, JTextField translatedWord){
		this.wordToEnterField = wordEnter;
		this.translatedWordField = translatedWord;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String wordToTranslate = wordToEnterField.getText();
		translatedWordField.setText(Translate.Translate(wordToTranslate));
	}

}
