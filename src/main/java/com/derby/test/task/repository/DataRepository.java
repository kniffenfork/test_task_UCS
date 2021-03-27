package com.derby.test.task.repository;

import com.derby.test.task.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends JpaRepository<DataModel, Long> {
    DataModel findByIdEquals(Long id);
}
