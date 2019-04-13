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

        if (usersQuantity > 0) {
            avgQuantityPostsOnUser = (double) postsQuantity / usersQuantity;
            avgQuantityCommentsOnUser = (double) commentsQuantity / usersQuantity;
        }

        if (postsQuantity > 0)
            avgQuantityCommentsOnPosts = (double) commentsQuantity / postsQuantity;
    }

    public double roundTo2(double value) {

        value = ((double)((int)(value *100.0)))/100.0;
        return value;
    }

    public String showStatistics() {

        return "There is " + usersQuantity + " users in our forum.\n"
                + "They have posted " + postsQuantity + " posts and " + commentsQuantity + " comments.\n"
                + "Average quantity of posts on users is: " + roundTo2(avgQuantityPostsOnUser) + "\n"
                + "Average quantity of comments on users is: " + roundTo2(avgQuantityCommentsOnUser) + "\n"
                + "Average quantity of comments on posts is: " + roundTo2(avgQuantityCommentsOnPosts) + "\n";
    }
}