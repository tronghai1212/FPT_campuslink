package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.service.BookService;
import fa.training.service.LibraryService;
import fa.training.service.MagazineService;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        MagazineService magazineService = new MagazineService();
        LibraryService libraryService = new LibraryService(bookService, magazineService);
        Scanner scanner = new Scanner(System.in);
        String flag;

        do {
            System.out.print("======LIBRARY MANAGEMENT SYSTEM======\n" +
                    "1. Add a book\n" +
                    "2. Add a magazine\n" +
                    "3. Display books and Magazines\n" +
                    "4. Add Author to book\n" +
                    "5. Display top 10 of magazines by volume\n" +
                    "6. Search books by (isbn,author,publisher)\n" +
                    "7. Find the same year and publisher\n" +
                    "Please choose function you'd like to do:");

            int userChoose = scanner.nextInt();
            switch (userChoose) {
                case 1: {
                    bookService.addBook();
                    break;
                }
                case 2: {
                    magazineService.addMagazine();
                    break;
                }
                case 3: {
                    for (Book book : bookService.bookList) {
                        book.display();
                    }
                    for (Magazine magazine : magazineService.magazineList) {
                        magazine.display();
                    }
                    break;
                }
                case 4: {
                    bookService.addAuthor();
                    break;
                }
                case 5: {
                    magazineService.top10Volume();
                    break;
                }
                case 6: {
                    System.out.print("Choose what you want to search by:\n 1-ISBN     2-Author    3-Publiser \n");
                    int searchBy = scanner.nextInt();
                    switch (searchBy) {
                        case 1: {
                            bookService.searchBookByISBN();
                            break;
                        }
                        case 2: {
                            bookService.searchBookByAuthor();
                            break;
                        }
                        case 3: {
                            bookService.searchBookByPublisher();
                            break;
                        }
                        default:
                            System.out.println("Try again!");
                            break;
                    }
                    break;
                }
                case 7: {
                    libraryService.findSameYearAndPublisher();
                }
            }
            System.out.print("Do you choose to continue? (y/n) ");
            flag = scanner.next();
            scanner.nextLine();
        }
        while (flag.equals("y"));
    }
}
