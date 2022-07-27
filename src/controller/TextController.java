package controller;

import java.util.HashMap;
import java.util.Map;

import controller.commands.ICommand;
import controller.commands.Merge;
import model.Merger;
import view.MergeGUI;

public class TextController {
  private Merger model;

  private MergeGUI view;

  private Map<String, ICommand> allCommands;

  public TextController(Merger model, MergeGUI view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Null model or view.");
    }
    this.model = model;
    this.view = view;
    this.allCommands = new HashMap<String, ICommand>();
    this.allCommands.put("merge", new Merge(this.model));
  }

  public void accept(String cmd) {
    ICommand command = this.allCommands.get(cmd);
    if (command == null) {
      throw new IllegalArgumentException("Invalid command.");
    }
      try {
        command.applyC();
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid command.");
      }

    }
  }
