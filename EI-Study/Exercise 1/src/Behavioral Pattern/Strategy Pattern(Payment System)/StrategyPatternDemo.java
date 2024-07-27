// Strategy interface
interface PaymentStrategy {
    void pay(int amount); // Method to pay a certain amount
}

// Concrete Strategy for Credit Card payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber); // Process credit card payment
    }
}

// Concrete Strategy for PayPal payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email); // Process PayPal payment
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy; // Set the payment strategy
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount); // Use the payment strategy to pay the amount
    }
}

// Main class
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(); // Create shopping cart

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432")); // Set credit card payment strategy
        cart.checkout(100); // Checkout with credit card

        cart.setPaymentStrategy(new PayPalPayment("user@example.com")); // Set PayPal payment strategy
        cart.checkout(200); // Checkout with PayPal
    }
}
