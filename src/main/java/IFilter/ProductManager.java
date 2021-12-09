package IFilter;

import java.util.ArrayList;
import java.util.LinkedList;  // could be used instead of ArrayList
import java.util.List;

// Demonstrates how an interface can be used to implement a filter.
// The core concept is that the code required to carry out the
// matching (filtering) of objects, is no longer defined in the ProductManager class,
// but is now 'injected' into the searchBy(IFilter filter) method, having
// been created outside the class by the client.

// Dependency Injection - the dependency of filterBy() on the code
// to match two objects is 'injected' in an IFilter object 
// (which contains the match() method) - rather than being '
// hard coded' in the method.

public class ProductManager {
    private List<Product> productList;  // List interface type can refer to ArrayList or LinkedList objects

    public ProductManager() {
        this.productList = new ArrayList<Product>();
    }

    public void add(Product p) {
        this.productList.add(p);
    }

    /**
     * Here we want to filter Products by their name, so we have written a
     * method that will do that job.  Using this approach, if we want to filter
     * by 'price' then we must write another filterByPrice() method.
     *
     * @param name : a string value to be matched against the Product name
     * @return a list of Products that matched the name
     */
    public List<Product> filterByName(String name) {
        List<Product> filteredList = new ArrayList<>();

        for (Product p : this.productList) {
            if (p.getName().equalsIgnoreCase(name))
                filteredList.add(p);
        }

        return filteredList;
    }

    // The problem with writing a filterByXxxx() method for every field
    // is that the filtering must be coded in the ProductManager.
    // It would be better if a client could create a filter that specifies
    // how to filter (which fields to use) and pass that filter
    // into a filtering method.

    // The solution is to use an Interface - here, called IFilter.
    // The filterBy() method expects to be passed an IFilter obect.
    // That object has a method called matches() which has been coded
    // to match objects on particular fields.

    // This is the only filterBy() method we need, and it is up to the client
    // (i.e. code that used the ProductManager), to create and pass in the
    // appropriate IFilter which has been coded to select the desired fields.

    /**
     * @param filter - a filter object that implements the IFilter interface
     *               and thus has a matches() method to match two Products
     * @return a list of objects that matched based on the filter's match() method
     */
    public List<Product> filterBy(IFilter filter)            // I stands for Interface
    {
        List<Product> filteredList = new ArrayList<>();
        for (Product p : this.productList) {
            if (filter.matches(p))    // use matches() method of the filter to match products
                filteredList.add(p);
        }

        return filteredList;
    }
}
