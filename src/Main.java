import View.MainFrame;
import Model.BankAccount;
import View.BankWriter;
import Controller.AccountController;
import Controller.BankReader;


public class Main {
  public static void main(String[] args) {
    // runs in AWT thread
//    SwingUtilities.invokeLater(MainFrame::new);
    MainFrame my_frame = new MainFrame("HANNAH BANK");


    BankReader reader = new BankReader();

    BankAccount primary_account = new BankAccount(0);
    BankWriter primary_writer = new BankWriter(primary_account);

    BankAccount secondary_account = new BankAccount(0);
    BankWriter secondary_writer = new BankWriter(secondary_account);

    AccountController controller = new AccountController(reader,
        primary_account, primary_writer, secondary_account,
        secondary_writer, my_frame);
    controller.processTransactions();
  }
}