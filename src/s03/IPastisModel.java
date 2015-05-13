//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package s03;

public interface IPastisModel {
  
  String  UC_CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ";
  String  LC_CONSONANTS = "bcdfghjklmnpqrstvwxz";
  String  UC_VOWELS     = "AEIOUY";
  String  LC_VOWELS     = "aeiouy";
  String  SYMBOLS       = "@$#%-.!&,:?<>[]/(){}+_^~";

  //----------------------------------------------------------------------------
  // Password generation constraints
  //----------------------------------------------------------------------------
  int pwLength();
  
  boolean withUcLetters();
  
  boolean withLcLetters();
  
  boolean withDigits();

  boolean withSymbols();
  
  boolean isPronounceable();
  
  boolean isUnambiguous();
  
  //----------------------------------------------------------------------------
  // Generate a new password
  //----------------------------------------------------------------------------
  String getNewPassword();
  
  //============================================================================
  // Utilities
  //============================================================================
  default String getUcLetters() {
    return getCharRange('A', 'Z');
  }
  
  //----------------------------------------------------------------------------
  default String getLcLetters() {
    return getCharRange('a', 'z');
  }
  
  default String getUcConsonants() {
    return UC_CONSONANTS;
  }
  
  //----------------------------------------------------------------------------
  default String getLcConsonants() {
    return LC_CONSONANTS;
  }
  
  //----------------------------------------------------------------------------
  default String getDigits() {
    return getCharRange('0', '9');
  }
  
  //----------------------------------------------------------------------------
  default String getLcVowels() {
    return LC_VOWELS;
  }
  
  //----------------------------------------------------------------------------
  default String getUcVowels() {
    return UC_VOWELS;
  }
  
  //----------------------------------------------------------------------------
  default String getSymbols() {
    return SYMBOLS;
  }
  
  //----------------------------------------------------------------------------
  // Generate String containing all characters between 'from' and 'to'
  //----------------------------------------------------------------------------
  default String getCharRange(char from, char to) {
    String r = "";
    
    for (char c=from; c<=to; c++) {
      r = r + c;
    }
    return r;
  }
}