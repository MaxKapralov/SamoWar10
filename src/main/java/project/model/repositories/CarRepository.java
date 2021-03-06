package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.Car;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

    List<Car> findAll();
}
