package be.hurion.devops.cd.todo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, BigInteger>{


    List<Todo> findAllByTitleContains(String just);
}
