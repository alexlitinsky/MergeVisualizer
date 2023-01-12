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

  private ArrayList<ArrayList<Integer>> versions;


  public Merger(int num) {
    lst = new ArrayList<Integer>();
    versions = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < num; i++) { lst.add(i); }
    this.randomize();
  }
  public Merger(ArrayList<Integer> arr) {
    lst = arr;
    versions = new ArrayList<ArrayList<Integer>>();
    versions.add(lst);
  }


  public void randomize() {
    Random r = new Random();
    ArrayList<Integer> new_lst = new ArrayList<Integer>();
    int size = lst.size();
    for (int i = 0; i < size; i++) {
      int elem = lst.remove(r.nextInt(lst.size()));
      new_lst.add(elem);
    }
    this.lst = new_lst;
    versions.add(lst);
  }

  public void set(Merger model) {
    this.lst = model.getElements();
    this.versions.add(lst);
  }

  public ArrayList<Integer> getElements() {
    ArrayList<Integer> copy = new ArrayList<Integer>();
    copy.addAll(lst);
    return copy;
  }

  public void setArr(ArrayList<Integer> arr) {
    this.lst = arr;
    ArrayList<Integer> copy = new ArrayList<Integer>();
    copy.addAll(arr);
    this.versions.add(copy);
  }

  public void modify(ISorter sorter) {
    sorter.applySorter(this);
  }

  public java.awt.Image draw() {
    BarSet barset = new BarSet(this.getElements());
    BufferedImage image = new BufferedImage(barset.getPreferredSize().width,
            barset.getPreferredSize().height, BufferedImage.TYPE_INT_RGB);

    Graphics2D graphics = image.createGraphics();
    barset.paint(graphics);
    graphics.drawImage(image, image.getWidth(new JLabel()),
            image.getHeight(new JLabel()), new JLabel());
    graphics.dispose();
    return image;
  }

  public boolean isSorted() {
    for (int i = 0; i < lst.size() - 1; i++) {
      if (lst.get(i) > lst.get(i + 1)) { return false; }
    }
    return true;
  }

  public ArrayList<ArrayList<Integer>> getVersions() {
    return this.versions;
  }

  public void update(ArrayList<Integer> arr) {
    this.lst = arr;
  }


}
