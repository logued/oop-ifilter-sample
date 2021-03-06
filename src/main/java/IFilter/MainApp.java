package IFilter;

// Use a Filter to filter a list of products and return a new
// list containing only the filtered Product objects.

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        MainApp theApp = new MainApp();
        theApp.start();
    }

    public void start() {
        demoFilter();
    }

    private void demoFilter() {
        ProductManager pMgr = new ProductManager();
        pMgr.add(new Product("Fallout 4", 64.99));
        pMgr.add(new Product("MGS", 45.99));
        pMgr.add(new Product("The Witcher III", 70.59));
        pMgr.add(new Product("Sims 5", 35.50));
        pMgr.add(new Product("MGS", 65.99)); //deliberate duplicate

        System.out.println("Filter by Product name...");
        List<Product> nameList = pMgr.filterBy(new ProductNameFilter("mGs"));
        System.out.println(nameList);

        System.out.println("Filter by Product price less than an amount...");
        List<Product> costList = pMgr.filterBy(new ProductPriceLessThanFilter(65));
        System.out.println(costList);
    }


    // TODO Write a Filter that will filter Products that are between two prices
    //       ProductPriceBetweenFilter(50,70)
    // Test your filter.

}
