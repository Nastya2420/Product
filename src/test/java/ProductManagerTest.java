import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Шестерка воронов.. ", 300, "Бардуго Ли");
    Product book2 = new Book(2, "Маленький принц", 698, "Де Сент-Экзюпери");
    Product book3 = new Book(3, "Жизнь взаймы, или У неба любимчиков нет  ", 440, "Ремарк Эрих Мария");
    Product smartphone1 = new Smartphone(4, "IPhone 13", 76_000, "Apple");
    Product smartphone2 = new Smartphone(5, "IPhone PRO ", 45_000, "Apple");
    Product product1 = new Product(6, " Очки", 45);
    Product product2 = new Product(7, " Молоко", 80);


    @Test // один продукт
    public void searchingByName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        String name = "Молоко";
        Product[] expected = {product2};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test // два продукта
    public void findTwoProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        String name = "IPhone";
        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // нет совпадений
    public void searchingByNoName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        String name = "Sony";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void Add() {
        manager.add(book1);
        Product[] expected = {book1};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void Add1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test

    public void toFind() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        String name = "Жизнь";
        Product[] expected = {book3};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        String name = "Молоко";
        Product[] expected = {product2};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

}

