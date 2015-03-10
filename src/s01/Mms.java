package s01;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Mms extends Message {

  String message;
  Image  image;

  public Mms(String sender, ArrayList<String> recipients, String message,
      Image image) {
    super(sender, recipients);
    this.message = message;
    this.image = image;
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
  public String getType() {
    return "MMS";
  }
}
