package ru.netology.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Film {
    private int id;
    private String name;
    private String genre;
    private String pictureURL;
}
