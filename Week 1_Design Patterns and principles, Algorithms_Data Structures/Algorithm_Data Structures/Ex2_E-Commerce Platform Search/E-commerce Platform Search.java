import java.util.Arrays;
import java.util.Comparator;


class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + "] " + productName + " - " + category;
    }
}


class SearchUtils {

   
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Product[] products = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Laptop", "Electronics"),
            new Product(103, "Chair", "Furniture"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Watch", "Accessories")
        };

        
        System.out.println("Linear Search:");
        Product result1 = SearchUtils.linearSearch(products, "Mobile");
        System.out.println(result1 != null ? result1 : "Product not found");

        
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n Binary Search:");
        Product result2 = SearchUtils.binarySearch(products, "Mobile");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
