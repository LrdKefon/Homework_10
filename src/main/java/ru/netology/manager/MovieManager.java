package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int movieQuantity;

    public MovieManager(int movieQuantity) {
        this.movieQuantity = movieQuantity;
    }

    public void add(Movie item) {
        int resultLength = items.length + 1;
        Movie[] tmp = new Movie[resultLength];

        System.arraycopy(items, 0, tmp, 0, items.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getFindAll() {

        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] getFindLast() {
        int resultLength = movieQuantity;
        if (resultLength > items.length) {
            resultLength = items.length;
        }

        Movie[] result = new Movie[resultLength];

        for (int i = 0; i < resultLength; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}