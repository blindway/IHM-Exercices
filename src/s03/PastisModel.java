package s03;

import java.util.Random;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class PastisModel implements IPastisModel {

	private Random r = new Random();
	private String mdp = new String();
	private char[] chars;

	// Longueur par defaut
	private int length = 12;

	private boolean ucLetters;
	private boolean lcLetters;
	private boolean digits;
	private boolean symbols;
	private boolean pronounceable;
	private boolean unAmbiguous;

	// Constructeur
	public PastisModel() {
	}

	public String getNewPassword() {
		int count = 0;
		// recoit la longueur du mdp
		length = pwLength();

		chars = new char[length * 4];
		// si minuscules
		if (withLcLetters()) {
			chars = getLcLetters().toCharArray();
			count = 26;
		}

		// si majuscules
		if (withUcLetters()) {
			String strtemp = getUcLetters();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
				count++;
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// si digits
		if (withDigits()) {
			String strtemp = getDigits();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
				count++;
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// si symbols
		if (withSymbols()) {
			String strtemp = getSymbols();
			for (int i = 0; i < chars.length; i++) {
				strtemp += chars[i];
				count++;
			}
			char[] temp = strtemp.toCharArray();
			chars = temp;
		}

		// creation du mdp
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char x = '\0';
			while (x == '\0') {
				x = chars[r.nextInt(chars.length)];
			}
			//char c = chars[r.nextInt(length)];
			sb.append(x);
		}
		mdp = sb.toString();

		// si caracteres ambigus
		if (isUnambiguous()) {
			if (mdp.contains("i") || mdp.contains("I") || mdp.contains("l")
					|| mdp.contains("0") || mdp.contains("O")) {
				mdp = getNewPassword();
			}
		}

		// insertion dans le clipboard
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent cbContent = new ClipboardContent();
		cbContent.putString(mdp);
		clipboard.setContent(cbContent);

		return mdp;
	}

	// --------------------------------------------------------------------------
	// Getters
	// --------------------------------------------------------------------------

	public int pwLength() {
		return length;
	}

	@Override
	public boolean withUcLetters() {
		return ucLetters;
	}

	@Override
	public boolean withLcLetters() {
		return lcLetters;
	}

	@Override
	public boolean withDigits() {
		return digits;
	}

	@Override
	public boolean withSymbols() {
		return symbols;
	}

	@Override
	public boolean isPronounceable() {
		return pronounceable;
	}

	@Override
	public boolean isUnambiguous() {
		return unAmbiguous;
	}

	// --------------------------------------------------------------------------
	// Setters
	// --------------------------------------------------------------------------

	public void setLength(int length) {
		this.length = length;
	}

	public void setUcLetters(boolean ucLetters) {
		this.ucLetters = ucLetters;
	}

	public void setLcLetters(boolean lcLetters) {
		this.lcLetters = lcLetters;
	}

	public void setDigits(boolean digits) {
		this.digits = digits;
	}

	public void setSymbols(boolean symbols) {
		this.symbols = symbols;
	}

	public void setPronounceable(boolean pronounceable) {
		this.pronounceable = pronounceable;
	}

	public void setUnAmbiguous(boolean unAmbiguous) {
		this.unAmbiguous = unAmbiguous;
	}

}
