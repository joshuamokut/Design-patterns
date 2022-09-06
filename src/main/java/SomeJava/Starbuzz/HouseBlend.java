package SomeJava.Starbuzz;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        this.description = "House blend coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
