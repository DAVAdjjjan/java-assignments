package lab3.src.main.java.lab3exec.model;

public class Triangle extends Shape {
  private double a;
  private double b;
  private double c;

  public Triangle(String shapeColor, double a, double b, double c) {
    super(shapeColor);
    if (!isValid(a, b, c)) {
      throw new IllegalArgumentException("Triangle is not valid");
    }
    this.a = a;
    this.b = b;
    this.c = c;

  }

  public boolean isValid(double a, double b, double c) {
    return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
  }

  @Override
  public double calcArea() {
    double p = (a + b + c) / 2.0;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }

  @Override
  public String toString() {
    return String.format("Triangle | Color: %s | Sides: %.2f, %.2f, %.2f | Area: %.2f",
        shapeColor, a, b, c, calcArea());
  }
}
