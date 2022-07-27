package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MergeGUI extends JFrame  {

  public static JTextField content;
  private JButton submit;
  private ActionListener listener;

  private JPanel array;

  private JPanel submissions;

  public MergeGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    this.setSize(1200, 800);

    gbc.gridx = 0;
    gbc.gridy = 0;

    array = new JPanel();
    array.setPreferredSize(new Dimension(1200, 750));
    this.add(array, gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 1;

    submissions = new JPanel();
    submissions.setLayout(new FlowLayout());
    this.add(submissions, gbc);

    submit = new JButton("Submit");
    submit.setActionCommand("submit");
    submit.setPreferredSize(new Dimension(300, 50));
    submissions.add(submit);
    //this.add(submit);
    content = new JTextField();
    content.setPreferredSize(new Dimension(900, 50));
    //this.add(content);
    submissions.add(content);


    this.pack();
    this.setVisible(true);
  }

  public void addActionListener(ActionListener listener) {
    this.listener = listener;
    submit.addActionListener(this.listener);

  }
  public void display() { this.setVisible(true); }

  public void refresh() {

  }



  }

