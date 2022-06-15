package de.hda.fbi.db2;

import de.hda.fbi.db2.controller.Controller;
import de.hda.fbi.db2.stud.entity.Question;
import de.hda.fbi.db2.stud.impl.Lab01Impl;
import java.util.List;


/**
 * Main Class.
 *
 * @author L. Koehler
 */
public class Main {

  /**
   * Main Method and Entry-Point.
   *
   * @param args Command-Line Arguments.
   */

  public static void main(String[] args) throws Exception {
    Controller controller = Controller.getInstance();
    controller.readCsv();
    //Lab01Impl l1 = new Lab01Impl();
    //l1.getQuestions();
    //l1.getCategories();
    //TODO(stud): uncomment for lab02
    controller.persistData();

    //TODO(stud): uncomment for lab03, lab04 and lab05
    //controller.startMenu();
  }
}
