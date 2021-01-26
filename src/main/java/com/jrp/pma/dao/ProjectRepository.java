package com.jrp.pma.dao;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Type    ,  Id for that type
public interface ProjectRepository  extends CrudRepository<Project, Long>{ // to access data in the database
                                                          // referred as crud repository


    @Override
   public List<Project> findAll();


    @Query(nativeQuery = true,value = "SELECT stage as Label, COUNT(*) as Value " +
            "FROM project " +
            "GROUP BY stage")
    public List<ChartData> projectStatus(); // to store the information from the data base
}
