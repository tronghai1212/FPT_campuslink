package fa.training.connection;

import fa.training.entities.Product;

import java.sql.*;

public class ProductDao {
    public Connection connect = ConnectJBDC.getConnection();

    public Product findById(String id) {
        Product product = new Product();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM Product WHERE product_id = " + id
                    );
            if (result.first()) {
                product = new Product(id,
                        result.getString("product_name"),
                        result.getString("model_year"),
                        result.getDouble("list_price"),
                        result.getInt("brand_id"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

    public Product create(Product product) {
        try {
            PreparedStatement preparedStatement =
                    this.connect
                            .prepareStatement(
                                    "INSERT INTO "
                                            + "Product (product_id,"
                                            + " product_name, model_year,list_price,brand_id) "
                                            + "VALUES (?, ?, ?, ?, ?)"
                                    , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getProduct_id());
            preparedStatement.setString(2, product.getProduct_name());
            preparedStatement.setString(3, product.getModel_year());
            preparedStatement.setDouble(4, product.getList_price());
            preparedStatement.setInt(5, product.getBrand_id());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                product.setProduct_id(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return product;
    }

    public Product update(Product product) {
        try {
            PreparedStatement preparedStatement =
                    this.connect
                            .prepareStatement("UPDATE Product\n" +
                                    "SET product_name = ?,\n" +
                                    "\tmodel_year = ?,\n" +
                                    "\tlist_price = ?\n" +
                                    "WHERE product_id = ?");
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setString(2, product.getModel_year());
            preparedStatement.setDouble(3, product.getList_price());
            preparedStatement.setString(4, product.getProduct_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }


    public void delete(Product product) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM Product WHERE product_id = "
                            + product.getProduct_id()
            );
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void findByBrandId(int brand_id) {

        try {
            ResultSet resultSet = this.connect
                    .createStatement().executeQuery(
                            "SELECT * FROM Product \n" +
                                    "WHERE brand_id = " + brand_id + "\n" +
                                    "ORDER BY list_price DESC;"
                    );
            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("model_year"),
                        resultSet.getDouble("list_price"),
                        resultSet.getInt("brand_id"));
                System.out.println(product.toString());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
