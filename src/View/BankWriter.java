package View;

import java.text.DecimalFormat;
import Model.BankAccount;

public class BankWriter
{
//  private MainFrame
  private BankAccount bank;
  private String last_transaction = "";

  public BankWriter(BankAccount b) {
    bank = b;
  }

  // TEST CODE
  public String unconvert(int i) {
    return new DecimalFormat("0.00").format(i/100.0);
  }

  public void setTransaction(String message, int amount)
  {
    last_transaction = message + " " + amount + " won";
    System.out.println("transaction: " + last_transaction);
  }

  public void setTransaction(String message)
  {
    last_transaction = message;
    System.out.println("transaction: " + last_transaction);
  }

  public void showBalance() {
    System.out.println("Balance : " + bank.getBalance());
  }

  public void showLastTransaction() {
    if (last_transaction.equals(""))
      System.out.println("No Transaction");
    else
      System.out.println("last transaction : " + last_transaction);
  }


}
