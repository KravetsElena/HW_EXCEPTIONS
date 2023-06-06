package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11, "Хлеб", 40);
    Product product2 = new Product(10, "Вода", 50);
    Product product3 = new Product(5, "Молоко", 70);

    @Test
    public void shouldDeleteExistingItem() {    /////////// успешность удаления существующего элемента

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(10);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldGenerationReport() {   /////генерация NotFoundException
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-8);
        });
    }
}
