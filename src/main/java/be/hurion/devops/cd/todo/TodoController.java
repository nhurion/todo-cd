package be.hurion.devops.cd.todo;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("")
    public Iterable<Todo> index() {
        return todoRepository.findAll();
    }

    @PostMapping("")
    public Todo create(@RequestBody Todo todo) {
        todo.setCreatedDate(LocalDate.now());
        return todoRepository.save(todo);
    }

    @GetMapping("search/title/{key}")
    public List<Todo> findByTitle(@PathVariable(name = "key") String key) {
        return todoRepository.findAllByTitleContains(key);
    }

    @PatchMapping("complete/{id}")
    public Todo complete(@PathVariable(name = "id") BigInteger id) {
        final Optional<Todo> todo = todoRepository.findById(id).map(Todo::complete);
        return todoRepository.save(todo.get());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") BigInteger id) {
        todoRepository.deleteById(id);
    }
}
