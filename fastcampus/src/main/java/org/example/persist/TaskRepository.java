package org.example.persist;

import org.example.persist.entity.TaskEntity;
import org.example.persist.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByDueDate(Date date);
    List<TaskEntity> findAllByStatus(TaskStatus status);
}
