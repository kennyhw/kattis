import java.util.*;

class ANewAlphabet {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String input = sc.nextLine();
    sc.close();
    
    System.out.println(translator(input));
  }
  
  public static String translator(String input) {
    input = input.toLowerCase();
    
    String catalog = "abcdefghijklmnopqrstuvwxyz";
    String[] translateBook = new String[26];
    
    translateBook[0] = "@";
    translateBook[1] = "8";
    translateBook[2] = "(";
    translateBook[3] = "|)";
    translateBook[4] = "3";
    translateBook[5] = "#";
    translateBook[6] = "6";
    translateBook[7] = "[-]";
    translateBook[8] = "|";
    translateBook[9] = "_|";
    translateBook[10] = "|<";
    translateBook[11] = "1";
    translateBook[12] = "[]\\/[]";
    translateBook[13] = "[]\\[]";
    translateBook[14] = "0";
    translateBook[15] = "|D";
    translateBook[16] = "(,)";
    translateBook[17] = "|Z";
    translateBook[18] = "$";
    translateBook[19] = "']['";
    translateBook[20] = "|_|";
    translateBook[21] = "\\/";
    translateBook[22] = "\\/\\/";
    translateBook[23] = "}{";
    translateBook[24] = "`/";
    translateBook[25] = "2";
    
    String output = "";
    
    for(int a = 0; a < input.length(); a++) {
      if(Character.isLetter(input.charAt(a))) {
        int idx = catalog.indexOf(input.charAt(a));
        output += translateBook[idx];
      } else {
        output += input.charAt(a);
      }
    }
    
    return output;
  }
}