import java.util.*;

class DiceGame{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int gunnar1A = sc.nextInt();
    int gunnar1B = sc.nextInt();
    int gunnar2A = sc.nextInt();
    int gunnar2B = sc.nextInt();
    
    int emma1A = sc.nextInt();
    int emma1B = sc.nextInt();
    int emma2A = sc.nextInt();
    int emma2B = sc.nextInt();
    
    sc.close();
    
    int gunnarWinCases = 0;
    int emmaWinCases = 0;
    
    for(int a = gunnar1A; a <= gunnar1B; a++) {
      for(int b = gunnar2A; b <= gunnar2B; b++) {
        for(int c = emma1A; c <= emma1B; c++) {
          for(int d = emma2A; d <= emma2B; d++) {
            int gunnarCount = a + b;
            int emmaCount = c + d;
            
            if(gunnarCount > emmaCount) {
              gunnarWinCases++;
            } else if(gunnarCount < emmaCount) {
              emmaWinCases++;
            }
          }
        }
      }
    }
    
    if(gunnarWinCases > emmaWinCases) {
      System.out.println("Gunnar");
    } else if(gunnarWinCases < emmaWinCases) {
      System.out.println("Emma");
    } else{
      System.out.println("Tie");
    }
  }
}