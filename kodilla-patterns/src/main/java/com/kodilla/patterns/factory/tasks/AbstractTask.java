package com.kodilla.patterns.factory.tasks;

public abstract class AbstractTask implements Task {

    private final String taskName;
    private boolean executed;

    public AbstractTask(final String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskExecuted() {
        return executed;
    }

    void setExecuted(boolean executed) {
        this.executed = executed;
    }
}
