package view;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.*;

public class BarSet extends JPanel {

  private ArrayList<Integer> elems;

  public BarSet(ArrayList<Integer> elems) {
    this.elems = elems;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    int widthCons = this.getPreferredSize().width / elems.size();
    int heightCons = this.getPreferredSize().height / elems.size();
    int wInc = 0;
    AffineTransform reset = g2d.getTransform();
    for (int i : elems) {
      g2d.setPaint(Color.white);
      Rectangle rect = new Rectangle(wInc, this.getPreferredSize().height, widthCons, i * heightCons);
//      g2d.fillRect(wInc, this.getPreferredSize().height, widthCons, i * heightCons);
      g2d.rotate(Math.toRadians(180), wInc + (widthCons / 2), this.getPreferredSize().height);
//      g2d.translate(rect.x - (rect.x / 2), rect.y - (rect.y / 2));
//      AffineTransform tx = new AffineTransform();
//      tx.rotate(Math.toRadians(180));
//      //g2d.rotate(Math.toRadians(180));
      g2d.fill(rect);
      g2d.setPaint(Color.black);
      g2d.draw(rect);
      g2d.setTransform(reset);
      wInc += widthCons;
    }
//    g2d.setPaint(Color.white);
//    Rectangle rect = new Rectangle(1000, 100, 50, 150);
//    g2d.draw(rect);
//    g2d.rotate(Math.toRadians(180), 1000 + 25, 100);
//    g2d.draw(rect);
//    //g2d.draw(rect);

  }

  @Override
  public Dimension getPreferredSize() { return new Dimension(1200, 750); }
}
