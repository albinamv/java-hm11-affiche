package ru.netology.manager;

import lombok.*;
import ru.netology.domain.Film;
import ru.netology.domain.Repository;

@NoArgsConstructor
@Getter
@Setter
public class FilmManager {

    private Repository repo = new Repository();
    private int showLast = 10; // макс лимит по выводу последних фильмов

    public FilmManager(int showLast) {
        this.showLast = showLast;
    }

    // для тестов с Mockito
    public FilmManager(Repository repo, int showLast) {
        this.repo = repo;
        this.showLast = showLast;
    }

    public void add(Film film) {
        repo.save(film);
    }

    public Film[] findAll() {
        return repo.findAll();
    }

    public Film[] findLast() {
        int resultLength;
        Film[] films = repo.findAll();

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
