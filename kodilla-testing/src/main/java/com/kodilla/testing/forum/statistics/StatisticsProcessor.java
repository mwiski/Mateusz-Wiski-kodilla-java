package com.kodilla.testing.forum.statistics;

public class StatisticsProcessor {

    public StatisticsCollector calculateAdvStatistics(Statistics statistics) {

        StatisticsCollector collector = new StatisticsCollector(0, 0, 0, 0, 0, 0);

        collector.setUsersQuantity(statistics.usersNames().size());
        collector.setPostsQuantity(statistics.postsCount());
        collector.setCommentsQuantity(statistics.commentsCount());

        if (statistics.usersNames().size() != 0) {
            collector.setAvgQuantityPostsOnUser((double) statistics.postsCount() / statistics.usersNames().size());
            collector.setAvgQuantityCommentsOnUser((double) statistics.commentsCount() / statistics.usersNames().size());
        }

        if (statistics.postsCount() != 0) {
            collector.setAvgQuantityCommentsOnPosts((double) statistics.commentsCount() / statistics.postsCount());
        }

        return collector;
    }
}
