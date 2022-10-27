public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] plusOne = new Product[products.length + 1];
        System.arraycopy(products, 0, plusOne, 0, products.length);
        plusOne[plusOne.length - 1] = product;
        products = plusOne;
    }


    public Product[] allMass() {
        return products;
    }

    public Product[] removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }

        return tmp;
    }
}

