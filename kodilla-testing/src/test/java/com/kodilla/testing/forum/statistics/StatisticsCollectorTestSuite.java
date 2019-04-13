package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    private List<String> addUsers(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String user = new String("user" + i);
            resultList.add(user);
        }
        return resultList;
    }

    @Test
    public void testCalculateAdvStatisticsWhenZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        int posts = 0;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, collector.getUsersQuantity());
        Assert.assertEquals(0, collector.getPostsQuantity());
        Assert.assertEquals(0, collector.getCommentsQuantity());
        Assert.assertEquals(0.0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0.0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(0.0, collector.getAvgQuantityCommentsOnPosts(), 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenHundredUsersNoPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users;
        users = addUsers(100);
        int posts = 0;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, collector.getUsersQuantity());
        Assert.assertEquals(0, collector.getPostsQuantity());
        Assert.assertEquals(0, collector.getCommentsQuantity());
        Assert.assertEquals(0.0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0.0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(0.0, collector.getAvgQuantityCommentsOnPosts(), 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenZeroUsersWithPostsAndComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        int posts = 50;
        int comments = 50;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, collector.getUsersQuantity());
        Assert.assertEquals(50, collector.getPostsQuantity());
        Assert.assertEquals(50, collector.getCommentsQuantity());
        Assert.assertEquals(0.0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0.0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(1.0, collector.getAvgQuantityCommentsOnPosts(), 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenMorePostsThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users;
        users = addUsers(100);
        int posts = 1000;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, collector.getUsersQuantity());
        Assert.assertEquals(1000, collector.getPostsQuantity());
        Assert.assertEquals(0, collector.getCommentsQuantity());
        Assert.assertEquals(10.0, collector.getAvgQuantityPostsOnUser(), 0.001);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnPosts(), 0);
    }

    @Test
    public void testCalculateAdvStatisticsWhenMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users;
        users = addUsers(100);
        int posts = 1237;
        int comments = 2789;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, collector.getUsersQuantity());
        Assert.assertEquals(1237, collector.getPostsQuantity());
        Assert.assertEquals(2789, collector.getCommentsQuantity());
        Assert.assertEquals(12.37, collector.getAvgQuantityPostsOnUser(), 0.001);
        Assert.assertEquals(27.89, collector.getAvgQuantityCommentsOnUser(), 0.001);
        Assert.assertEquals(2.2546, collector.getAvgQuantityCommentsOnPosts(), 0.0001);
    }

    @Test
    public void testCalculateAdvStatisticsWhenZeroPostButComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users;
        users = addUsers(100);
        int posts = 0;
        int comments = 3;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, collector.getUsersQuantity());
        Assert.assertEquals(0, collector.getPostsQuantity());
        Assert.assertEquals(3, collector.getCommentsQuantity());
        Assert.assertEquals(0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0.03, collector.getAvgQuantityCommentsOnUser(), 0.01);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnPosts(), 0);
    }

    @Test
    public void testShowStatisticsWhenNone() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        int posts = 0;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);
        String expectedOutput = "There is 0 users in our forum.\n"
                + "They have posted 0 posts and 0 comments.\n"
                + "Average quantity of posts on users is: 0.0\n"
                + "Average quantity of comments on users is: 0.0\n"
                + "Average quantity of comments on posts is: 0.0\n";

        //Then
        Assert.assertEquals(0, collector.getUsersQuantity());
        Assert.assertEquals(0, collector.getPostsQuantity());
        Assert.assertEquals(0, collector.getCommentsQuantity());
        Assert.assertEquals(0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnPosts(), 0);
        Assert.assertEquals(expectedOutput, collector.showStatistics());
    }

    @Test
    public void testShowStatisticsWhenStatisticsNotCalculated() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        int posts = 0;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        String expectedOutput = "There is 0 users in our forum.\n"
                + "They have posted 0 posts and 0 comments.\n"
                + "Average quantity of posts on users is: 0.0\n"
                + "Average quantity of comments on users is: 0.0\n"
                + "Average quantity of comments on posts is: 0.0\n";

        //Then
        Assert.assertEquals(0, collector.getUsersQuantity());
        Assert.assertEquals(0, collector.getPostsQuantity());
        Assert.assertEquals(0, collector.getCommentsQuantity());
        Assert.assertEquals(0, collector.getAvgQuantityPostsOnUser(), 0);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnUser(), 0);
        Assert.assertEquals(0, collector.getAvgQuantityCommentsOnPosts(), 0);
        Assert.assertEquals(expectedOutput, collector.showStatistics());
    }

    @Test
    public void testShowStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users;
        users = addUsers(100);
        int posts = 923;
        int comments = 567;
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        StatisticsCollector collector = new StatisticsCollector();

        //When
        collector.calculateAdvStatistics(statisticsMock);
        String expectedOutput = "There is 100 users in our forum.\n"
                + "They have posted 923 posts and 567 comments.\n"
                + "Average quantity of posts on users is: 9.23\n"
                + "Average quantity of comments on users is: 5.67\n"
                + "Average quantity of comments on posts is: 0.61\n";

        //Then
        Assert.assertEquals(100, collector.getUsersQuantity());
        Assert.assertEquals(923, collector.getPostsQuantity());
        Assert.assertEquals(567, collector.getCommentsQuantity());
        Assert.assertEquals(9.23, collector.getAvgQuantityPostsOnUser(), 0.01);
        Assert.assertEquals(5.67, collector.getAvgQuantityCommentsOnUser(), 0.01);
        Assert.assertEquals(0.6143, collector.getAvgQuantityCommentsOnPosts(), 0.0001);
        Assert.assertEquals(expectedOutput, collector.showStatistics());
    }
}