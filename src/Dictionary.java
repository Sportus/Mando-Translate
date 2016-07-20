import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static Integer lineCount = null;

	public static Boolean isMando(String wordToFind) {
		Boolean isMando = null;
		isMando = findWord(wordToFind, "Mando.txt");

		System.out.println("Looking at english");
		if (isMando == null) {
		} else if (isMando) {
			return true;
		}
		return !findWord(wordToFind, "English.txt");
	}

	private static Boolean findWord(String wordToFind, String fileName) {
		System.out.println("Searching through " + fileName + " for " + wordToFind.toLowerCase());
		wordToFind = wordToFind.toLowerCase();
		wordToFind = wordToFind.trim();
		int count = 0;
		boolean endOfFile = false;
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while (endOfFile == false) {
				count++;
				try {
					line = reader.readLine();
					// Reached the end of the file
					if (line == null) {
						System.out.println("Could not find a word "
								+ wordToFind + ". Count was " + count);
						endOfFile = true;
					}

					// Reading a line
					else {
						line = line.trim();
						line = line.toLowerCase();
						// If whole line == wordToFind
						if (line.equals(wordToFind)) {
							lineCount = count;
							map.put(count, 0);
							return true;
						}

						// Now checking for commas for multiple words
						else {
							// Building a string
							String currentString = "";
							int numberOfCommas = 0;
							// For line.length
							for (int i = 0; i < line.length(); i++) {
								// If the char == ',', then you have completed a
								// word, now checking to see if the word is true
								if (line.charAt(i) == ',') {
									// If the currentString is a word, then you
									// can put it in map and end file
									System.out.println("Current String to check " + currentString.toLowerCase().trim() + " with "
											+ wordToFind);
											
									if (currentString.toLowerCase().trim().equals(wordToFind)) {
										lineCount = count;
										map.put(count, numberOfCommas);
										return true;
									}
									// If the string is not a word, then
									// increment i(Format is "Hello, hi, word")
									// Reset String
									else {
										i++;
										numberOfCommas++;
										currentString = "";
									}
								}
								// If the line is not a comma, keep building
								// string
								else {
									currentString += line.charAt(i);
								}
							}
							
							System.out.println("Checking if currentString " + currentString.toLowerCase().trim() + " = " + wordToFind);
							if(currentString.toLowerCase().trim().equals(wordToFind)){
								lineCount = count;
								map.put(count, numberOfCommas);
								return true;
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Returning null");
		return null;
	}

	public static String getWord(int line, String fileName) {

		System.out.println("Looking for word at " + line);

		int count = 1;
		String word = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while (count < line) {
				System.out.println("Searching.... at " + count);
				count++;

				try {
					reader.readLine();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try{
					System.out.println("FOUND");
					word = reader.readLine();
					System.out.println(word + " FOUND IT PLEASE");
			}
			catch(IOException e){
				
			}
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return word;
	}

	public static HashMap<Integer, Integer> getMap() {
		return map;
	}

	public static Integer getLineCount() {
		return lineCount;
	}
}
