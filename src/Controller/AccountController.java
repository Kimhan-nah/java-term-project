package Controller;

import View.BankWriter;
import Model.BankAccount;


public class AccountController
{
  private BankAccount primary_account, secondary_account, active_account;
  private BankWriter primary_writer, secondary_writer, active_writer;
  private BankReader reader; // input view

  public AccountController (BankReader r, BankAccount a1,BankWriter w1, BankAccount a2, BankWriter w2)
  {
    reader = r;
    primary_account = a1;
    primary_writer = w1;
    secondary_account = a2;
    secondary_writer = w2;
    active_account = primary_account;
    active_writer = primary_writer;
  }

  public void resetAccount (BankAccount new_account,BankWriter new_writer) {
    active_account = new_account;
    active_writer = new_writer;
  }

  public String processTransactions(char command, String amountData)
  {
    String data = null;

    try {
//      System.out.println("command : " + command);
      switch (command) {
        case 'P':
          resetAccount(primary_account, primary_writer);
          break;
        case 'S':
          resetAccount(secondary_account, secondary_writer);
          break;
        case 'Q':
          System.out.println("Quit");
          return null;
        case 'D':
        {
          int amount = Integer.parseInt(amountData);
          if (active_account.deposit(amount)) {
            active_writer.setTransaction("[예금] ", amount);
          }
          else {
            System.out.println("deposit error : " + amount);
            throw new RuntimeException();
          }
          break;
        }
        case 'W':
        {
          int amount = Integer.parseInt(amountData);
          if (active_account.withdraw(amount)) {
            active_writer.setTransaction("[출금] ", amount);
          }
          else {
//            active_writer.setTransaction("withdraw error ", amount);
            System.out.println("withdraw error : " + amount);
            throw new RuntimeException();
          }
          break;
        }
        case 'T':
        {
          int amount = Integer.parseInt(amountData);
          if (active_account.withdraw(amount)) {
            if (active_account == primary_account)
              secondary_account.deposit(amount);
            else
              primary_account.deposit(amount);
            active_writer.setTransaction("[이체] ", amount);
          }
          else  {
//            active_writer.setTransaction("transfer error ");
            System.out.println("transfer error : " + amount);
            throw new RuntimeException();
          }
          break;
        }
        case 'B':
        {
          active_writer.showBalance();
          data = Integer.toString(active_account.getBalance());
          break ;
        }
        case 'L':
        {
          active_writer.showLastTransaction();
          data = active_writer.getLastTransaction();
          if (data.isEmpty())
            data = "아직 거래 내역이 없습니다.";
          break ;
        }
//        default:
//          active_writer.setTransaction("Invalid Command: " + command);
      }
    }
    catch (RuntimeException e) {
      System.out.println("Invalid Command");
      throw e;
    }

    // 모든 계좌의 정보를 출력합니다.
    // DEBUG CODE
    System.out.println("=======================");
    System.out.println("== currently active : " + ((active_account == primary_account) ? "primary" : "secondary"));
    System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
    System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
    System.out.println("=======================");

//    this.processTransactions();
    return data;
  }
}

