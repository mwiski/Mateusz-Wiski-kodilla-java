package com.kodilla.patterns.factory.tasks;

public final class PaintingTask extends AbstractTask {

    private final String color;
    private final String whatToPaint;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        super(taskName);
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {

        setExecuted(true);
        return "Painted: " + whatToPaint + ", color: " + color;
    }
}
