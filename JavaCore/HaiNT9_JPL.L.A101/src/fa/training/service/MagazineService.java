package fa.training.service;

import fa.training.entities.Magazine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagazineService {
    public List<Magazine> magazineList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addMagazine() {
        Magazine magazine = new Magazine();
        System.out.println("Enter information for new magazine: ");
        System.out.print("Author: ");
        magazine.setAuthor(scanner.nextLine());
        System.out.print("Volume: ");
        magazine.setVolume(scanner.nextInt());
        System.out.print("Edition: ");
        magazine.setEdition(scanner.nextInt());
        System.out.print("Publication Year: ");
        magazine.setPublicationYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Publisher: ");
        magazine.setPublisher(scanner.nextLine());
        System.out.print("Publication Date(MM/dd/yyyy): ");
        String date = scanner.next();
        scanner.nextLine();
        try {
            magazine.setPublicationDate(new SimpleDateFormat("MM/dd/yyyy").parse(date));
        } catch (ParseException e) {
            System.out.println("error Date format");
        }
        magazineList.add(magazine);
    }

    public void top10Volume() {
        Collections.sort(magazineList, Magazine::compareTo);
        for (int i  = 0; i< magazineList.size(); i++){
            magazineList.get(i).display();
            if (i==10){
                break;
            }
        }
    }
}