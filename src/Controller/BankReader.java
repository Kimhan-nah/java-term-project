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
    input_line = scan.nextLine();
    input_line = input_line.toUpperCase();
    // TODO : GUI 구현 안 할거면 charAt 예외처리 추가 필요함
    return input_line.charAt(0);
  }

  /*
    reader가 읽은 input_line에서 숫자 return
   */
  public int readAmount()
  {
    // TODO : GUI 구현 안 할거면 수정 필요함
    int answer = 0;
    String s = input_line.substring(1, input_line.length());

    if(s.length() > 0) {
      answer = Integer.getInteger(s);
//      double dollars_cents = new Double(s).doubleValue();
//      answer = (int)(dollars_cents*100);
    } else
      System.out.println("invalid command - input amount: 0");
    return answer;
  }
}
