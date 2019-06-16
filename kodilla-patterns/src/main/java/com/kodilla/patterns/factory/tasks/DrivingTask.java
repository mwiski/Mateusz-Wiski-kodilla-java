package com.kodilla.patterns.factory.tasks;

public final class DrivingTask extends AbstractTask {

    private final String where;
    private final String using;

    public DrivingTask(String taskName, String where, String using) {
        super(taskName);
        this.where = where;
        this.using = using;
    }

    @Override
    public String executeTask() {

        executed = true;
        return "Driven to: " + where + ", using: " + using;
    }
}
