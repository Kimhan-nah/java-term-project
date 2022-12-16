package View.utils;

import java.awt.Font;
import javax.swing.JButton;

public class MyButton extends JButton {
  private Font font;
  public MyButton(String text) {
    super(text);
    font = new Font("Impact Roman", Font.BOLD, 30);
    setFont(font);
  }
}
