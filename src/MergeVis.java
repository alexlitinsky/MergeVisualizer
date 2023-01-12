import javax.swing.*;

import controller.TextController;
import model.Merger;
import view.MergeGUI;

public class MergeVis {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException |
             InstantiationException e) {
      throw new RuntimeException(e);
    }
    Merger main = new Merger(100);
    MergeGUI mergegui = new MergeGUI(main);
      TextController c = new TextController(main, mergegui);
      c.go();
  }
}
