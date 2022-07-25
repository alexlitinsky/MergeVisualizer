import org.junit.Test;

import model.IMerger;
import model.Merger;


public class MergerTest {

  @Test
  public void randomize() {
    IMerger merger = new Merger();
    System.out.println(merger.getElements());
    merger.randomize();
    System.out.println(merger.getElements());


  }
}