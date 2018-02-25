package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.CarInfo;

@Repository
public interface CarInfoRepository extends CrudRepository<CarInfo, Long>{

    CarInfo save(CarInfo carInfo);

}
