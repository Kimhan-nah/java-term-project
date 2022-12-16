package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
  MyFrame(String title) {
    super(title);
    int FRAME_WIDTH = 1200;
    int FRAME_HEIGHT = 700;
    int FRAME_X = 100;
    int FRAME_Y = 100;

    setLayout(new BorderLayout());
    setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setVisible(true);
  }
}
