package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import project.model.data.Image;

/**
 * Created by Maksim Kapralov on 5/22/2018.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {

    Image findByIdCar(Long idCar);
}
