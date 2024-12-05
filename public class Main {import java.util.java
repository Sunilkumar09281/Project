public class Main {import java.util.ArrayList;
    import java.util.Scanner;
    
    public class LibraryManagementSystem {
        // Book class to represent a book
        static class Book {
            String title;
            boolean isBorrowed;
    
            Book(String title) {
                this.title = title;
                this.isBorrowed = false; // Initially, the book is available
            }
    
            void borrowBook() {
                isBorrowed = true;
            }
    
            void returnBook() {
                isBorrowed = false;
            }
        }
    
        public static void main(String[] args) {
            ArrayList<Book> library = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("\n--- Library Management System ---");
                System.out.println("1. Add a Book");
                System.out.println("2. View Books");
                System.out.println("3. Borrow a Book");
                System.out.println("4. Return a Book");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1: // Add a Book
                        System.out.print("Enter the book title: ");
                        String title = scanner.nextLine();
                        library.add(new Book(title));
                        System.out.println("Book added successfully!");
                        break;
    
                    case 2: // View Books
                        if (library.isEmpty()) {
                            System.out.println("No books available in the library.");
                        } else {
                            System.out.println("Available Books:");
                            for (int i = 0; i < library.size(); i++) {
                                Book book = library.get(i);
                                String status = book.isBorrowed ? "Borrowed" : "Available";
                                System.out.println((i + 1) + ". " + book.title + " (" + status + ")");
                            }
                        }
                        break;
    
                    case 3: // Borrow a Book
                        if (library.isEmpty()) {
                            System.out.println("No books available to borrow.");
                        } else {
                            System.out.print("Enter the book number to borrow: ");
                            int borrowIndex = scanner.nextInt() - 1;
    
                            if (borrowIndex >= 0 && borrowIndex < library.size()) {
                                Book bookToBorrow = library.get(borrowIndex);
                                if (!bookToBorrow.isBorrowed) {
                                    bookToBorrow.borrowBook();
                                    System.out.println("You borrowed: " + bookToBorrow.title);
                                } else {
                                    System.out.println("This book is already borrowed.");
                                }
                            } else {
                                System.out.println("Invalid book number.");
                            }
                        }
                        break;
    
                    case 4: // Return a Book
                        if (library.isEmpty()) {
                            System.out.println("No books available to return.");
                        } else {
                            System.out.print("Enter the book number to return: ");
                            int returnIndex = scanner.nextInt() - 1;
    
                            if (returnIndex >= 0 && returnIndex < library.size()) {
                                Book bookToReturn = library.get(returnIndex);
                                if (bookToReturn.isBorrowed) {
                                    bookToReturn.returnBook();
                                    System.out.println("You returned: " + bookToReturn.title);
                                } else {
                                    System.out.println("This book was not borrowed.");
                                }
                            } else {
                                System.out.println("Invalid book number.");
                            }
                        }
                        break;
    
                    case 5: // Exit
                        System.out.println("Exiting the Library Management System. Goodbye!");
                        scanner.close();
                        System.exit(0);
    
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
    
    
}
