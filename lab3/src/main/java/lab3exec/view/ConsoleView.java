package lab3.src.main.java.lab3exec.view;

import lab3.src.main.java.lab3exec.controller.ShapeController;
import lab3.src.main.java.lab3exec.model.Shape;

public class ConsoleView {
  private ShapeController controller;

  public ConsoleView(ShapeController controller) {
    this.controller = controller;
  }

  public void displayAll(Shape[] shapes) {
    controller.displayAll(shapes);
  }

  public void displayAreaByType(Shape[] shapes) {
    controller.calculateAreaByType(shapes);
  }

  public void sortByArea(Shape[] shapes) {
    controller.sortByArea(shapes);
  }

  public void sortByColor(Shape[] shapes) {
    controller.sortByColor(shapes);
  }

  public void displayTotalArea(Shape[] shapes) {
    controller.calculateTotalArea(shapes);
  }
}
