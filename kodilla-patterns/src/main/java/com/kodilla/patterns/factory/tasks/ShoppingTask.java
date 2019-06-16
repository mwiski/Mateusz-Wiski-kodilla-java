package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask extends AbstractTask {

    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        super(taskName);
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public String executeTask() {

        setExecuted(true);
        return "Bought: " + whatToBuy + ", quantity: " + quantity;
    }
}
