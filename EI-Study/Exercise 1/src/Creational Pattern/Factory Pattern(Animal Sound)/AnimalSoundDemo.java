// Product interface
interface Animal {
    void speak();
}

// Concrete Product for Dog
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Concrete Product for Cat
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Factory class
class AnimalFactory {
    public Animal getAnimal(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Cat".equalsIgnoreCase(animalType)) {
            return new Cat();
        }
        return null;
    }
}

// Main class
public class AnimalSoundDemo {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        
        Animal animal1 = factory.getAnimal("Dog");
        animal1.speak(); // Woof!
        
        Animal animal2 = factory.getAnimal("Cat");
        animal2.speak(); // Meow!
    }
}
