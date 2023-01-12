package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.swing.*;

import controller.commands.ICommand;
import controller.commands.Insertion;
import controller.commands.Merge;
import controller.commands.Quick;
import controller.commands.Randomize;
import controller.commands.Selection;
import controller.commands.Set;
import model.Merger;
import view.MergeGUI;

public class TextController implements ActionListener {
  private Merger model;

  private MergeGUI view;

  private Map<String, ICommand> allCommands;

  private Timer timer;

  private int count = 0;

  public TextController(Merger model, MergeGUI view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Null model or view.");
    }
    this.model = model;
    this.view = view;
    this.allCommands = new HashMap<String, ICommand>();
    this.allCommands.put("merge", new Merge(this.model));
    this.allCommands.put("randomize", new Randomize(this.model));
    this.allCommands.put("set", new Set(this.model));
    this.allCommands.put("selection", new Selection(this.model));
    this.allCommands.put("insertion", new Insertion(this.model));
    this.allCommands.put("quick", new Quick(this.model));
    this.view.updateModel(this.model);
    this.view.refresh();
  }

  public void accept(String cmd) {
    String[] cmds = cmd.split(" ");
    ICommand command = this.allCommands.get(cmds[0]);
    if (command == null) {
      throw new IllegalArgumentException("Invalid command.");
    }
    if (cmd.equals("randomize")) {
      command.applyC();
      count += 1;
      view.updateModel(new Merger(model.getVersions().get(model.getVersions().size() - 1)));
      view.refresh();
    }
    else if (cmds[0].equals("set")) {
      this.model.set(new Merger(Integer.parseInt(cmds[1])));
      count += 1;
      view.updateModel(new Merger(model.getVersions().get(model.getVersions().size() - 1)));
      view.refresh();
    }
    else {
      try {
        command.applyC();
        timer = new Timer(25, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            if (count == model.getVersions().size()) {
              timer.stop();
            } else {
              view.updateModel(new Merger(model.getVersions().get(count)));
              view.refresh();
              count++;
            }
          }
        });
        timer.start();
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid command.");
      }
    }
  }

  public void cModelUpdate(Merger model) {
    this.model = model;
    this.view.updateModel(this.model);
    this.view.refresh();
  }

  public void go() {
    this.view.addActionListener(this);
    this.view.display();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (Objects.equals(e.getActionCommand(), "submit")) {
      this.accept(MergeGUI.content.getText());
    }
  }
}
