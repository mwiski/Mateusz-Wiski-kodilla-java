package com.kodilla.testing.forum.statistics;

import java.util.List;

public class StatisticsCollector {

    private List<String> usersNames;
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

    public void calculateAdvStatistics(Statistics statistics) {

        usersNames = statistics.usersNames();
        usersQuantity = usersNames.size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();

        if (usersQuantity == 0) {
            avgQuantityPostsOnUser = Double.NaN;
            avgQuantityCommentsOnUser = Double.NaN;
        } else {
            avgQuantityPostsOnUser = (double) postsQuantity / usersQuantity;
            avgQuantityCommentsOnUser = (double) commentsQuantity / usersQuantity;
        }

        if (postsQuantity == 0) {
            avgQuantityCommentsOnPosts = Double.NaN;
        } else {
            avgQuantityCommentsOnPosts = (double) commentsQuantity / postsQuantity;
        }
    }
}