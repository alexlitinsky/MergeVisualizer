package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import model.sorters.ISorter;
import view.BarSet;

public class Merger {

  private ArrayList<Integer> lst;


  public Merger(int num) {
    lst = new ArrayList<Integer>();
    for (int i = 0; i < num; i++) { lst.add(i); }
    this.randomize();
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

  public ArrayList<Integer> getElements() {
    ArrayList<Integer> copy = new ArrayList<Integer>();
    copy.addAll(lst);
    return copy;
  }

  public void setArr(ArrayList<Integer> arr) {
    this.lst = arr;
  }

  public void modify(ISorter sorter) {
    sorter.applySorter(this);
  }

  public java.awt.Image draw() {
    BarSet barset = new BarSet(this.getElements());
    BufferedImage image = new BufferedImage(barset.getPreferredSize().width,
            barset.getPreferredSize().height, BufferedImage.TYPE_INT_RGB);

    Graphics2D graphics = image.createGraphics();
//    graphics.setPaint(Color.green);
//    graphics.fillRect(0, 0, 100, 100);
//    graphics.setBackground(Color.white);
    barset.paint(graphics);
    graphics.drawImage(image, image.getWidth(new JLabel()),
            image.getHeight(new JLabel()), new JLabel());
    graphics.dispose();
    return image;
  }


}
