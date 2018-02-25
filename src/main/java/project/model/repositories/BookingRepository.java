package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{

    Booking save(Booking book);

}
