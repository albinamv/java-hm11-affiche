package ru.netology.domain;

import java.util.Arrays;

public class Repository {
    private Film[] films = new Film[0];

    public Film[] findAll() {
        return films;
    }

    public void save(Film film) {
        // предполагаю, что в данной афише каждый фильм в единственном экземпяре, поэтому добавляю проверку
        boolean contains = Arrays.asList(films).contains(film); // есть ли уже этот фильм в списке

        if (!contains) {
            int length = films.length + 1;
            Film[] tmp = new Film[length];
            System.arraycopy(films, 0, tmp, 0, films.length);

            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = film;
            films = tmp;
        }
    }

    public Film findById(int id) {
        Film result = null;
        for (Film film : films) {
            if (film.getId() == id) {
                result = film;
                break;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new Film[0];
    }


}
