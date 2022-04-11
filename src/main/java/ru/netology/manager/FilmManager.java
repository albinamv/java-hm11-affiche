package ru.netology.manager;

import lombok.*;
import ru.netology.domain.Film;

import java.util.Arrays;

@NoArgsConstructor
@Getter
@Setter
public class FilmManager {

    private Film[] films = new Film[0];
    private int showLast = 10; // макс лимит по выводу последних фильмов

    public FilmManager(int showLast) {
        this.showLast = showLast;
    }

    public void add(Film film) {
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

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength;

        if (films.length >= showLast) {
            resultLength = showLast;
        } else {
            resultLength = films.length;
        }

        Film[] result = new Film[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
