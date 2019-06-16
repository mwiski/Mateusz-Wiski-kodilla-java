package com.kodilla.patterns.factory.tasks;

public abstract class AbstractTask {

    private final String taskName;
    boolean executed;

    public AbstractTask(final String taskName) {
        this.taskName = taskName;
    }

    public abstract String executeTask();

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return executed;
    }
}
