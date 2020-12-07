package com.jrp.pma.dao;

import com.jrp.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Type    ,  Id for that type
public interface ProjectRepository  extends CrudRepository<Project, Long>{ // to access data in the database
                                                          // referred as crud repository


    @Override
   public List<Project> findAll();
}
