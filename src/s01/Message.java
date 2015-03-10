package s01;

import java.util.ArrayList;

public abstract class Message {

  private String            sender;
  private ArrayList<String> recipients;

  public Message(String sender, ArrayList<String> recipients) {
    this.sender = sender;
    this.recipients = recipients;
  }

  public abstract void display();

  public String getSender() {
    return sender;
  }

  public ArrayList<String> getRecipients() {
    return recipients;
  }
  
  public abstract String getType();

}
