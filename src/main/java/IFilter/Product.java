package IFilter;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", price=" + price + "]";
    }

    //used to prevent an ArrayList from allowing duplicates
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    //used to prevent an ArrayList from allowing duplicates
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (this.price != other.price)
            return false;
        return true;
    }

    /*
     * The clone method is used to create a (deep) copy of the current Product object(non-Javadoc)
     * A deep copy is where the clone is a separate object in RAM - so changing the clone wont change the original.
     * A shallow copy is where the clone points to the same object in RAM - so changing either object affects both.
     * e.g.
     *
     * A shallow copy would be made like this...
     *
     *	Product p = new Product("Coca Cola 2ltr", 3.50);
     *  Product shallowCopy = p;
     *
     *  p.setName("Original Coca Cola 2ltr"); //this statement would change the name for shallowCopy too
     *
     * A deep copy would be made like this...
     *
     * 	Product p = new Product("Coca Cola 2Ltr", 3.50);
     *  Product deepCopy = new Product(p.getName(), p.getPrice());
     *
     *  p.setName("Original Coca Cola 2ltr"); //this statement would ONLY change the name for p
     *
     */
    public Object clone() {
        //shallow
        Product clone = new Product(this.name, this.price);
        return clone;
    }
}














