public class Book extends Product {
    private String author;

    public Book(int id, int cost, String name, String author) {
        super(id, cost, name);
        this.author = author;
    }
}
