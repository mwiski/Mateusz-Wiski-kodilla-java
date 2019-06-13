package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Random;

public class LibraryTestSuite {

    private Random random = new Random();

    private Book generateBook() {
        int n = random.nextInt(100000000);
        int date = random.nextInt(12);

        return new Book("title" + n, "author" + n, LocalDate.of(2000 + date, 1 + date, 1 + date));
    }

    @Test
    public void testGetBooks() {
        //Given
        Book potop = new Book("Potop", "Henryk Sienkiewicz", LocalDate.of(1886, 1, 1));

        Library library = new Library("Test library");
        library.getBooks().add(potop);
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());
        library.getBooks().add(generateBook());

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("shallowCopy");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("deepCopy");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        library.getBooks().remove(potop);

        //Then
        Assert.assertEquals(7, library.getBooks().size());
        Assert.assertEquals(7, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(8, deepClonedLibrary.getBooks().size());
        Assert.assertFalse(library.getBooks().contains(potop));
        Assert.assertFalse(shallowClonedLibrary.getBooks().contains(potop));
        Assert.assertTrue(deepClonedLibrary.getBooks().contains(potop));
    }
}
