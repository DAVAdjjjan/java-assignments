package lab3exec.model;

public class Circle extends Shape {
  private double radius;

  public Circle(String shapeColor, double radius) {
    super(shapeColor);
    if (radius <= 0) {
      throw new IllegalArgumentException("Radius must be positive");
    }
    this.radius = radius;
  }

  @Override
  public double calcArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return String.format("Circle | Color: %s | Radius: %.2f | Area: %.2f",
        shapeColor, radius, calcArea());
  }
}
