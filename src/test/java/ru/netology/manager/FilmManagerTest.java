package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.domain.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class FilmManagerTest {

    // используемые переменные фильмов
    private Film first = new Film(1, "Бладшот", "Боевик", "bloodshot_pic.webp");
    private Film second = new Film(2, "Вперёд", "Мультфильм", "onward_pic.webp");
    private Film third = new Film(3, "Отель Белград", "Комедия", "hotelbelgrad_pic.webp");

    // переписаны 3 теста на проверку метода FilmManager.findLast с использованием Mockito
    @Mock
    private Repository repo = Mockito.mock(Repository.class);
    @InjectMocks
    private FilmManager manager;

    @Test
    public void shouldFindLastIfArrayLengthIsUnderLimit() {
        // настройка загрушки
        manager = new FilmManager(repo, 5);
        Film[] returned = {first, second, third};
        doReturn(returned).when(repo).findAll();

        Film[] expected = {third, second, first};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfArrayLengthIsAboveLimit() {
        // настройка загрушки
        manager = new FilmManager(repo, 2);
        Film[] returned = {first, second, third};
        doReturn(returned).when(repo).findAll();

        Film[] expected = {third, second};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastIfArrayLengthEqualsLimit() {
        // настройка загрушки
        manager = new FilmManager(repo, 3);
        Film[] returned = {first, second, third};
        doReturn(returned).when(repo).findAll();

        Film[] expected = {third, second, first};
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    // остальные тесты без Mockito
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
    public void shouldFindLastIfNoItems() {
        FilmManager manager = new FilmManager(3);

        Film[] expected = new Film[0];
        Film[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }


}