import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsTest {
    Book firstBook = new Book(1, 100, "Around the World in 80 days", "J.Vern");
    Book secondBook = new Book(2, 120, "Matrin Iden", "J.London");
    Book thirdBook = new Book(3, 200, "The arc de triomphe", "E. Remark");
    Book forthBook = new Book(4, 150, "Three friends", "E.Remark");

    Smartphone phone1 = new Smartphone(1, 40_000, "Iphone", "Apple");
    Smartphone phone2 = new Smartphone(88, 30_000, "Galaxy II", "Samsung");
    Smartphone phone3 = new Smartphone(8, 20_000, "XG", "LG");
    Smartphone phone4 = new Smartphone(6, 10_000, "Redmi", "Xiaomi");
    Smartphone phone5 = new Smartphone(88, 10_000, "Redmi", "Xiaomi");

    @Test
    public void AddBook() {
        ProductRepo bookrepository = new ProductRepo();
        ProductManager bookmanager = new ProductManager(bookrepository);
        Product[] expected = {firstBook};
        bookmanager.add(firstBook);
        Product[] actual = bookrepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveBook() {
        ProductRepo bookrepository = new ProductRepo();
        ProductManager bookmanager = new ProductManager(bookrepository);
        Product[] expected = {firstBook, thirdBook, forthBook};
        bookmanager.add(firstBook);
        bookmanager.add(secondBook);
        bookmanager.add(thirdBook);
        bookmanager.add(forthBook);
        bookrepository.removeById(2);
        Product[] actual = bookrepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveZeroBook() {
        ProductRepo bookrepository = new ProductRepo();
        assertThrows(NotFoundException.class, () -> {
            bookrepository.removeById(2);
        });
    }

    @Test
    public void RemoveBookNegId() {
        ProductRepo bookrepository = new ProductRepo();
        ProductManager bookmanager = new ProductManager(bookrepository);
        bookmanager.add(firstBook);
        bookmanager.add(secondBook);
        bookmanager.add(thirdBook);
        bookmanager.add(forthBook);
        assertThrows(NotFoundException.class, () -> {
            bookrepository.removeById(-100);
        });
    }

    @Test
    public void SearchPhoneTrue() {
        ProductRepo phonerepository = new ProductRepo();
        ProductManager phonemanager = new ProductManager(phonerepository);
        Product[] expected = {phone1};
        phonemanager.add(phone1);
        phonemanager.add(phone2);
        phonemanager.add(phone3);
        phonemanager.add(phone4);
        Product[] actual = phonemanager.searchBy("Iph");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchPhoneFalse() {
        ProductRepo phonerepository = new ProductRepo();
        ProductManager phonemanager = new ProductManager(phonerepository);
        Product[] expected = {};
        phonemanager.add(phone1);
        phonemanager.add(phone2);
        phonemanager.add(phone3);
        phonemanager.add(phone4);
        Product[] actual = phonemanager.searchBy("netology");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AddExistingId() {
        ProductRepo phonerepository = new ProductRepo();
        ProductManager phonemanager = new ProductManager(phonerepository);
        Product[] expected = {};
        phonemanager.add(phone1);
        phonemanager.add(phone2);
        phonemanager.add(phone3);
        phonemanager.add(phone4);
        assertThrows(AlreadyExistsException.class, () -> {
            phonemanager.add(phone5);
        });
    }
}

