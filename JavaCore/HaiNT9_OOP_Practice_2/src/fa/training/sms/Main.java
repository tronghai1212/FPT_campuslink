package fa.training.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        students.add(new Student("STD001", "Nguyen Hai", "Computer", "2000/12/12"));
        students.add(new Student("STD002", "Nguyen Hien", "Science", "2000/04/11"));
        students.add(new Student("STD003", "Nguyen Thuong", "Art", "2000/01/11")) ;
        students.add(new Student("STD004", "Nguyen Hoan", "Marketing", "2000/01/12"));
        students.add(new Student("STD004", "Nguyen Thao", "Marketing", "2000/01/22"));
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("C01", "Computer Vision", "GD2")) ;
        courses.add(new Course("C02", "Music", "G3")) ;
        courses.add(new Course("C03", "History", "G2")) ;
        courses.add(new Course("C04", "Machine Learning", "GD2")) ;
        courses.add(new Course("C05", "Drawing", "E3")) ;
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).toString());
        }

        List<Enroll> enrolls = new ArrayList<>();
        enrolls.add(new Enroll("STD002", "C04", "2022/04/21", 7)) ;
        enrolls.add(new Enroll("STD002", "C02", "2022/04/21", 7));
        enrolls.add(new Enroll("STD001", "C04", "2022/04/21", 5)) ;
        enrolls.add(new Enroll("STD003", "C01", "2022/04/22", 9));
        enrolls.add(new Enroll("STD005", "C05", "2022/03/21", 1));
        for (int i = 0; i < enrolls.size(); i++) {
            System.out.println(enrolls.get(i).toString());
        }

        List<BookAdoption> bookAdoptions = new ArrayList<>();
        bookAdoptions.add(new BookAdoption("C01", "2019/01/02", "B001"));
        bookAdoptions.add(new BookAdoption("C02", "2019/01/02", "B001")) ;
        bookAdoptions.add(new BookAdoption("C02", "2019/03/07", "B003"));
        bookAdoptions.add(new BookAdoption("C03", "2019/03/09", "B005"));
        bookAdoptions.add(new BookAdoption("C04", "2019/02/11", "B004"));
        for (int i = 0; i < bookAdoptions.size(); i++) {
            System.out.println(bookAdoptions.get(i).toString());
        }

        List<Book> books = new ArrayList<>();
        books.add(new Book("B001", "Book 1", "NXB Kim Dong", "Le Hai"));
        books.add(new Book("B002", "Book 2", "NXB Giao duc", "Le Cap"));
        books.add(new Book("B003", "Book 3", "NXB Ha Noi", "Le Hien"));
        books.add(new Book("B004", "Book 4", "NXB TPHCM", "Le Roi"));
        books.add( new Book("B005", "Book 5", "NXB Da Nang", "Le Dinh"));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }

        System.out.print("Enter SSN: ");
        String ssn = scanner.next();
        System.out.println("CourseNames this student enrolls: ");
        for (int i = 0; i < enrolls.size(); i++) {
            if (ssn.equals(enrolls.get(i).getSSN())) {
                for (int j = 0; j < courses.size(); j++) {
                    if (enrolls.get(i).getCourseID().equals(courses.get(j).getCourseID())) {
                        System.out.println(courses.get(j).getCourseName());
                    }
                }
            }
        }

        System.out.print("Enter ISBN: ");
        String isbn = scanner.next();
        System.out.println("All book adoption given ISBN: ");
        for (int i = 0; i < books.size(); i++) {
            if (isbn.equals(books.get(i).getISBN())) {
                for (int j = 0; j < bookAdoptions.size(); j++) {
                    if (books.get(i).getISBN().equals(bookAdoptions.get(j).getISBN())) {
                        System.out.println(bookAdoptions.get(j).toString());
                    }
                }
            }
        }
    }

}
