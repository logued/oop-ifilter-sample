package IFilter;

// Defining a Filter class that implements the IFilter interface.
// The matches() method is coded to match Products based on their name.

public class ProductNameFilter implements IFilter {
    private String name;

    public ProductNameFilter(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(Object other) {
        Product p = (Product) other;        // cast from Object to Product
        return p.getName().equalsIgnoreCase(name);
    }
}
