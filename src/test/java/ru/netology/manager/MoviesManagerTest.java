package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviesManagerTest {
    @Test
    public void shouldAddMovie() {

        Movies first = new Movies("Бладшот", "боевик");
        Movies second = new Movies("Вперед", "мультфильм");
        Movies third = new Movies("Отель 'Белград'", "комедия");

        MoviesManager moviesManager = new MoviesManager();
        moviesManager.add(first);
        moviesManager.add(second);
        moviesManager.add(third);

        Movies[] expected = {first, second, third};
        Movies[] actual = moviesManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Movies first = new Movies("Бладшот", "боевик");
        Movies second = new Movies("Вперед", "мультфильм");
        Movies third = new Movies("Отель 'Белград'", "комедия");
        Movies fourth = new Movies("Джентльмены", "боевик");
        Movies fifth = new Movies("Человек-невидимка", "ужасы");

        MoviesManager moviesManager = new MoviesManager();
        moviesManager.findAll();

        Movies[] expected = {first, second, third, fourth, fifth};
        Movies[] actual = {first, second, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimit() {
        Movies first = new Movies("Бладшот", "боевик");
        Movies second = new Movies("Вперед", "мультфильм");
        Movies third = new Movies("Отель 'Белград'", "комедия");
        Movies fourth = new Movies("Джентльмены", "боевик");
        Movies fifth = new Movies("Человек-невидимка", "ужасы");

        MoviesManager moviesManager = new MoviesManager(5);
        moviesManager.add(first);
        moviesManager.add(second);
        moviesManager.add(third);
        moviesManager.add(fourth);
        moviesManager.add(fifth);

        Movies[] expected = moviesManager.getLast();
        Movies[] actual = {fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMaxLimit() {

        Movies first = new Movies("Бладшот", "боевик");
        Movies second = new Movies("Вперед", "мультфильм");
        Movies third = new Movies("Отель 'Белград'", "комедия");
        Movies fourth = new Movies("Джентльмены", "боевик");
        Movies fifth = new Movies("Человек-невидимка", "ужасы");
        Movies sixth = new Movies("Тролли", "мультфильм");
        Movies seventh = new Movies("Номер один", "комедия");
        Movies eighth = new Movies("Остров проклятых", "триллер");
        Movies ninth = new Movies("Начало", "фантастика");
        Movies tenth = new Movies("Бойцовский клуб", "триллер");
        Movies eleventh = new Movies("Волк с Уолл-стрит", "драма");

        MoviesManager moviesManager = new MoviesManager(10);
        moviesManager.add(first);
        moviesManager.add(second);
        moviesManager.add(third);
        moviesManager.add(fourth);
        moviesManager.add(fifth);
        moviesManager.add(sixth);
        moviesManager.add(seventh);
        moviesManager.add(eighth);
        moviesManager.add(ninth);
        moviesManager.add(tenth);
        moviesManager.add(eleventh);

        Movies[] expected = moviesManager.getLast();
        Movies[] actual = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }
}