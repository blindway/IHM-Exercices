package s01;

import java.util.ArrayList;

import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;

public class test {
  public static void main(String[] args) {
    new JFXPanel();
    MailBox mailBox = new MailBox();

    ArrayList<String> contacts = new ArrayList<String>();
    contacts.add("Travasso");
    contacts.add("Pirlet");
    contacts.add("");
    contacts.add("123");

    Email mail = new Email("Adriano", contacts, "Salut ça va?");

    mailBox.send(mail);

    Sms sms = new Sms("Alex", contacts, "Oui et vous?");
    mailBox.send(sms);

    Image image = new Image("http://bit.ly/1zkQXI1");
    Mms mms = new Mms("Pirlet", contacts, "eheheh", image);
    mailBox.send(mms);

    mailBox.receive();
    mailBox.receive();
    mailBox.receive();
  }
}
