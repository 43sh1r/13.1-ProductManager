import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Масте и Маргарита", 3, "Булгаков");
    Product book1 = new Book(2, "AmpireV", 450, "Пелевин");
    Product book3 = new Book(4, "Мертвые души", 0, "Гоголь");
    Product book4 = new Book(4, "Мертвые души", 0, "Гоголь");


    @Test
    public void addTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        Product[] actual = {book, book1, book3};
        Product[] expect = repository.allMass();
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void searchByTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        Product[] actual = {book1};
        Product[] expect = manager.searchBy("AmpireV");
        Assertions.assertArrayEquals(expect, actual);
    }
    @Test
    public void searchByTwoResultTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = {book3,book4};
        Product[] expect = manager.searchBy("Мертвые души");
        Assertions.assertArrayEquals(expect, actual);
    }
    @Test
    public void searchByZeroResultTest() {
        manager.add(book);
        manager.add(book1);
        manager.add(book3);
        manager.add(book4);
        Product[] actual = {};
        Product[] expect = manager.searchBy("Мертвые кошки");
        Assertions.assertArrayEquals(expect, actual);
    }
}