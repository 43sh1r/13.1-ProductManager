public class Book extends Product {
    public String Author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}