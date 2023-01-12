package controller.commands;

import model.Merger;

public class Set extends ACommand {

  private int num;

  public Set(Merger model) {
    super(model);
  }

  @Override
  public void applyC() {
    this.model = new Merger(num);

  }
}
