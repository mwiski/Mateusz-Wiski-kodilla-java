package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory = new TaskFactory();
    private Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPINGTASK);
    private Task paintingTask = taskFactory.createTask(TaskFactory.PAINTINGTASK);
    private Task drivingTask = taskFactory.createTask(TaskFactory.DRIVINGTASK);

    @Test
    public void testCreateShoppingTask() {

        //Then
        Assert.assertEquals("Buy paint", shoppingTask.getTaskName());
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Bought: White Paint, quantity: 2.0", shoppingTask.executeTask());
    }

    @Test
    public void testExecuteShoppingTask() {
        //When
        shoppingTask.executeTask();

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreatePaintingTask() {

        //Then
        Assert.assertEquals("Paint wall in the kitchen", paintingTask.getTaskName());
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertEquals("Painted: Wall in the kitchen, color: white", paintingTask.executeTask());
    }

    @Test
    public void testExecutePaintingTask() {
        //When
        shoppingTask.executeTask();

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreateDrivingTask() {

        //Then
        Assert.assertEquals("Drive to work", drivingTask.getTaskName());
        Assert.assertFalse(drivingTask.isTaskExecuted());
        Assert.assertEquals("Driven to: work, using: car", drivingTask.executeTask());
    }

    @Test
    public void testExecuteDrivingTask() {
        //When
        shoppingTask.executeTask();

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }
}
