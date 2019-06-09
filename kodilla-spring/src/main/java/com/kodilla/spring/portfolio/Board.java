package com.kodilla.spring.portfolio;

public final class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToToDoList(String task) {
        toDoList.addTask(task);
    }

    public void addToInProgressList(String task) {
        inProgressList.addTask(task);
    }

    public void addToDoneList(String task) {
        doneList.addTask(task);
    }

    public String getToDoListTasks() {
        return String.join(", ", toDoList.getTasks());
    }

    public String getInProgressListTasks() {
        return String.join(", ", inProgressList.getTasks());    }

    public String getDoneListTasks() {
        return String.join(", ", doneList.getTasks());    }
}
