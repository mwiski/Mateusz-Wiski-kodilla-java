package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask extends AbstractTask {

    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        super(taskName);
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {

        executed = true;
        return "Bought: " + whatToBuy + ", quantity: " + quantity;
    }
}
