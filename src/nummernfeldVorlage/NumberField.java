package nummernfeldVorlage;

import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

public class NumberField {
	
	public NumberField() {
		NumberFormat format = NumberFormat.getInstance(); 
	    format.setGroupingUsed(false); 
	    NumberFormatter formatter = new NumberFormatter(format); 
	    formatter.setAllowsInvalid(false);
	    
	    ///====
	    JFormattedTextField nummernfeld = new JFormattedTextField(formatter);
	    nummernfeld.getText();
	}
}