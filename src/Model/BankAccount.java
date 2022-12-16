package Model;

public class BankAccount
{
  private int balance;

  public BankAccount(int initial_amount) {
    if (initial_amount >= 0)
      balance = initial_amount;
    else
      balance = 0;
  }

  public int getBalance() {
    return balance;
  }

  public boolean deposit(int amount) {
    boolean result = false;
    if (amount < 0)
      System.out.println("invalid deposit amount");
    else {
      balance = balance + amount;
      result = true;
    }
    return result;
  }

  public boolean withdraw(int amount) {
    boolean result = false;
    if (amount < 0)
      System.out.println("invalid withdraw amount");
    else if (amount > balance)
      System.out.println("not enough balance");
    else {
      balance = balance - amount;
      result = true;
    }
    return result;
  }
}

