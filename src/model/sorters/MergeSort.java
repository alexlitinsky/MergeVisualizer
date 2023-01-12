package model.sorters;

import java.util.ArrayList;


import model.Merger;

public class MergeSort implements ISorter{

  private Merger merger;




  @Override
  public void applySorter(Merger merger) {
    this.merger = merger;
    this.sort(merger.getElements(), 0, merger.getElements().size() - 1);
  }

  private void sort(ArrayList<Integer> arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;
      sort(arr, l , m);
      sort(arr, m + 1, r);
      merge(arr, l, m , r);
    }
  }

  private void merge(ArrayList<Integer> arr, int l, int m, int r) {
    ArrayList<Integer> tempL = new ArrayList<Integer>(m - l + 1);
    ArrayList<Integer> tempR = new ArrayList<Integer>(r - m);
    for (int i = 0; i < m - l + 1; i++) { tempL.add(i, arr.get(l + i)); }
    for (int i = 0; i < r - m; i++) { tempR.add(i, arr.get(m + 1  + i)); }
    int i = 0, j = 0, k = l;
    while(i < m - l + 1 && j < r - m) {
      if (tempL.get(i) <= tempR.get(j)) {
        arr.set(k, tempL.get(i));
        merger.setArr(arr);
        i++;
      } else {
        arr.set(k, tempR.get(j));
        merger.setArr(arr);
        j++;
      }
      k++;
    }
    while (i < m - l + 1) {
      arr.set(k, tempL.get(i));
      merger.setArr(arr);
      i++;
      k++;
    }
    while (j < r - m) {
      arr.set(k, tempR.get(j));
      merger.setArr(arr);
      j++;
      k++;
    }

  }

}
