package IFilter;

// Defining a Filter class that implements the IFilter interface.
// The matches() method is coded to match Products based on a price limit value.

public class ProductPriceLessThanFilter implements IFilter {

    private double priceLimit;

    public ProductPriceLessThanFilter(double priceLimit) {
        this.priceLimit = priceLimit;
    }

    @Override
    public boolean matches(Object o) {
        Product p = (Product) o;
        return (p.getPrice() < priceLimit) ? true : false;
    }

}
