import java.util.Properties;

class ConfigurationManager {
    private static ConfigurationManager instance;
    private Properties properties;

    // Private constructor to prevent instantiation
    private ConfigurationManager() {
        properties = new Properties();
        // Load properties from a file or other source (not implemented here)
    }

    // Public method to provide access to the single instance
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key); // Get property value by key
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value); // Set property value by key
    }
}

// Main class
public class SingletonPatternDemo {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance(); // Get the singleton instance
        config.setProperty("url", "http://example.com"); // Set a property

        ConfigurationManager config2 = ConfigurationManager.getInstance(); // Get the singleton instance again
        System.out.println(config2.getProperty("url")); // Outputs: http://example.com
    }
}
