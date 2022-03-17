package ru.netology.manager;

import domain.Movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    Movie first = new Movie("Бладшот", "боевик");
    Movie second = new Movie("Вперед", "мультфильм");
    Movie third = new Movie("Отель 'Белград'", "комедия");
    Movie fourth = new Movie("Джентльмены", "боевик");
    Movie fifth = new Movie("Человек-невидимка", "ужасы");
    Movie sixth = new Movie("Тролли", "мультфильм");
    Movie seventh = new Movie("Номер один", "комедия");
    Movie eighth = new Movie("Остров проклятых", "триллер");
    Movie ninth = new Movie("Начало", "фантастика");
    Movie tenth = new Movie("Бойцовский клуб", "триллер");
    Movie eleventh = new Movie("Волк с Уолл-стрит", "драма");

    @Test
    public void shouldAddMovie() {
        MovieManager movieManager = new MovieManager();
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);

        Movie[] expected = {first, second, third};
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        MovieManager movieManager = new MovieManager();
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.findAll();

        Movie[] expected = {first, second, third};
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimit() {
        MovieManager movieManager = new MovieManager(5);
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(fourth);
        movieManager.add(fifth);

        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = movieManager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMaxLimit() {
        MovieManager movieManager = new MovieManager(10);
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(fourth);
        movieManager.add(fifth);
        movieManager.add(sixth);
        movieManager.add(seventh);
        movieManager.add(eighth);
        movieManager.add(ninth);
        movieManager.add(tenth);
        movieManager.add(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowWithoutParameters() {
        MovieManager movieManager = new MovieManager();
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(fourth);

        Movie[] expected = {fourth, third, second, first};
        Movie[] actual = movieManager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLess() {
        MovieManager movieManager = new MovieManager(4);
        movieManager.add(first);
        movieManager.add(second);

        Movie[] expected = {second, first};
        Movie[] actual = movieManager.getLast();

        assertArrayEquals(expected, actual);
    }
}