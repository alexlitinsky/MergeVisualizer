package controller.commands;

import model.Merger;
import model.sorters.MergeSort;

public class Merge extends ACommand {

  public Merge(Merger model) {
    super(model);
  }

  @Override
  public void applyC() {
    this.model.modify(new MergeSort());
    // this.view.update(model);
  }
}
