import java.util.ArrayList;
import java.util.Scanner;

public class FamilyTree {

    static class Person {
        String name;
        ArrayList<Person> children;

        Person(String name) {
            this.name = name;
            this.children = new ArrayList<>();
        }
    }

    static Person root = new Person("Grandfather");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add child");
            System.out.println("2. Print family tree");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the child: ");
                    String childName = scanner.nextLine();
                    addChild(childName);
                    break;
                case 2:
                    printTree(root, 0);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addChild(String childName) {
        Person child = new Person(childName);
        root.children.add(child);
        System.out.println("Child added successfully!");
    }

    static void printTree(Person person, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(person.name);
        for (Person child : person.children) {
            printTree(child, level + 1);
        }
    }
}