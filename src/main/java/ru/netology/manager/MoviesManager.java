package ru.netology.manager;

public class MoviesManager {
    private Movies[] movies = new Movies[0];
    private Movies movie;
    private int limit;

    public void add(Movies movie) {
        save(movie);
    }

    public void save(Movies movie) {
        this.movie = movie;
        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] findAll() {
        return movies;
    }

    public MoviesManager(int limit) {
        this.limit = limit;
    }

    public MoviesManager() {
        limit = 10;
    }

    public Movies[] getLast() {
        int resultLength;

        if (movies.length > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }

        Movies[] result = new Movies[resultLength];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}