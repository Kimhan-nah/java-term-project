package Controller;

import View.BankWriter;
import Model.BankAccount;
import View.MainFrame;


public class AccountController
{
  private BankReader reader; // input view
  private BankAccount primary_account, secondary_account, active_account;
  private BankWriter primary_writer, secondary_writer, active_writer;
  private MainFrame my_frame;

  public AccountController (BankReader r, BankAccount a1,BankWriter w1, BankAccount a2, BankWriter w2)
  {
    reader = r;
    primary_account = a1;
    primary_writer = w1;
    secondary_account = a2;
    secondary_writer = w2;
    active_account = primary_account;
    active_writer = primary_writer;
//    my_frame = f;
  }

  public void resetAccount (BankAccount new_account,BankWriter new_writer) {
    active_account = new_account;
    active_writer = new_writer;
  }

  public void processTransactions(char command, String amountData)
  {
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
          return;
        case 'D':
        {
          int amount = Integer.parseInt(amountData);
          if (active_account.deposit(amount)) active_writer.setTransaction("deposit $", amount);
          else active_writer.setTransaction("deposit error ", amount);
          break;
        }
        case 'W':
        {
          int amount = Integer.parseInt(amountData);
          if (active_account.withdraw(amount)) active_writer.setTransaction("withdraw $", amount);
          else active_writer.setTransaction("withdraw error ", amount);
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
            active_writer.setTransaction("transfer $", amount);
          }
          else  {
            active_writer.setTransaction("transfer error ");
          }
          break;
        }
        case 'I':
          // 'I 이율', 활성 계좌의 금액을 이율만큼 증가
        {
          int amount = Integer.parseInt(amountData);
          amount = active_account.getBalance() * reader.readAmount() / 100;

          if (active_account.deposit(amount))
            active_writer.setTransaction("interest $", amount);
          else
            active_writer.setTransaction("interest error");

          break;
        }
        case 'B':
        {
          active_writer.showBalance();
          break ;
        }
        case 'L':
        {
          active_writer.showLastTransaction();
          break ;
        }
        default:
          active_writer.setTransaction("Invalid Command: " + command);
      }
    }
    catch (RuntimeException e) {
      System.out.println("Invalid Command");
    }

    // 모든 계좌의 정보를 출력합니다.
    // TEST CODE
    System.out.println("=======================");
    System.out.println("== currently active : " + ((active_account == primary_account) ? "primary" : "secondary"));
    System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
    System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
    System.out.println("=======================");

//    this.processTransactions();
  }
}

