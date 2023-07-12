import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task5 {
    private static Map<String, Book> books = new HashMap<>();
    private static Map<Integer, Member> members = new HashMap<>();
    private static int bookIdCounter = 1;
    private static int memberIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library !");

        boolean quit = false;
        while (!quit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Quit");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addMember(scanner);
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    borrowBook(scanner);
                    break;
                case 4:
                    returnBook(scanner);
                    break;
                case 5:
                    searchBook(scanner);
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        System.out.println("Do visit the Library Again :) !");
    }

    private static void addMember(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        int memberId = memberIdCounter++;
        Member member = new Member(memberId, name, phoneNumber);
        members.put(memberId, member);

        System.out.println("Member added successfully. Member ID: " + memberId);
    }
    
    private static void addBook(Scanner scanner) {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publication Year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); 

        String bookId = "B" + bookIdCounter++;
        Book book = new Book(bookId, title, author, publicationYear);
        books.put(bookId, book);

        System.out.println("Book added . Book ID: " + bookId);
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();

        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member does not exist.");
            return;
        }

        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book does not exist.");
            return;
        }

        if (book.isAvailable()) {
            book.setBorrower(member);
            member.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available for borrowing.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Book ID: ");
        String bookId = scanner.nextLine();

        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member does not exist.");
            return;
        }

        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book does not exist.");
            return;
        }

        if (book.getBorrower() != null && book.getBorrower().getId() == memberId) {
            book.setBorrower(null);
            member.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter the search keyword: ");
        String keyword = scanner.nextLine();

        List<Book> searchResults = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No books found matching the search criteria.");
        } else {
            System.out.println("Search Results:");
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }
}

class Book {
    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private Member borrower;

    public Book(String id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public boolean isAvailable() {
        return borrower == null;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Publication Year: " + publicationYear +
                ", Status: " + (isAvailable() ? "Available" : "Borrowed by Member ID: " + borrower.getId());
    }
}

class Member {
    private int id;
    private String name;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    public Member(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
