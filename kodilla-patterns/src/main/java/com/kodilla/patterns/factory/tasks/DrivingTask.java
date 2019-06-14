package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {

    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskExecuted;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {

        isTaskExecuted = true;
        return "Driven to: " + where + ", using: " + using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
