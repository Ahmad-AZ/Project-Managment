package com.jrp.pma.dao;


import com.jrp.pma.entities.Project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@SpringBootTest // if our package name is the same like original,we can use SpringBootText annotation
@RunWith(SpringRunner.class) // all integration tests need this
@TestPropertySource(value = "classpath:application-test.properties")
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository proRepo; // will run for H2 database not for postgres

    @Test
    public void ifNewProjectSaved_thenSuccess(){

        Project project= new Project("new test","in progress","class test");
        proRepo.save(project);

      assertEquals(1,proRepo.findAll().size());  //
    }
}
