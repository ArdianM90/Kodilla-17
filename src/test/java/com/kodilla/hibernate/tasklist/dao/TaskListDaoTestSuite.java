package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LIST_NAME = "!!!TEST LIST NAME!!!";
    private static final String DESCRIPTION = "!!!TEST DESCRIPTION!!!";

    @Test
    public void testFindByListName() {
        //Given
        TaskList testTaskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListDao.save(testTaskList);
        String listName = testTaskList.getListName();

        //When
        List<TaskList> taskList = taskListDao.findByListName(LIST_NAME);

        //Then
        Assert.assertEquals(LIST_NAME, listName);

        //CleanUp
        int id = taskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}
