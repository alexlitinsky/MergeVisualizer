package controller.commands;

import model.Merger;
import model.sorters.InsertionSort;

public class Insertion extends ACommand {

  public Insertion(Merger model) {
    super(model);
  }

  @Override
  public void applyC() {
    this.model.modify(new InsertionSort());
  }
}
