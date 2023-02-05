package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Product book1 = new Book(2, "Азазель", 600, "Борис Акунин");
    Product book2 = new Book(3, "Капитанская дочка", 800, "Александр Пушкин");
    Product book3 = new Book(3, "Капитанский орден", 500, "Неизвестный");

    Product smartphone = new Smartphone(1, "Iphone X", 999, "Apple");

    Product[] products = new Product[]{book1, book2};
    Repository repository = new Repository(products);
    Manager manager = new Manager(repository);

    @Test
    void add() {
        manager.add(smartphone);

        Product[] expected = {book1, book2, smartphone};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByOneBook() {
        Product[] actual = manager.searchBy("апитан");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchByTwoBooks() {
        manager.add(book3);

        Product[] actual = manager.searchBy("апитан");
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphone() {
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchByNone() {
        Product[] actual = manager.searchBy("фаренгейт");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        Product[] actual = manager.searchBy("Акунин");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByManufacturer() {
        manager.add(smartphone);

        Product[] actual = manager.searchBy("Apple");
        Product[] expected = {smartphone};

        Assertions.assertArrayEquals(expected, actual);
    }
}