package fa.training.service;

import fa.training.entities.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookService {
    public List<Book> bookList = new ArrayList<Book>();
    Scanner scanner = new Scanner(System.in);
    String choose = "";

    public void addBook() {
        Book book = new Book();
        System.out.println("Enter information about new book: ");
        System.out.print("ISBN: ");
        book.setIsbn(scanner.next());
        scanner.nextLine();
        do {
            System.out.print("Author: ");
            book.addAuthor(scanner.nextLine());
            System.out.print("More author? (y/n) ");
            choose = scanner.next();
            scanner.nextLine();
        }
        while (choose.equalsIgnoreCase("y"));
        System.out.print("Publication Place: ");
        book.setPublicationPlace(scanner.nextLine());
        System.out.print("Publication Year: ");
        book.setPublicationYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Publisher: ");
        book.setPublisher(scanner.nextLine());
        System.out.print("Publication Date(MM/dd/yyyy): ");
        String date = scanner.next();
        scanner.nextLine();
        try {
            book.setPublicationDate(new SimpleDateFormat("MM/dd/yyyy").parse(date));
        } catch (ParseException e) {
            System.out.println(e);
        }
        bookList.add(book);
    }

    public void addAuthor() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.next();
        scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getAuthor().contains(author)) {
                    System.out.println("Author existed");
                } else {
                    book.addAuthor(author);
                    System.out.println("Add successfully!");
                }
            } else {
                System.out.println("Enter the correct ISBN");
            }
        }
    }

    public void searchBookByISBN() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.next();
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                book.display();
            }
        }
    }

    public void searchBookByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        for (Book book : bookList) {
            for (String authorBook : book.getAuthor()) {
                if (authorBook.equals(author)) {
                    book.display();
                }
            }
        }
    }

    public void searchBookByPublisher() {
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getPublisher().equals(publisher)) {
                book.display();
            }
        }
    }
}
