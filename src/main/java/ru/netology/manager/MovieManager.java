package ru.netology.manager;

import domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(Movie movie) {
        save(movie);
    }

    public MovieManager() {
        limit = 10;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLast() {
        int resultLength;

        if (movies.length > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }

        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}