import controller.TextController;
import model.Merger;
import view.MergeGUI;

public class MergeVis {

  public static void main(String[] args) {
    MergeGUI mergegui = new MergeGUI();
    TextController c = new TextController(new Merger(), mergegui);
  }
}
