package com.kodilla.stream;

import com.google.common.base.Joiner;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    private static List<ForumUser> initUsers() {

        List<ForumUser> users = new ArrayList<>();

        users.add(new ForumUser(1, "random1", 'M', 1990, 3, 12, 10));
        users.add(new ForumUser(2, "random2", 'F', 1990, 8, 15, 78));
        users.add(new ForumUser(3, "random3", 'F', 2004, 1, 1, 5));
        users.add(new ForumUser(4, "random4", 'M', 2001, 2, 28, 50));
        users.add(new ForumUser(5, "random5", 'M', 1999, 1, 15, 20));
        users.add(new ForumUser(6, "random6", 'F', 1999, 3, 1, 0));
        users.add(new ForumUser(7, "random7", 'M', 1999, 2, 19, 0));
        users.add(new ForumUser(8, "random8", 'M', 1985, 12, 15, 0));
        users.add(new ForumUser(9, "random9", 'F', 1993, 9, 27, 118));
        users.add(new ForumUser(10, "random10", 'M', 1980, 11, 1, 65));
        users.add(new ForumUser(11, "random11", 'M', 1999, 10, 10, 10));

        return users;
    }

    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);

        Forum forum = new Forum(initUsers());

        System.out.println(Joiner.on("\n").withKeyValueSeparator(":").join(forum.filterAndCollect()));
    }
}