package textdateiSpeichernVorlage;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Properties;

/**
 * Diese Klasse speichert key-value-Zuordnungen in Textdateien ab und ruft diese auch wieder vollstaendig ab.
 * @author Lukas Schramm
 * 
 */
public class SpeichernProperties {
	
	private BufferedWriter bw;
	private Properties prop;
	
	public SpeichernProperties() {
		ladeDatei("files/testdatei.txt");
		schreiben("Brandenburg", "Potsdam");
		schreiben("Hessen", "Wiesbaden");
		schreiben("Erde", "Dabendorf");
		schreiben("DOR","Jani","Malte","Lukas");
		schreiben("Frankreich","Napoléon","1","Sarkozy","Chirac","de Gaulle");
		schreiben("Niederlande","Amsterdam","Den Haag");
		
		System.out.println(aufrufen("Klinger"));
		System.out.println(aufrufen("Potsdam"));
		System.out.println(aufrufen("Erde"));
		System.out.println(aufrufen("DOR"));
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Laedt die Datei und die Properties, die zum Laden und Speichern zustaendig sind.
	 * @param dateiname Der Dateiname der Datei, wohin gespeichert/woher geladen wird
	 * @throws IOException
	 */
	private void ladeDatei(String dateiname) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dateiname), Charset.forName("UTF-8")));
			prop = new Properties();
			prop.load(br);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Diese Methode schreibt eine Zuordnung mit einem key und einer beliebigen Anzahl an values in die Textdatei hinein.
	 * @param key Dies ist der key nach dem sortiert wird
	 * @param values Dies sind die dem key zugeordneten values
	 */
	private void schreiben(String key, String... values) {
		try {
			String temp = "";
			for(String str:values) {
				temp += str;
				temp += ",";
			}
			prop.setProperty(key, temp);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("files/testdatei.txt"), Charset.forName("UTF-8")));
			prop.store(bw, "Gespeicherte Werte");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Diese Methode ruft die values anhand ihres zugeordneten keys auf.
	 * @param key Nach diesem key wird in der Datei gesucht
	 * @return Gibt eine List<String> mit den values zurueck
	 */
	private List<String> aufrufen(String key) {
		try {
			String temp = prop.getProperty(key);
			String[] temp2 = temp.split(",");
			List<String> temp3 = Arrays.asList(temp2);
			return temp3;
		} catch (NullPointerException np) { 
			return null;
		}
	}
	
	public static void main(String[] args) {
		new SpeichernProperties();
	}
}