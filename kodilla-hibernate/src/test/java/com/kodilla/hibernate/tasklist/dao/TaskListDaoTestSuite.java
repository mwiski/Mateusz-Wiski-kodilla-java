package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.tuple;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        String listName = "TEST_LIST";
        String description = "Test: KOD-17.2";
        TaskList taskList = new TaskList(listName, description);
        taskListDao.save(taskList);

        //When
        List<TaskList> found = taskListDao.findByListName(listName);

        // Then
        assertThat(found).extracting(TaskList::getListName, TaskList::getDescription).containsExactly(tuple(listName, description));
        assertThat(found.get(0).getId()).isGreaterThan(0);

        //CleanUp
        taskListDao.deleteById(taskList.getId());
    }
}