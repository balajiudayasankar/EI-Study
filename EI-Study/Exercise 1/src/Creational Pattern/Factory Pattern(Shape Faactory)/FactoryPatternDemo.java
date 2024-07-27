// Product interface
interface Shape {
    void draw(); // Method to draw the shape
}

// Concrete Product for Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle"); // Implementation for drawing a circle
    }
}

// Concrete Product for Rectangle
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle"); // Implementation for drawing a rectangle
    }
}

// Factory class
class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(); // Return a new Circle object
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(); // Return a new Rectangle object
        }
        return null; // Return null if no matching shape type
    }
}

// Main class
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory(); // Create shape factory

        Shape shape1 = shapeFactory.getShape("CIRCLE"); // Get a Circle object
        shape1.draw(); // Draw the Circle

        Shape shape2 = shapeFactory.getShape("RECTANGLE"); // Get a Rectangle object
        shape2.draw(); // Draw the Rectangle
    }
}
