package model.sorters;

import java.util.ArrayList;

import model.Merger;

public class InsertionSort implements ISorter {
  private Merger merger;
  @Override
  public void applySorter(Merger merger) {
    this.merger = merger;
    this.sort(this.merger.getElements());
  }

  private void sort(ArrayList<Integer> arr) {
    for (int i = 1; i < arr.size(); i++) {
      int key = arr.get(i);
      int j = i - 1;
      while (j >= 0 && arr.get(j) >= key) {
        arr.set(j + 1, arr.get(j));
        j -= 1;
      }
      arr.set(j + 1, key);
      this.merger.setArr(arr);
    }
  }

}
