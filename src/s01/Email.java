package s01;

import java.util.ArrayList;

public class Email extends Message {

  String message;

  public Email(String sender, ArrayList<String> recipients, String message) {
    super(sender, recipients);
    this.message = message;
  }

  @Override
  public void display() {
    System.out.println(this);
  }

  @Override
  public String toString() {
    return message;
  }

  @Override
  public String getType(){
    return "Email";
  }
}
