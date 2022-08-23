package fa.training.exercise1;

public class Book {
    private String name;
    private int ISBN;
    private String author;
    private String publisher;

    public Book() {
    }

    public Book(String name, int ISBN, String author, String publisher) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookInfo(){
        return "Book{" +
                "name='" + this.getName() + '\'' +
                ", ISBN=" + this.getISBN() +
                ", author='" + this.getAuthor() + '\'' +
                ", publisher='" + this.getPublisher() + '\'' +
                '}';
    }
}
