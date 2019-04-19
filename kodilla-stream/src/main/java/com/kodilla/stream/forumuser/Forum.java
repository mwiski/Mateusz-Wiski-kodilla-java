package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Forum {

    private final List<ForumUser> users;

    public Forum(final List<ForumUser> users) {
        this.users = users;
    }

    public List<ForumUser> getUsers() {
        return new ArrayList<>(users);
    }

    public Map<Integer, ForumUser> filterAndCollect() {

        return users.stream()
            .filter(forumUser -> forumUser.getSex() == 'M')
            .filter(forumUser -> forumUser.getBirthDate().isBefore(LocalDate.now().minusYears(20)))
            .filter(forumUser -> forumUser.getPostsNumber() >= 1)
            .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
    }
}
