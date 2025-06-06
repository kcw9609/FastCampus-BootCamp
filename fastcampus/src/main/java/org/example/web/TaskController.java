package org.example.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Task;
import org.example.persist.entity.TaskStatus;
import org.example.service.TaskService;
import org.example.web.vo.ResultResponse;
import org.example.web.vo.TaskRequest;
import org.example.web.vo.TaskStatusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    /**
     * 새로운 할 일 추가
     * @param req 추가하고자 하는 할 일
     * @return 추가된 할 일
     * */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest req) {
        var result = taskService.add(req.getTitle(), req.getDescription(), req.getDueDate());

        return ResponseEntity.ok(result);
    }
    /**
     *
     * @param
     * @return
     */


    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Optional<String> dueDate) {
        List<Task> result;

        if (dueDate.isPresent()) {
            result = this.taskService.getByDueDate(dueDate.get());

        } else {
            result = this.taskService.getAll();
        }
        return ResponseEntity.ok(result);
    }
    /**
     * 특정 아이디에 해당하는 할일을 조회
     *
     * @param id 할일 ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> fetchOneTask(@PathVariable Long id) {
        var result = this.taskService.getOneById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getByStatus(@PathVariable TaskStatus status) {
        var result = this.taskService.getByStatus(status);
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskRequest task) {
        var result = this.taskService.update(id, task.getTitle(), task.getDescription(), task.getDueDate());
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatusRequest req) {
        var result = this.taskService.updateStatus(id, req.getStatus());
        return ResponseEntity.ok(result);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResultResponse> deleteTask(@PathVariable Long id) {
        var result = this.taskService.deleted(id);

        return ResponseEntity.ok(new ResultResponse(result));
    }

    @GetMapping("/status")
    public ResponseEntity<TaskStatus[]> getAllStatus() {
        var status = TaskStatus.values();
        return ResponseEntity.ok(status);
    }

}
