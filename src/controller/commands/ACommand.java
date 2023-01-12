package controller.commands;

import model.Merger;

abstract public class ACommand implements ICommand {

  protected Merger model;

  public ACommand(Merger model) {
    if (model == null) { throw new IllegalArgumentException("Invalid model/view."); }
    this.model = model;
  }
  public abstract void applyC();
}
