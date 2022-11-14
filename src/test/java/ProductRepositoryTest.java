import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Шестерка воронов.. ", 300, "Бардуго Ли");
    Product book2 = new Book(2, "Место встречи изменить нельзя ", 698, "Вайнер Аркадий");
    Product book3 = new Book(3, "Жизнь взаймы, или У неба любимчиков нет  ", 440, "Ремарк Эрих Мария");
    Product smartphone1 = new Smartphone(4, " Iphone 13", 76_000, "Apple");
    Product smartphone2 = new Smartphone(5, " ipad", 45_000, "Apple");
    Product product1 = new Product(6, " Хлеб", 45);
    Product product2 = new Product(7, " Молоко", 80);


    @Test
    public void saveOneItem() {
        repository.save(book3);
        Product[] expected = {book3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveItey() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveAdd() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(product1);
        repository.save(product2);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, product1, product2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteAllBooks() {
        repository.save(smartphone2);
        repository.removeById(5);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void saveItem() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.save(product1);
        repository.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}

