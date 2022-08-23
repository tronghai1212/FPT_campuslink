package fa.training.ex3;

import fa.training.ex2.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    private String title;
    private String[] authors;
    private Integer numberOfPages;
    private float price;
    private String publisher;


    Scanner scanner = new Scanner(System.in);
    public String getTitle() {
        return title;
    }

    public Book(){

    }

    public Book(String title, String[] authors, Integer numberOfPages, float price, String publisher) {
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book addBook(){
        Book book = new Book();
        System.out.print("title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("enter number of author: ");
        int n;
        n = scanner.nextInt();
        scanner.nextLine();
        authors = new String[n];
        for (int i =0; i<n; i++){
            System.out.print("authors "+(i+1)+" : ");
            authors[i] = scanner.nextLine();
            book.setAuthors(authors);
        }
        System.out.print("publiser: ");
        book.setPublisher(scanner.nextLine());
        System.out.print("price: ");
        book.setPrice(scanner.nextFloat());
        scanner.nextLine();
        System.out.print("number Of Pages: ");
        book.setNumberOfPages(scanner.nextInt());
        return book;
    }

}
