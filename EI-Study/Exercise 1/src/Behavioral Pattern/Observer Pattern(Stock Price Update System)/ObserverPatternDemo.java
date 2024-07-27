import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float price); // Method to update the observer with new price
}

// Subject interface
interface Subject {
    void registerObserver(Observer o); // Method to register an observer
    void removeObserver(Observer o); // Method to remove an observer
    void notifyObservers(); // Method to notify all registered observers
}

// Concrete Subject
class Stock implements Subject {
    private List<Observer> observers; // List to store observers
    private float price; // Current price of the stock

    public Stock() {
        observers = new ArrayList<>();
    }

    // Method to set new price and notify observers
    public void setPrice(float price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o); // Add observer to the list
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o); // Remove observer from the list
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price); // Notify each observer with the new price
        }
    }
}

// Concrete Observer
class StockDisplay implements Observer {
    private String name;

    public StockDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(float price) {
        System.out.println(name + " - New Stock Price: " + price); // Display the updated price
    }
}

// Main class
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock(); // Create stock

        StockDisplay display1 = new StockDisplay("Display1"); // Create display1
        StockDisplay display2 = new StockDisplay("Display2"); // Create display2

        stock.registerObserver(display1); // Register display1
        stock.registerObserver(display2); // Register display2

        stock.setPrice(100.5f); // Set new price and notify observers
        stock.setPrice(102.3f); // Set another new price and notify observers
    }
}
