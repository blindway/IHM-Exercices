package s03;

import java.util.Random;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class PastisModel implements IPastisModel {

	Random r = new Random();
	String mdp = new String();
	char[] chars;

	// Longueur par défault
	int l = 12;

	// Constructeur
	public PastisModel() {

	}

	public int pwLength() {

		// Check dans la vue ?
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean withUcLetters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withLcLetters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withDigits() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withSymbols() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPronounceable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUnambiguous() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNewPassword() {

		// si minuscules
		if (withLcLetters()) {
			chars = getLcLetters().toCharArray();
		}

		// si majuscules
		if (withUcLetters()) {
			String strtemp = getUcLetters();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// si digits
		if (withDigits()) {
			String strtemp = getDigits();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// si symbols
		if (withSymbols()) {
			String strtemp = getSymbols();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// reçoit la longueur du mdp
		l = pwLength();

		// création du mdp
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			char c = chars[r.nextInt(chars.length)];
			sb.append(c);
		}
		mdp = sb.toString();
		
		// insertion dans le clipboard
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent  cbContent = new ClipboardContent();
		cbContent.putString(mdp);
		clipboard.setContent(cbContent);
		
		
		return mdp;
	}
}
