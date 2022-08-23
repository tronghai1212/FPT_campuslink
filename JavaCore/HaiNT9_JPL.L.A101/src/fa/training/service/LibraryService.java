package fa.training.service;

import fa.training.entities.Book;
import fa.training.entities.Magazine;

public class LibraryService {
    BookService bookService;
    MagazineService magazineService;

    public LibraryService(BookService bookService, MagazineService magazineService) {
        this.bookService = bookService;
        this.magazineService = magazineService;
    }

    public void findSameYearAndPublisher() {
        for (Book book : bookService.bookList) {
            for (Magazine magazine : magazineService.magazineList) {
                if (book.getPublicationYear() == magazine.getPublicationYear()) {
                    if (book.getPublisher().equals(magazine.getPublisher())) {
                        System.out.println("All books & Magazines with same publisher & publication year: ");
                        book.display();
                        magazine.display();
                    }
                }
            }
        }
    }
}
