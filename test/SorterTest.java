import org.junit.Test;

import java.util.ArrayList;

import model.Merger;
import model.sorters.MergeSort;

import static org.junit.Assert.*;

public class SorterTest {

  @Test
  public void apply() {
    Merger merger = new Merger(10);
    merger.modify(new MergeSort());
    System.out.println(merger.getElements());
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    for (int i = 1; i <= 10; i ++) { sorted.add(i); }
    assertEquals(sorted, merger.getElements());
  }
}