// Singleton class
class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {}

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to the database...");
    }
}

// Main class
public class DatabaseConnectionDemo {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.connect();
        
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.connect();
        
        System.out.println(db1 == db2); // true
    }
}
