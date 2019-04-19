package com.kodilla.stream.forumuser;

import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {

    private final int userId;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsNumber;

    public ForumUser(final int userId,
                     final String userName,
                     final char sex,
                     final int yearOfBirth,
                     final int monthOfBirth,
                     final int dayOfBirth,
                     final int postsNumber)
    {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postsNumber = postsNumber;
    }

    public int getUserId() {
        return userId;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return userId == forumUser.userId &&
                sex == forumUser.sex &&
                userName.equals(forumUser.userName) &&
                birthDate.equals(forumUser.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, sex, birthDate);
    }
}
