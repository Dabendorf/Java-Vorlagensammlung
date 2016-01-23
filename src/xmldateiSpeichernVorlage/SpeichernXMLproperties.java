package xmldateiSpeichernVorlage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Diese Vorlage speichert eine Menge von Key-Value-Zuordnungen in einer xml-Datei und ruft sie wieder auf.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class SpeichernXMLproperties {
	
	/**Pfad zur Speicherdatei für Spieleinstellungen*/
	private String fileExample = "files/example.xml";
	/**Schluessel fuer die Vigenereverschluesselung*/
	private char[] vigKey = "Heizoelrueckstossabdaempfung".toCharArray();
	/**Zu speichernde Propertieselemente*/
	private Properties props = new Properties();
	/**Die geladene Speicherdatei*/
	private File file;
	
	/**Beispiel fuer einen String*/
	private String exampleString = "TestString";
	/**Beispiel fuer einen Integer*/
	private int exampleInt = 42;
	/**Beispiel fuer einen Boolean*/
	private boolean exampleBoolean = false;
	
	public SpeichernXMLproperties() {
		file = new File(fileExample);
	}
	
	/**
	 * Diese Methode schreibt alle Einstellungen eines Spielers in einer xml-Datei.
	 */
	public void writeSettings() {
		try {
			props.setProperty("testString", encrypt(exampleString));
			props.setProperty("testInt", encrypt(String.valueOf(exampleInt)));
			props.setProperty("testBoolean", encrypt(String.valueOf(exampleBoolean)));
			
			FileOutputStream fileOut = new FileOutputStream(file);
			props.storeToXML(fileOut, "Example File");
			fileOut.close();
		} catch(IOException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				fileDamage(fileExample);
			}
		}
	}

	/**
	 * Diese Methode liest alle Einstellungen eines Spielers aus einer xml-Datei.
	 */
	public void readSettings() {
		try {
			FileInputStream fileInput = new FileInputStream(file);
			props.loadFromXML(fileInput);
			fileInput.close();
			exampleString = decrypt(props.getProperty("testString"));
			exampleInt = Integer.valueOf(decrypt(props.getProperty("testInt")));
			exampleBoolean = Boolean.valueOf(decrypt(props.getProperty("testBoolean")));
		} catch(IOException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				fileDamage(fileExample);
			}
		}
	}

	/**
	 * Diese Methode verschluesselt den eingegebenen String.
	 * @param original Nimmt den Originalstring entgegen.
	 * @return Gibt den verschluesselten String aus.
	 */
	private String encrypt(String original) {
		char[] temp = original.toCharArray();
		String crypt = new String("");
		for(int i=0;i<temp.length;i++) {
			int result = (temp[i] + vigKey[i%vigKey.length]) % 256;
			crypt += (char) result;
		}
		return crypt;
	}
 	
 	/**
	 * Diese Methode entschluesselt den eingegebenen String.
	 * @param encrypted Nimmt den verschluesselten String entgegen.
	 * @return Gibt den entschluesselten String aus.
	 */
 	private String decrypt(String encrypted) {
  		char[] temp = encrypted.toCharArray();
  		String decrypt = new String("");
  		for(int i=0;i<temp.length;i++) {
  			int result;
  			if(temp[i] - vigKey[i%vigKey.length] < 0) {
  				result =  (temp[i] - vigKey[i%vigKey.length]) + 256;
  			} else {
  				result = (temp[i] - vigKey[i%vigKey.length]) % 256;
  			}
  			decrypt += (char) result;
  		}
  		return decrypt;
 	}
 	
 	/**
	 * Diese Methode gibt eine Meldung ueber eine fehlerhaft angelegte oder nicht vorhandene Speicherdatei aus.
	 * @param filename Pfad der fehlerhaften Datei.
	 */
	public void fileDamage(String filename) {
		String linebreak = System.getProperty("line.separator");
		JOptionPane.showMessageDialog(null, "Die Speicherdatei /"+filename+" ist nicht vorhanden oder beschädigt."+linebreak+"Die Spielfunktion ist nur eingeschränkt möglich."+linebreak+"Stelle die Speicherdatei wieder her und versuche es erneut.", "Fehlerhafte Datei", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		SpeichernXMLproperties sxmlp = new SpeichernXMLproperties();
		sxmlp.readSettings();
		System.out.println(sxmlp.exampleString);
		System.out.println(sxmlp.exampleInt);
		System.out.println(sxmlp.exampleBoolean);
	}
}