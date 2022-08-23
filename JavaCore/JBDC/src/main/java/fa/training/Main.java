package fa.training;

import fa.training.connection.ProductDao;
import fa.training.dao.BrandDao;
import fa.training.entities.Brand;
import fa.training.entities.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BrandDao brandDao = new BrandDao();
        ProductDao productDao = new ProductDao();
        Scanner scanner = new Scanner(System.in);
        String flag = null;

        do {
            System.out.print("======PRODUCT TRACKING======\n" +
                    "1. Brand Management\n" +
                    "2. Product Management\n" +
                    "3. Close program\n" +
                    "Please choose function you'd like to do:");

            int menu = scanner.nextInt();
            switch (menu) {
                case 1: {
                    System.out.print("1. Add a new brand without a product\n" +
                            "2. Add a new brand with products\n" +
                            "3. Delete the brands inactive\n" +
                            "Please choose function you'd like to do:");
                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1: {
                            Brand brand = new Brand();
                            try {
                                System.out.print("Brand ID: ");
                                brand.setBrand_id(scanner.nextInt());
                                scanner.nextLine();
                                System.out.print("Brand name: ");
                                brand.setBrand_name(scanner.nextLine());
                                System.out.print("Status: ");
                                byte status = scanner.nextByte();
                                scanner.nextLine();
                                if (status == 1) {
                                    brand.setStatus(true);
                                } else {
                                    brand.setStatus(false);
                                }

                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            brandDao.save(brand);
                            break;
                        }
                        case 2: {
                            Brand brand = new Brand();

                            try {
                                System.out.print("Brand ID: ");
                                brand.setBrand_id(scanner.nextInt());
                                scanner.nextLine();
                                System.out.print("Brand name: ");
                                brand.setBrand_name(scanner.nextLine());
                                System.out.print("Status: ");
                                byte status = scanner.nextByte();
                                scanner.nextLine();
                                if (status == 1) {
                                    brand.setStatus(true);
                                } else {
                                    brand.setStatus(false);
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            brandDao.saveAll(brand);
                            break;
                        }
                        case 3: {
                            brandDao.delete();
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("1. Update an existing product\n" +
                            "2. Find all of the products by brand id\n" +
                            "Please choose function you'd like to do:");
                    int choose2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choose2) {
                        case 1: {
                            Product product = new Product();
                            try {
                                System.out.print("Product ID: ");
                                product.setProduct_id(scanner.next());
                                scanner.nextLine();
                                System.out.print("New Product name: ");
                                product.setProduct_name(scanner.nextLine());
                                System.out.print("New Model year: ");
                                product.setModel_year(scanner.next());
                                scanner.nextLine();
                                System.out.print("New list price: ");
                                product.setList_price(scanner.nextDouble());
                                scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            productDao.update(product);
                            break;
                        }
                        case 2: {
                            System.out.print("Brand ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            productDao.findByBrandId(id);
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    flag = "n";
                    continue;
                }
            }
            System.out.print("Do you wish to continue? (y/n) ");
            flag = scanner.next();
            scanner.nextLine();
        }
        while (flag.equals("y"));
    }
}
