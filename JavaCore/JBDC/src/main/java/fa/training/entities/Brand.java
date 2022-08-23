package fa.training.entities;

public class Brand {
    private int brand_id;
    private String brand_name;
    private boolean status;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name, boolean status) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.status = status;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", brand_name='" + brand_name + '\'' +
                ", status=" + status +
                '}';
    }

}
