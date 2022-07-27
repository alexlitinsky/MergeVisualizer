package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MergeGUI extends JFrame implements ActionListener {


  public MergeGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.pack();
    this.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
