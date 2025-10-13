package lab3.src.main.java.lab3exec.model;

public class Rectangle extends Shape {
  private double width;
  private double height;

  public Rectangle(String shapeColor, double width, double height) {
    super(shapeColor);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public double calcArea() {
    return width * height;
  }

  @Override
  public String toString() {
    return String.format("Rectangle | Color: %s | Width: %.2f | Height: %.2f | Area: %.2f",
        shapeColor, width, height, calcArea());
  }

}
