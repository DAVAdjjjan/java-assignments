package lab3exec;

import lab3exec.controller.ShapeController;
import lab3exec.model.Circle;
import lab3exec.model.Rectangle;
import lab3exec.model.Shape;
import lab3exec.model.Triangle;
import lab3exec.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[12];

        // Rectangles
        shapes[0] = new Rectangle("Red", 5, 10);
        shapes[1] = new Rectangle("Blue", 8, 6);
        shapes[2] = new Rectangle("Green", 4, 12);

        // Triangles
        shapes[3] = new Triangle("Yellow", 3, 4, 5);
        shapes[4] = new Triangle("Black", 5, 5, 6);
        shapes[5] = new Triangle("Purple", 7, 8, 9);

        // Circles
        shapes[6] = new Circle("Red", 5);
        shapes[7] = new Circle("Blue", 7);
        shapes[8] = new Circle("Green", 3);

        // Mixed
        shapes[9] = new Rectangle("Orange", 6, 4);
        shapes[10] = new Triangle("White", 6, 8, 10);
        shapes[11] = new Circle("Yellow", 4);

        ShapeController controller = new ShapeController();
        ConsoleView view = new ConsoleView(controller);

        view.displayAll(shapes);

        view.displayTotalArea(shapes);

        view.displayAreaByType(shapes);

        view.sortByArea(shapes);

        view.sortByColor(shapes);
    }
}
