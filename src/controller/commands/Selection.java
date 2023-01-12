package controller.commands;

import model.Merger;
import model.sorters.SelectionSort;

public class Selection extends ACommand {

  public Selection(Merger model) {
    super(model);
  }

  @Override
  public void applyC() {
    this.model.modify(new SelectionSort());
  }
}
