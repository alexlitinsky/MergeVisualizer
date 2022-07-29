package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Merger;

public class MergeGUI extends JFrame  {

  public static JTextField content;
  private JButton submit;
  private ActionListener listener;

  private JPanel array;

  private JPanel submissions;

  private Merger model;

  public MergeGUI() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    this.setSize(1200, 800);

    gbc.gridx = 0;
    gbc.gridy = 0;


    model = new Merger(100);
    JLabel modelImage = new JLabel(new ImageIcon(model.draw()));
    array = new JPanel();
    array.setPreferredSize(new Dimension(1200, 750));
    this.array.add(modelImage);
    this.array.updateUI();
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
    content = new JTextField();
    content.setPreferredSize(new Dimension(900, 50));
    submissions.add(content);


    this.pack();
    this.setVisible(true);
  }

  public void addActionListener(ActionListener listener) {
    this.listener = listener;
    submit.addActionListener(this.listener);

  }
  public void display() { this.setVisible(true); }

  public void updateModel(Merger model) {
    this.model = model;
  }

  public void refresh() {
    JLabel newModel = new JLabel(new ImageIcon(this.model.draw()));
    this.array.add(newModel);
    this.array.updateUI();
    if (this.array.getComponentCount() >= 2) {
      this.array.remove(0);
    }
  }



  }

