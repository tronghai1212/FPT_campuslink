package fa.training.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        List<Book> books = new ArrayList<>();
        for (int i = 0; i<5; i++){
            Book book = new Book();
            books.add(book.addBook());
            library.setListofBook(books);
        }
        float totalPrice = 0;
        for (int i = 0; i < library.getListofBook().size(); i++) {
            totalPrice += library.getListofBook().get(i).getPrice();
        }
        System.out.println("total price of all books: " + totalPrice);
    }
}
