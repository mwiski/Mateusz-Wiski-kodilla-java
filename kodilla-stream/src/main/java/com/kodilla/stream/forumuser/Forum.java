package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUsersList = new ArrayList<>();

    public Forum() {
        theUsersList.add(new ForumUser(1, "random1", 'M', 1990, 3, 12, 10));
        theUsersList.add(new ForumUser(2, "random2", 'F', 1990, 8, 15, 78));
        theUsersList.add(new ForumUser(3, "random3", 'F', 2004, 1, 1, 5));
        theUsersList.add(new ForumUser(4, "random4", 'M', 2001, 2, 28, 50));
        theUsersList.add(new ForumUser(5, "random5", 'M', 1999, 1, 15, 20));
        theUsersList.add(new ForumUser(6, "random6", 'F', 1999, 3, 1, 0));
        theUsersList.add(new ForumUser(7, "random7", 'M', 1999, 2, 19, 0));
        theUsersList.add(new ForumUser(8, "random8", 'M', 1985, 12, 15, 0));
        theUsersList.add(new ForumUser(9, "random9", 'F', 1993, 9, 27, 118));
        theUsersList.add(new ForumUser(10, "random10", 'M', 1980, 11, 1, 65));
        theUsersList.add(new ForumUser(11, "random11", 'M', 1999, 10, 10, 10));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUsersList);
    }
}
