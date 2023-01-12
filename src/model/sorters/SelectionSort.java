package model.sorters;

import java.util.ArrayList;

import model.Merger;

public class SelectionSort implements ISorter {

  private Merger merger;

  @Override
  public void applySorter(Merger merger) {
    this.merger = merger;
    this.sort(this.merger.getElements());
  }

  private void sort(ArrayList<Integer> arr) {
    for (int i = 0; i < arr.size() - 1; i++) {
      int min = i;
      for (int j = i + 1; j < arr.size(); j++) {
        if (arr.get(j) < arr.get(min)) {
          min = j;
        }
      }
      int temp = arr.get(min);
      arr.set(min, arr.get(i));
      arr.set(i, temp);
      this.merger.setArr(arr);
    }
  }
}
