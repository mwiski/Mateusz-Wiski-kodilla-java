package com.kodilla.spring.portfolio;

import java.util.stream.Collectors;

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
        toDoList.getTasks().add(task);
    }

    public void addToInProgressList(String task) {
        inProgressList.getTasks().add(task);
    }

    public void addToDoneList(String task) {
        doneList.getTasks().add(task);
    }

    public String getToDoListTasks() {
        return toDoList.getTasks().stream()
                .collect(Collectors.joining(", "));
    }

    public String getInProgressListTasks() {
        return inProgressList.getTasks().stream()
                .collect(Collectors.joining(", "));    }

    public String getDoneListTasks() {
        return doneList.getTasks().stream()
                .collect(Collectors.joining(", "));    }
}
