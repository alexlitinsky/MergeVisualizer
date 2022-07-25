package model;

import java.util.ArrayList;
import java.util.Random;

public class Merger implements IMerger {

  private ArrayList<Integer> lst;


  public Merger() {
    lst = new ArrayList<Integer>();
    lst.add(1); lst.add(2); lst.add(3); lst.add(4); lst.add(5); lst.add(6); lst.add(7); lst.add(8);
    lst.add(9); lst.add(10);
  }


  public void randomize() {
    Random r = new Random();
    ArrayList<Integer> new_lst = new ArrayList<Integer>();
    int size = lst.size();
    for (int i = 0; i < size; i++) {
      int elem = lst.remove(r.nextInt(lst.size()));
      new_lst.add(elem);
    }
    lst = new_lst;

  }

  @Override
  public ArrayList<Integer> getElements() {
    ArrayList<Integer> copy = new ArrayList<Integer>();
    copy.addAll(lst);
    return copy;
  }


}
