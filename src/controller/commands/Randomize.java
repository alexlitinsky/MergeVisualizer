package controller.commands;

import model.Merger;

public class Randomize extends ACommand {

  public Randomize(Merger model) {
    super(model);
  }
  @Override
  public void applyC() {
    this.model.randomize();
  }

}
