package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTestWhenEvenNumberOfBooks() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "A01"));
        books.add(new Book("Dmitrij Głuchowski", "Metro2033", 2005, "A02"));
        books.add(new Book("Henryk Sienkiewicz", "Potop", 1886, "A03"));
        books.add(new Book("Magdalena Kozak", "Nocarz", 2006, "A04"));

        //WhenThen
        assertThat(adapter.publicationYearMedian(books)).isEqualTo(2005);
    }

    @Test
    public void publicationYearMedianTestWhenOddNumberOfBooks() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "A01"));
        books.add(new Book("Dmitrij Głuchowski", "Metro2033", 2005, "A02"));
        books.add(new Book("Henryk Sienkiewicz", "Potop", 1886, "A03"));
        books.add(new Book("Magdalena Kozak", "Nocarz", 2006, "A04"));
        books.add(new Book("Jarosław Grzędowicz", "Pan Lodowego Ogrodu", 2005, "A05"));

        //WhenThen
        assertThat(adapter.publicationYearMedian(books)).isEqualTo(2005);
    }

    @Test
    public void publicationYearMedianTestWhenZeroBooksInSet() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();

        //WhenThen
        assertThat(adapter.publicationYearMedian(books)).isEqualTo(0);
    }
}
