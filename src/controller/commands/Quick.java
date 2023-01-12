package controller.commands;

import model.Merger;
import model.sorters.QuickSort;

public class Quick extends ACommand {

  public Quick(Merger model) {
    super(model);
  }

  @Override
  public void applyC() {
    this.model.modify(new QuickSort());
  }

}
