package com.kodilla.testing.forum.statistics;

public class StatisticsCollector {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double avgQuantityPostsOnUser;
    private double avgQuantityCommentsOnUser;
    private double avgQuantityCommentsOnPosts;

    public int getUsersQuantity() {
        return usersQuantity;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAvgQuantityPostsOnUser() {
        return avgQuantityPostsOnUser;
    }

    public double getAvgQuantityCommentsOnUser() {
        return avgQuantityCommentsOnUser;
    }

    public double getAvgQuantityCommentsOnPosts() {
        return avgQuantityCommentsOnPosts;
    }

    public void setUsersQuantity(int usersQuantity) {
        this.usersQuantity = usersQuantity;
    }

    public void setPostsQuantity(int postsQuantity) {
        this.postsQuantity = postsQuantity;
    }

    public void setCommentsQuantity(int commentsQuantity) {
        this.commentsQuantity = commentsQuantity;
    }

    public void setAvgQuantityPostsOnUser(double avgQuantityPostsOnUser) {
        this.avgQuantityPostsOnUser = avgQuantityPostsOnUser;
    }

    public void setAvgQuantityCommentsOnUser(double avgQuantityCommentsOnUser) {
        this.avgQuantityCommentsOnUser = avgQuantityCommentsOnUser;
    }

    public void setAvgQuantityCommentsOnPosts(double avgQuantityCommentsOnPosts) {
        this.avgQuantityCommentsOnPosts = avgQuantityCommentsOnPosts;
    }
}