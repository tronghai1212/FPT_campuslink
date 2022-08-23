package fa.training.dao;

import fa.training.connection.ConnectJBDC;
import fa.training.connection.ProductDao;
import fa.training.entities.Brand;
import fa.training.entities.Product;

import java.sql.*;
import java.util.Scanner;

public class BrandDao {
    Scanner scanner = new Scanner(System.in);
    public Connection connect = ConnectJBDC.getConnection();

    public Brand findById(int id) {
        Brand brand = new Brand();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM Brand WHERE brand_id = " + id
                    );
            if (result.first()) {
                brand = new Brand(id,
                        result.getString("brand_name"),
                        result.getBoolean("status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return brand;
    }


    public Brand save(Brand brand) {
        try {
            PreparedStatement preparedStatement =
                    this.connect
                            .prepareStatement(
                                    "INSERT INTO "
                                            + "Brand (brand_id,"
                                            + " brand_name, status) "
                                            + "VALUES (?, ?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, brand.getBrand_id());
            preparedStatement.setString(2, brand.getBrand_name());
            preparedStatement.setBoolean(3, brand.getStatus());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()) {
                brand.setBrand_id(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return brand;
    }

    public Brand saveAll(Brand brand) {
        try {
            PreparedStatement preparedStatement =
                    this.connect
                            .prepareStatement(
                                    "INSERT INTO "
                                            + "Brand (brand_id,"
                                            + " brand_name, status) "
                                            + "VALUES (?, ?, ?)");
            preparedStatement.setInt(1, brand.getBrand_id());
            preparedStatement.setString(2, brand.getBrand_name());
            preparedStatement.setBoolean(3, brand.getStatus());
            preparedStatement.executeUpdate();
            for (int i = 0; i < 3; i++) {
                System.out.printf("Product %d: \n", i + 1);
                System.out.print("Product id: ");
                String product_id = scanner.next();
                System.out.print("Product name: ");
                String product_name = scanner.next();
                System.out.print("Model year: ");
                String model_year = scanner.next();
                System.out.print("List price: ");
                Double list_price = scanner.nextDouble();
                scanner.nextLine();
                try {
                    new ProductDao().create(new Product(product_id, product_name, model_year, list_price, brand.getBrand_id()));
                } catch (Exception e) {
                    System.out.println(e);                }
            }
        } catch (Exception e) {
            System.out.println(e);        }
        return brand;
    }

    public Brand upDate(Brand brand) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE Brand SET status = ' "
                            + brand.getStatus() + "'"
                            + "WHERE brand_id = " + brand.getBrand_id()
            );
            brand = this.findById(brand.getBrand_id());
        } catch (SQLException e) {
            System.out.println(e);        }
        return brand;
    }

    public void delete() {
        try {
            this.connect
                    .createStatement().executeUpdate("DELETE FROM Product\n" +
                    "WHERE brand_id IN (SELECT brand_id FROM Brand WHERE status = 0)");
            this.connect
                    .createStatement().executeUpdate(
                    "DELETE FROM Brand WHERE status = 0");
        } catch (SQLException e) {
            System.out.println(e);        }
    }
}
