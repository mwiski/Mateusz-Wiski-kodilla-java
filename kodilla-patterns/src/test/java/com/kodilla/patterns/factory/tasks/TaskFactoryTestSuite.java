package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testCreateShoppingTask() {
        //Given When
        AbstractTask shoppingTask = taskFactory.createTask(TaskType.SHOPPINGTASK);

        //Then
        Assert.assertEquals("Buy paint", shoppingTask.getTaskName());
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Bought: White Paint, quantity: 2.0", shoppingTask.executeTask());
    }

    @Test
    public void testExecuteShoppingTask() {
        //Given
        AbstractTask shoppingTask = taskFactory.createTask(TaskType.SHOPPINGTASK);

        // When
        shoppingTask.executeTask();

        //Then
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testCreatePaintingTask() {
        //Given When
        AbstractTask paintingTask = taskFactory.createTask(TaskType.PAINTINGTASK);

        //Then
        Assert.assertEquals("Paint wall in the kitchen", paintingTask.getTaskName());
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertEquals("Painted: Wall in the kitchen, color: white", paintingTask.executeTask());
    }

    @Test
    public void testExecutePaintingTask() {
        //Given
        AbstractTask paintingTask = taskFactory.createTask(TaskType.PAINTINGTASK);

        //When
        paintingTask.executeTask();

        //Then
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    public void testCreateDrivingTask() {
        //Given When
        AbstractTask drivingTask = taskFactory.createTask(TaskType.DRIVINGTASK);

        //Then
        Assert.assertEquals("Drive to work", drivingTask.getTaskName());
        Assert.assertFalse(drivingTask.isTaskExecuted());
        Assert.assertEquals("Driven to: work, using: car", drivingTask.executeTask());
    }

    @Test
    public void testExecuteDrivingTask() {
        //Given
        AbstractTask drivingTask = taskFactory.createTask(TaskType.DRIVINGTASK);

        //When
        drivingTask.executeTask();

        //Then
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }
}
