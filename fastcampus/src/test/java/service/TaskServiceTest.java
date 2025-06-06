package service;

import org.example.persist.TaskRepository;
import org.example.persist.entity.TaskEntity;
import org.example.persist.entity.TaskStatus;
import org.example.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("할 일 추가 기능 테스트")
    void add() {
        var title = "test";
        var description = "test description";
        var dueDate = LocalDate.now();
        // 2. LocalDate -> Date 변환
        Date date = java.sql.Date.valueOf(dueDate);

        when(taskRepository.save(any(TaskEntity.class)))
                .thenAnswer(invocation -> {
                    var e = (TaskEntity)invocation.getArgument(0);
                    e.setId(1L);
                    e.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                    e.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    return e;
                });
        var actual = taskService.add(title, description, dueDate);

        verify(taskRepository, times(1)).save(any());
        assert actual.getId() == 1L;
        assert actual.getTitle().equals(title);
        assert actual.getDescription().equals(description);
        assert actual.getStatus().equals(TaskStatus.TODO);
//        assert actual.getDueDate().equals(date.toString());
        assert actual.getCreatedAt() != null;
        assert actual.getUpdatedAt() != null;

    }

    @Test
    public void findAll() {

    }
}
