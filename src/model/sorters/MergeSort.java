package model.sorters;

import java.util.ArrayList;

import model.Merger;

public class MergeSort implements ISorter{

  private Merger merger;

  @Override
  public void apply(Merger merger) {
    this.merger = merger;
    this.sort(merger.getElements(), 0, merger.getElements().size() - 1);
  }

  private void sort(ArrayList<Integer> arr, int l, int r) {
    if (l < r) {
      int m = l + (r - 1) / 2;
      sort(arr, l , m);
      sort(arr, m + 1, r);
      merge(arr, l, m , r);
    }
  }

  private void merge(ArrayList<Integer> arr, int l, int m, int r) {
    ArrayList<Integer> tempL = new ArrayList<Integer>(m - l + 1);
    ArrayList<Integer> tempR = new ArrayList<Integer>(r - m);
    for (int i = 0; i < m - l + 1; i++) { tempL.set(i, arr.get(l + i)); }
    for (int i = 0; i < r - m; i++) { tempR.set(i, arr.get(m + 1  + i)); }
    int i = 0, j = 0, k = l;
    while (i < m - l + 1) {
      arr.set(k, tempL.get(i));
      i++;
      k++;
    }
    while (j < r - m) {
      arr.set(k, tempR.get(j));
      j++;
      k++;
    }
  }

}
