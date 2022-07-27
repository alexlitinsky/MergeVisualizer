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
    MergeGUI mergegui = new MergeGUI();
      TextController c = new TextController(new Merger(), mergegui);
      c.go();
  }
}
