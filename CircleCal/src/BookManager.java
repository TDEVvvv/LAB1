import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String name;
    private float price;
    private int quantity;
    private String barcode;

    public Book(String name, float price, int quantity, String barcode) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barcode = barcode;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return name + "," + price + "," + quantity + "," + barcode;
    }
}

public class BookManager {
    private List<Book> books;
    private Scanner scanner;

    public BookManager() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addBookFromInput() {
        System.out.println("Enter book details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); // Consume newline character
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Barcode: ");
        String barcode = scanner.nextLine();

        Book book = new Book(name, price, quantity, barcode);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        System.out.println("Name\tPrice\tQuantity\tBarcode");
        for (Book book : books) {
            System.out.println(book.getName() + "\t" + book.getPrice() + "\t" + book.getQuantity() + "\t\t" + book.getBarcode());
        }
    }

    public void editBook(String barcode) {
        for (Book book : books) {
            if (book.getBarcode().equals(barcode)) {
                System.out.println("Editing book: " + book.getName());
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                book.setName(newName);
                System.out.print("New price: ");
                float newPrice = scanner.nextFloat();
                scanner.nextLine(); // Consume newline character
                book.setPrice(newPrice);
                System.out.print("New quantity: ");
                int newQuantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                book.setQuantity(newQuantity);
                System.out.println("Book details updated successfully!");
                return;
            }
        }
        System.out.println("Book not found with barcode: " + barcode);
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Book book : books) {
                writer.println(book.toString());
            }
            System.out.println("Data saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found, creating new file: " + fileName);
                file.createNewFile();
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    float price = Float.parseFloat(parts[1]);
                    int quantity = Integer.parseInt(parts[2]);
                    String barcode = parts[3];
                    Book book = new Book(name, price, quantity, barcode);
                    books.add(book);
                } else {
                    System.out.println("Invalid data in file: " + line);
                }
            }
            reader.close();
            System.out.println("Data loaded from file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }
    
    public float calculatePriceSum() {
        float sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }

    public int calculateQuantitySum() {
        int sum = 0;
        for (Book book : books) {
            sum += book.getQuantity();
        }
        return sum;
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                System.out.println("Book found:");
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book with name '" + name + "' not found.");
        }
    }

    public void searchByBarcode(String barcode) {
        boolean found = false;
        for (Book book : books) {
            if (book.getBarcode().equalsIgnoreCase(barcode)) {
                System.out.println("Book found:");
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with barcode '" + barcode + "' not found.");
        }
    }

    public void removeBook(String barcode) {
        books.removeIf(book -> book.getBarcode().equalsIgnoreCase(barcode));
    }

    public void updateQuantity(String barcode, int newQuantity) {
        for (Book book : books) {
            if (book.getBarcode().equalsIgnoreCase(barcode)) {
                book.setQuantity(newQuantity);
                System.out.println("Quantity updated successfully for book with barcode '" + barcode + "'.");
                return;
            }
        }
        System.out.println("Book with barcode '" + barcode + "' not found.");
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        String choice; // Change the data type to String
        do {
            System.out.println("1. Add a book");
            System.out.println("2. Display books");
            System.out.println("3. Edit a book");
            System.out.println("4. Save data to file");
            System.out.println("5. Load data from file");
            System.out.println("6. Price Sum");
            System.out.println("7. Quantity Sum");
            System.out.println("8. Search by Name");
            System.out.println("9. Search by Barcode");
            System.out.println("10. Remove Book");
            System.out.println("11. Update Quantity");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine(); // Read the entire line

            switch (choice) {
                case "1":
                    manager.addBookFromInput();
                    break;
                case "2":
                    manager.displayBooks();
                    break;
                case "3":
                    System.out.print("Enter barcode of the book to edit: ");
                    String barcode = scanner.nextLine();
                    manager.editBook(barcode);
                    break;
                case "4":
                    System.out.print("Enter file name to save: ");
                    String saveFileName = scanner.nextLine();
                    manager.saveToFile(saveFileName);
                    break;
                case "5":
                    System.out.print("Enter file name to load: ");
                    String loadFileName = scanner.nextLine();
                    manager.readFromFile(loadFileName);
                    break;
                case "6":
                    System.out.println("Total price of all books: " + manager.calculatePriceSum());
                    break;
                case "7":
                    System.out.println("Total quantity of all books: " + manager.calculateQuantitySum());
                    break;
                case "8":
                    System.out.print("Enter name of the book to search: ");
                    String searchName = scanner.nextLine();
                    manager.searchByName(searchName);
                    break;
                case "9":
                    System.out.print("Enter barcode of the book to search: ");
                    String searchBarcode = scanner.nextLine();
                    manager.searchByBarcode(searchBarcode);
                    break;
                case "10":
                    System.out.print("Enter barcode of the book to remove: ");
                    String removeBarcode = scanner.nextLine();
                    manager.removeBook(removeBarcode);
                    break;
                case "11":
                    System.out.print("Enter barcode of the book to update quantity: ");
                    String updateBarcode = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    manager.updateQuantity(updateBarcode, newQuantity);
                    break;
                case "12":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        } while (!choice.equals("12")); // Change the condition to compare with "12"

        scanner.close();
    }

}
// 17:29