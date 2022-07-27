import org.junit.Test;

import java.util.ArrayList;

import controller.TextController;
import model.Merger;

import static org.junit.Assert.*;

public class TextControllerTest {

  @Test
  public void accept() {
    Merger model = new Merger();
    System.out.println(model.getElements());
    TextController controller = new TextController(model);
    controller.accept("merge");
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    for (int i = 1; i <= 10; i ++) { sorted.add(i); }
    System.out.println(model.getElements());
    assertEquals(sorted, model.getElements());
  }

  @Test(expected = IllegalArgumentException.class)
  public void badAccept1() {
    Merger model = new Merger();
    TextController controller = new TextController(model);
    controller.accept("hello");
  }

  @Test(expected = IllegalArgumentException.class)
  public void badAccept2() {
    Merger model = new Merger();
    TextController controller = new TextController(model);
    controller.accept(null);
  }


}