import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

abstract class Animal {
    String name;
    int age;
    double weight;
    
    public Animal(String name, int age, double weight){
    this.name = name;
    this.age =  age;
    this.weight = weight;

    
}
    public abstract void makeSound();
    public abstract void eat();
    public abstract void sleep();

    @Override
    public String toString() {
      return "Name: " + name + ", Age: " + age + ", Weight: " + weight;
    }
}

// Define the Flyable interface
interface Flyable {
    void fly();
}

// Define the Flyable interface
interface Swimmable {
    void swim();
}

interface Climber{
    void climb();
}


class Mammal extends Animal {

    Mammal(String name, int age, double weight) {
         super(name, age, weight);
    }
    @Override
    public void eat() {
        System.out.println("The Mammal Eats Its Feed");
    }

    @Override
    public void sleep() {
        System.out.println("The Mammal Sleeps Soundly");
    }
    @Override
    public void makeSound() {
        System.out.println("The Mammal Groans");
    }
  
}

class Primate extends Mammal {
    
    public Primate(String name, int age, double weight) {
        super(name, age, weight);
    }
    
}

class Ape extends Primate implements Climber{

    public Ape(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public void climb() {
        
    }
}

class Monkey extends Primate implements Climber{

    public Monkey(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public void climb() {
        
    }
}

class Bird extends Animal implements Flyable {

    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }
    @Override
    public void fly() {
        System.out.println("The Bird Flies.");
    }

    @Override
    public void eat() {
        System.out.println("The Bird Eats Worms.");
    }

    @Override
    public void sleep() {
        System.out.println("The Bird Nests.");
    }
    @Override
    public void makeSound() {
        System.out.println("The Bird Tweets");
    }
}

class Reptile extends Animal {

    Reptile(String name, int age, double weight) {
         super(name, age, weight);
    }
    @Override
    public void eat() {
        System.out.println("The Reptile Eats");
    }

    @Override
    public void sleep() {
        System.out.println("The Reptile Burrows");
    }
    @Override
    public void makeSound() {
        System.out.println("The Reptiles Hiss");
    }
}

class Fish extends Animal implements Swimmable {

    Fish(String name, int age, double weight) {
         super(name, age, weight);
    }
    @Override
    public void swim() {
        System.out.println("The Fish Swim Around");
    }

    @Override
    public void eat() {
        System.out.println("The Fish Eats Small Shrimps");
    }

    @Override
    public void sleep() {
        System.out.println("The Fish Nests In The Corals");
    }
    @Override
    public void makeSound() {
        System.out.println("The Fishes Blow Bubbles");
    }
}

abstract class Habitat {
    List<Animal> inhabitants;

    public Habitat() {
        inhabitants = new ArrayList<>();
    }

    // Method to add an animal to the habitat
    public void addAnimal(Animal animal) {
        inhabitants.add(animal);
    }

    // Method to simulate interactions within the habitat
    public abstract void simulateInteractions();
}

// Aviary habitat for birds
class Aviary extends Habitat {
    @Override
    public void simulateInteractions() {
        for (Animal animal : inhabitants) {
            animal.makeSound();
            if (animal instanceof Flyable flyable) {
                flyable.fly();
            }
            animal.eat();
            animal.sleep();
        }
    }

    void feedAnimals() {
    }
}

// Aquarium habitat for fish
class Aquarium extends Habitat {
    @Override
    public void simulateInteractions() {
        for (Animal animal : inhabitants) {
            animal.makeSound();
            if (animal instanceof Swimmable swimmable) {
                swimmable.swim();
            }
            animal.eat();
            animal.sleep();
        }
    }

    void feedAnimals() {
    }
}

// Savannah habitat for mammals
class Savannah extends Habitat {
    @Override
    public void simulateInteractions() {
        for (Animal animal : inhabitants) {
            animal.makeSound();
            animal.eat();
            animal.sleep();
        }
    }

    void feedAnimals() {
    }
}

// Jungle habitat for primates
class Jungle extends Habitat {
    @Override
    public void simulateInteractions() {
        for (Animal animal : inhabitants) {
            animal.makeSound();
            if (animal instanceof Climber climber) {
                climber.climb();
            }
            animal.eat();
            animal.sleep();
        }
    }

    void feedAnimals() {
        
    }
}


public class main {
    public static void main(String[] args) {
        ZooManager zooManager = new ZooManager();
        zooManager.run();
    }
}

class ZooManager {
    private ArrayList<Animal> animals;
    private Aviary aviary;
    private Aquarium aquarium;
    private Savannah savannah;
    private Jungle jungle;
    private Scanner scanner;

    public ZooManager() {
        aviary = new Aviary();
        aquarium = new Aquarium();
        savannah = new Savannah();
        jungle = new Jungle();
        animals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            
            System.out.println("Please Select A Number:\n");
            System.out.println("1. Add An Animal To Our Zoo");
            System.out.println("2. View All Animals");
            System.out.println("3. View All The Animals In Their Own Habitat");
            System.out.println("4. Feed All The Animals");
            System.out.println("5. Simulate The Animals Behaviors");
            System.out.println("6. Exit");
            

            int scan = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (scan) {
                case 1 -> addAnimal();
                case 2 -> viewAllAnimals();
                case 3 -> viewAnimalsInHabitat();
                case 4 -> feedAnimals();
                case 5 -> simulateBehavior();
                case 6 -> {
                    System.out.println("Thank You");
                    return;
                }
                default -> System.out.println("Please try again.");
            }
        }
    }

    private void addAnimal() {
        System.out.println("Enter Which Type Of Animal You Would Like To Add");
        System.out.println("Mammal, Fish, Bird, Reptile");
        String type = scanner.nextLine();

        System.out.println("Enter It's Name:");
        String name = scanner.nextLine();

        System.out.println("Enter It's Age:");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter It's Weight");
        double weight = scanner.nextDouble();
        scanner.nextLine(); 

        Animal animal = null;

        if (type.equalsIgnoreCase("Mammal")) {
            animal = new Mammal(name, age, weight);
            savannah.addAnimal(animal); // Add ape to savannah
        } else if (type.equalsIgnoreCase("Fish")) {
            animal = new Fish(name, age, weight);
            aquarium.addAnimal(animal); // Add fish to aquarium
        } else if (type.equalsIgnoreCase("Bird")) {
            animal = new Bird(name, age, weight);
            aviary.addAnimal(animal); // Add bird to aviary
        } else if (type.equalsIgnoreCase("Reptile")) {
            animal = new Reptile(name, age, weight);
            jungle.addAnimal(animal); // Add reptile to jungle
        } else {
            System.out.println("Please Try Again.");
            return;
        }

        animals.add(animal);
        System.out.println("Animal Added Into The Zoo.");
    }

    private void viewAllAnimals() {
        System.out.println("\nAll Animals in the Zoo");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    private void viewAnimalsInHabitat() {
        
        
        System.out.println("Aviary:");
        aviary.simulateInteractions();
        System.out.println("\nAquarium:");
        aquarium.simulateInteractions();
        System.out.println("\nSavannah:");
        savannah.simulateInteractions();
        System.out.println("\nJungle:");
        jungle.simulateInteractions();
    }

    private void feedAnimals() {

        
        System.out.println("Feeding All The Birds");
        aviary.feedAnimals();
        System.out.println("Feeding All The Fish");
        aquarium.feedAnimals();
        System.out.println("Feeding All The Mammals");
        savannah.feedAnimals();
        System.out.println("Feeding All The Primates");
        jungle.feedAnimals();
        System.out.println("All The Animals Are Full.");
    }

    private void simulateBehavior() {
        
        
        System.out.println("Flys");
        aviary.simulateInteractions();
        System.out.println("Swims");
        aquarium.simulateInteractions();
        System.out.println("Walks");
        savannah.simulateInteractions();
        System.out.println("Crawls On Trees");
        jungle.simulateInteractions();
    }
}