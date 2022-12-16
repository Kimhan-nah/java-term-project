package Controller;

import View.BankWriter;
import Model.BankAccount;
import View.MainFrame;


public class AccountController
{
  private BankReader reader; // input view
  private BankAccount primary_account, secondary_account, account;
  private BankWriter primary_writer, secondary_writer, writer;
  private MainFrame my_frame;

  public AccountController (BankReader r, BankAccount a1,BankWriter w1, BankAccount a2, BankWriter w2, MainFrame f)
  {
    reader = r;
    primary_account = a1;
    primary_writer = w1;
    secondary_account = a2;
    secondary_writer = w2;
    account = primary_account;
    writer = primary_writer;
    my_frame = f;
  }

  public void resetAccount (BankAccount new_account,BankWriter new_writer) {
    account = new_account;
    writer = new_writer;
  }

  public void processTransactions()
  {
    char command = reader.readCommand("Commands (P/S/D/W/T/I/Q): ");

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
        int amount = reader.readAmount();
        if (account.deposit(amount)) writer.setTransaction("deposit $", amount);
        else writer.setTransaction("deposit error ", amount);
        break;
      }
      case 'W':
      {
        int amount = reader.readAmount();
        if (account.withdraw(amount)) writer.setTransaction("withdraw $", amount);
        else writer.setTransaction("withdraw error ", amount);
        break;
      }
      case 'T':
        // 'T 금액', 활성 계좌에서 비활성 계좌로 금액만큼 이체
      {
        // 코드를 작성하세요.
        int amount = reader.readAmount();

        if (account.withdraw(amount)) {
          if (account == primary_account)
            secondary_account.deposit(amount);
          else
            primary_account.deposit(amount);
          writer.setTransaction("transfer $", amount);
        }
        else  {
          writer.setTransaction("transfer error ");
        }
        break;
      }
      case 'I':
        // 'I 이율', 활성 계좌의 금액을 이율만큼 증가
      {
        // 코드를 작성하세요.
        int amount = account.getBalance() * reader.readAmount() / 100;

        if (account.deposit(amount))
          writer.setTransaction("interest $", amount);
        else
          writer.setTransaction("interest error");

        break;
      }
      default:
        writer.setTransaction("invalid commpand: " + command);
    }
    // 모든 계좌의 정보를 출력합니다.
    System.out.println("=======================");
    System.out.println("== currently active : " + ((account == primary_account) ? "primary" : "secondary"));
    System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
    System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
    System.out.println("=======================");

    this.processTransactions();
  }
}

