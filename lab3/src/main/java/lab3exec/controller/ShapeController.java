package lab3.src.main.java.lab3exec.controller;

import java.util.Arrays;
import java.util.Comparator;

import lab3.src.main.java.lab3exec.model.Shape;

public class ShapeController {
  public void displayAll(Shape[] shapes) {
    System.out.println("\n========== ALL SHAPES ==========");
    for (int i = 0; i < shapes.length; i++) {
      System.out.println("[" + i + "] ");
      shapes[i].draw();
    }
  }

  public void calculateTotalArea(Shape[] shapes) {
    double totalArea = 0;
    for (Shape shape : shapes) {
      totalArea += shape.calcArea();
    }
    System.out.println("\n========== TOTAL AREA ==========");
    System.out.printf("Total Area: %.2f\n", totalArea);
  }

  public void calculateAreaByType(Shape[] shapes) {
    double rectangleArea = 0;
    double triangleArea = 0;
    double circleArea = 0;

    for (Shape shape : shapes) {
      String type = shape.getClass().getSimpleName();
      double area = shape.calcArea();

      if (type.equals("Rectangle")) {
        rectangleArea += area;
      } else if (type.equals("Triangle")) {
        triangleArea += area;
      } else if (type.equals("Circle")) {
        circleArea += area;
      }
    }

    System.out.println("\n========== AREA BY TYPE ==========");
    System.out.printf("Rectangles: %.2f\n", rectangleArea);
    System.out.printf("Triangles: %.2f\n", triangleArea);
    System.out.printf("Circles: %.2f\n", circleArea);
  }

  public void sortByArea(Shape[] shapes) {
    Shape[] sorted = shapes.clone();
    Comparator<Shape> areaComparator = (s1, s2) -> Double.compare(s1.calcArea(), s2.calcArea());
    Arrays.sort(sorted, areaComparator);

    System.out.println("\n========== SORTED BY AREA (ASCENDING) ==========");
    for (int i = 0; i < sorted.length; i++) {
      System.out.println("[" + i + "] ");
      sorted[i].draw();
    }
  }

  public void sortByColor(Shape[] shapes) {
    Shape[] sorted = shapes.clone();
    Comparator<Shape> colorComparator = (s1, s2) -> s1.getColor().compareTo(s2.getColor());
    Arrays.sort(sorted, colorComparator);

    System.out.println("\n========== SORTED BY COLOR ==========");
    for (int i = 0; i < sorted.length; i++) {
      System.out.println("[" + i + "] ");
      sorted[i].draw();
    }
  }

}
