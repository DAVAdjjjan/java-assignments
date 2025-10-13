package lab3.src.main.java.lab3exec.model;

public abstract class Shape implements Drawable {
  protected String shapeColor;

  public Shape(String shapeColor) {
    this.shapeColor = shapeColor;
  }

  public abstract double calcArea();

  public String getColor() {
    return shapeColor;
  }

  @Override
  public String toString() {
    return String.format("%s | Color: %s | Area: %.2f",
        this.getClass().getSimpleName(), shapeColor, calcArea());
  }

  @Override
  public void draw() {
    System.out.println(this.toString());
  }
}
