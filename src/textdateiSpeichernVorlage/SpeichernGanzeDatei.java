package textdateiSpeichernVorlage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Diese Klasse speichert Texte vollstaendig in Textdateien ab und ruft diese auch wieder vollstaendig als String ab.
 * @author Lukas Schramm
 * 
 */
public class SpeichernGanzeDatei {
	
	/**
	 * Diese Methode speichert einen Text in einer Textdatei.
	 * @param dateiname Der Dateiname der Datei, wohin gespeichert wird
	 * @param text Der Text, der gespeichert werden muss
	 */
	public void speichern(String dateiname,String text) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dateiname), Charset.forName("UTF-8")));
			char[] tempChar = text.toCharArray();
			bw.write(tempChar);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Diese Methode ruft gespeicherte Texte aus der Textdatei wieder auf und gibt sie als String zurueck.
	 * @param dateiname Der Dateiname der Datei, aus welcher geladen wird
	 * @return Gibt den geladenen Text wieder
	 */
	public String laden(String dateiname) {
		File f = new File(dateiname);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dateiname), Charset.forName("UTF-8")));
			char[] tempChar = new char[(int)f.length()];
			br.read(tempChar);
			br.close();
			
			String ges = new String(tempChar);
			return ges;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		SpeichernGanzeDatei sgd = new SpeichernGanzeDatei();
		String text = "Weit hinten, hinter den Wortbergen, fern der Länder Vokalien und Konsonantien leben die Blindtexte.Abgeschieden wohnen Sie in Buchstabhausen an der Küste des Semantik, eines großen Sprachozeans. Ein kleines Bächlein namens Duden fließt durch ihren Ort und versorgt sie mit den nötigen Regelialien. Es ist ein paradiesmatisches Land, in dem einem gebratene Satzteile in den Mund fliegen. Nicht einmal von der allmächtigen Interpunktion werden die Blindtexte beherrscht – ein geradezu unorthographisches Leben. Eines Tages aber beschloß eine kleine Zeile Blindtext, ihr Name war Lorem Ipsum, hinaus zu gehen in die weite Grammatik. Der große Oxmox riet ihr davon ab, da es dort wimmele von bösen Kommata, wilden Fragezeichen und hinterhältigen Semikoli, doch das Blindtextchen ließ sich nicht beirren. Es packte seine sieben Versalien, schob sich sein Initial in den Gürtel und machte sich auf den Weg. Als es die ersten Hügel des Kursivgebirges erklommen hatte, warf es einen letzten Blick zurück auf die Skyline seiner Heimatstadt Buchstabhausen, die Headline von Alphabetdorf und die Subline seiner eigenen Straße, der Zeilengasse. Wehmütig lief ihm eine rethorische Frage über die Wange, dann setzte es seinen Weg fort. Unterwegs traf es eine Copy. Die Copy warnte das Blindtextchen, da, wo sie herkäme wäre sie zigmal umgeschrieben worden und alles, was von ihrem Ursprung noch übrig wäre, sei das Wort “und” und das Blindtextchen solle umkehren und wieder in sein eigenes, sicheres Land zurückkehren. Doch alles Gutzureden konnte es nicht überzeugen und so dauerte es nicht lange, bis ihm ein paar heimtückische Werbetexter auflauerten, es mit Longe und Parole betrunken machten und es dann in ihre Agentur schleppten, wo sie es für ihre Projekte wieder und wieder mißbrauchten. Und wenn es nicht umgeschrieben wurde, dann benutzen Sie es immernoch.";
		sgd.speichern("testdatei.txt", text);
		System.out.println(sgd.laden("testdatei.txt"));
	}

}