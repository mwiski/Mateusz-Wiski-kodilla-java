package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.addToToDoList("something to do");
        board.addToInProgressList("something in progress");
        board.addToDoneList("something done");

        //Then
        Assert.assertEquals("something to do", board.getToDoListTasks());
        Assert.assertEquals("something in progress", board.getInProgressListTasks());
        Assert.assertEquals("something done", board.getDoneListTasks());
    }
}
