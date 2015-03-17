package s01;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class MailBox {

	public void send(Message message) {
		System.out.println(message.getType() + " envoyé par "
				+ message.getSender() + " à "
				+ message.getRecipients().toString() + " : "
				+ message.toString());
	}

	public void receive() {
		String resultat = "Vous n'avez pas de messages.";
		Image image = new Image("http://bit.ly/1zkQXI1");
		ArrayList<String> contacts = new ArrayList<String>();
		int nbr;

		contacts.add("Adriano");
		Email mail = new Email("Alex", contacts, "Travail prog", Color.BLACK);
		Sms sms = new Sms("Jean", contacts, "Go manger?", Color.YELLOW);
		Mms mms = new Mms("Carla", contacts, "Photooo", image, Color.WHITE);
		Snapchat snap = new Snapchat("Jean", contacts, image, Color.RED);

		Random rdm = new Random();
		nbr = rdm.nextInt(100);

		if (nbr >= 50 && nbr < 60) {
			resultat = "Vous avez reçu un Snapchat de " + snap.getSender()
					+ ": " + snap.toString();
		} else if (nbr >= 60 && nbr < 80) {
			resultat = "Vous avez reçu un E-mail de " + mail.getSender() + ": "
					+ mail.toString();
		} else if (nbr >= 80 && nbr < 90) {
			resultat = "Vous avez reçu un SMS de " + sms.getSender() + ": "
					+ sms.toString();
		} else if (nbr >= 90 && nbr < 100) {
			resultat = "Vous avez reçu un MMS de " + mms.getSender() + ": "
					+ mms.toString();
		}
		System.out.println(resultat);
	}
}
