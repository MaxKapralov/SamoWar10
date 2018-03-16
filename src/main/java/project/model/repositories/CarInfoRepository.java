package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.CarInfo;

import java.util.List;

@Repository
public interface CarInfoRepository extends CrudRepository<CarInfo, Long>{

    List<CarInfo> findAll();

    CarInfo findByNumber(String number);
}
