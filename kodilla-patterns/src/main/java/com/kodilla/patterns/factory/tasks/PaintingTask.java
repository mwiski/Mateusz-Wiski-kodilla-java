package com.kodilla.patterns.factory.tasks;

public final class PaintingTask extends AbstractTask {

    private final String color;
    private final String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        super(taskName);
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {

        executed = true;
        return "Painted: " + whatToPaint + ", color: " + color;
    }
}
