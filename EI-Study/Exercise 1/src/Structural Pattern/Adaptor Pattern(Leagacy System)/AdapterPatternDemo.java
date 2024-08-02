// Target interface
interface NewSystem {
    void performTask();
}

// Adaptee class (legacy system)
class LegacySystem {
    public void oldMethod() {
        System.out.println("Performing old task");
    }
}

// Adapter class
class LegacyAdapter implements NewSystem {
    private LegacySystem legacySystem;

    public LegacyAdapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void performTask() {
        legacySystem.oldMethod();
    }
}

// Main class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        LegacySystem legacy = new LegacySystem();
        NewSystem adapter = new LegacyAdapter(legacy);
        adapter.performTask(); // Performing old task
    }
}
