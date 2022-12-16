package View;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MyPanel extends JPanel {
  private JButton backButton;

  MyPanel() {
    JToolBar toolBar = new JToolBar();
    backButton = new JButton("Go Back");
    add(toolBar);
    toolBar.add(backButton);
    toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
  }
  public void backButton(ActionListener actionListener) {
    backButton.addActionListener(actionListener);
  }
}
