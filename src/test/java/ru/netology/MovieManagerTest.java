package ru.netology;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    public void shouldAdd() {
        MovieManager manager = new MovieManager(5);
        Movie first = new Movie(1, "1", "Бладшот", "боевик");
        Movie second = new Movie(2, "2", "Вперед", "мультфильм");
        Movie third = new Movie(3, "3", "Отель /Белград/'", "комедия");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.getFindAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmpty() {
        MovieManager manager = new MovieManager(5);
        Movie[] actual = manager.getFindAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMovieQuantity() {

        MovieManager manager = new MovieManager(3);
        Movie first = new Movie(1, "1", "Бладшот", "боевик");
        Movie second = new Movie(2, "2", "Вперед", "мультфильм");
        Movie third = new Movie(3, "3", "Отель '/Белград/'", "комедия");
        Movie fourth = new Movie(4, "4", "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "5", "Человек-невидимка", "ужасы");


        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);


        Movie[] actual = manager.getFindLast();
        Movie[] expected = new Movie[]{fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoMovie() {
        MovieManager manager = new MovieManager(5);
        Movie[] actual = manager.getFindLast();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }
}