package Controller;

import java.util.Scanner;

public class BankReader
{
  private String input_line = "";
  private Scanner scan;
  public BankReader() {
    scan = new Scanner(System.in);  // Reading from System.in
  }
  public char readCommand(String message) {
    System.out.print(message);
    input_line = scan.nextLine().toUpperCase();
    return input_line.charAt(0);
  }

  /*
    reader가 읽은 input_line에서 숫자 return
   */
  public int readAmount()
  {
    int answer = 0;
    String s = input_line.substring(1, input_line.length());

    if(s.length() > 0) {
      double dollars_cents = new Double(s).doubleValue();
      answer = (int)(dollars_cents*100);
    } else
      System.out.println("invalid command - input amount: 0");
    return answer;
  }
}
