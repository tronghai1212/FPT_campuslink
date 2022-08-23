package fa.training.exercise3;

public class Truck extends Car {
    private int weight;

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double getRegularPrice() {
        return super.getRegularPrice() * (this.weight > 2000 ? 0.9 : 0.8);
    }
}
