package ru.netology.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private Film first = new Film(1, "Бладшот", "Боевик", "bloodshot_pic.webp");
    private Film second = new Film(2, "Вперёд", "Мультфильм", "onward_pic.webp");
    private Film third = new Film(3, "Отель Белград", "Комедия", "hotelbelgrad_pic.webp");

    @Test
    void shouldRemoveById() {
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.removeById(2);

        Film[] expected = {first, third};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    // оставлен в учебных целях)
    @Test
    @Disabled
    void shouldThrowExceptionIfNoId() {
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.removeById(4);

        Film[] expected = {first, second, third};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.removeAll();

        Film[] expected = {};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        Film expected = repo.findById(3);
        Film actual = third;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullWithFindById() {
        Repository repo = new Repository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        Film expected = repo.findById(56);

        assertNull(expected);
    }
}