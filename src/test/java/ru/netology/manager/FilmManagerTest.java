package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    private Film first = new Film(1, "Бладшот", "Боевик", "bloodshot_pic.webp");
    private Film second = new Film(2, "Вперёд", "Мультфильм", "onward_pic.webp");
    private Film third = new Film(2, "Отель Белград", "Комедия", "hotelbelgrad_pic.webp");

    @Test
    public void shouldAddIfNoItems() {
        FilmManager manager = new FilmManager();
        manager.add(first);

        Film[] expected = {first};
        Film[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddIfContains() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);

        Film[] expected = {first, second};
        Film[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddDuplicate() {
        FilmManager manager = new FilmManager();
        manager.add(first);
        manager.add(second);
        manager.add(first);

        Film[] expected = {first, second};
        Film[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfArrayLengthIsUnderLimit() {
        FilmManager manager = new FilmManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] expected = {third, second, first};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfArrayLengthIsAboveLimit() {
        FilmManager manager = new FilmManager(2);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] expected = {third, second};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfArrayLengthEqualsLimit() {
        FilmManager manager = new FilmManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Film[] expected = {third, second, first};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfNoItems() {
        FilmManager manager = new FilmManager(3);

        Film[] expected = new Film[0];
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

}