package s01;

import java.util.ArrayList;

public class Sms extends Message {

  char[] messageChar;

  public Sms(String sender, ArrayList<String> recipients, String message) {
    super(sender, recipients);
    messageChar = new char[160];
    messageToTab(message);
  }

  private void messageToTab(String message) {
    for (int i = 0; i < message.length(); i++) {
      messageChar[i] = message.charAt(i);
    }
  }

  @Override
  public void display() {
    System.out.println(this);

  }

  @Override
  public String toString() {
    String message = new String(messageChar);
    return message;

  }

  @Override
  public String getType() {
    return "SMS";
  }
}
