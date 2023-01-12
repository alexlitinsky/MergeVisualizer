package model.sorters;

import java.util.ArrayList;

import model.Merger;

public class QuickSort implements ISorter {

  private Merger merger;

  @Override
  public void applySorter(Merger merger) {
    this.merger = merger;
    this.sort(0, merger.getElements().size(), merger.getElements());
  }

  private void sort(int l, int h, ArrayList<Integer> arr) {
    if (l < h) {
      int j = Partition(l, h, arr);
      this.sort(l, j, arr);
      this.sort(j + 1, h, arr);
    }
  }

  private int Partition(int l, int h, ArrayList<Integer> arr) {
    int pivot = arr.get(l); int i = l; int j = h;
    while (i < j) {
      do {
        i++;
      } while (i < arr.size() && arr.get(i) <= pivot);
      do {
        j--;
      } while (arr.get(j) > pivot);
      if (i < j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
        merger.setArr(arr);
      }
    }
    int tempL = arr.get(l);
    arr.set(l, arr.get(j));
    arr.set(j, tempL);
    merger.setArr(arr);
    return j;
  }
}
