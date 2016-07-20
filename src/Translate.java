public class Translate {

	public static String Translate(String wordToTranslate){
		
		boolean isMando = Dictionary.isMando(wordToTranslate);
		System.out.println("MANDO IS " + isMando);
		if(isMando){
			System.out.println(Dictionary.getLineCount());
			return Dictionary.getWord(Dictionary.getLineCount(), "English.txt");
		}
		else if(!isMando){
			return Dictionary.getWord(Dictionary.getLineCount(), "Mando.txt");
		}
			return wordToTranslate;
	}
}
