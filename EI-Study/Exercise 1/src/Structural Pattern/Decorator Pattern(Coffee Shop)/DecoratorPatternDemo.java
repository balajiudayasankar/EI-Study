// Component interface
interface Coffee {
    String getDescription(); // Method to get description of the coffee
    double getCost(); // Method to get cost of the coffee
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee"; // Description of simple coffee
    }

    @Override
    public double getCost() {
        return 2.0; // Cost of simple coffee
    }
}

// Base Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee; // Wrap the coffee object
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription(); // Forward the call to wrapped object
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost(); // Forward the call to wrapped object
    }
}

// Concrete Decorator for adding milk
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk"; // Add milk to description
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5; // Add cost of milk
    }
}

// Another Concrete Decorator for adding sugar
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar"; // Add sugar to description
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2; // Add cost of sugar
    }
}

// Main class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(); // Create simple coffee
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); // Print description and cost

        coffee = new MilkDecorator(coffee); // Decorate with milk
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); // Print description and cost

        coffee = new SugarDecorator(coffee); // Decorate with sugar
        System.out.println(coffee.getDescription() + " $" + coffee.getCost()); // Print description and cost
    }
}
