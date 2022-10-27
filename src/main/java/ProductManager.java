public class ProductManager {
    private ProductRepo repository;

    public ProductManager(ProductRepo repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product[] searchBy(String text) {
        ProductRepo result = new ProductRepo();
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                result.save(product);
            }
        }
        return result.findAll();
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}

