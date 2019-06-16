package com.kodilla.patterns.factory.tasks;

public final class DrivingTask extends AbstractTask {

    private final String where;
    private final String using;

    public DrivingTask(final String taskName, final String where, final String using) {
        super(taskName);
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {

        setExecuted(true);
        return "Driven to: " + where + ", using: " + using;
    }
}
