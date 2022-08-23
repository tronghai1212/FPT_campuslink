package fa.training.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("do dai list: ");
        int len = scanner.nextInt();
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i< len;i++)
        {
            Book book = new Book();
            System.out.printf("nhap vao thong tin sach "+(i+1)+"\n");
            System.out.print("Name: ");
            book.setName(scanner.next());
            System.out.print("ISBN: ");
            book.setISBN(scanner.nextInt());
            System.out.print("Author: ");
            book.setAuthor(scanner.next());
            System.out.print("Publisher: ");
            book.setPublisher(scanner.next());
            bookList.add(book);
        }

        System.out.println("thong tin danh sach: ");
        for (int i=0;i< bookList.size();i++)
        {
            System.out.println(bookList.get(i).getBookInfo());
        }
    }
}
