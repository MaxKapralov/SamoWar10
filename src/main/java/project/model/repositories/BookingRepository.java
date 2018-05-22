package project.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.data.Booking;


import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{

    @Query("Select b From Booking b Where b.idUser = :id")
    List<Booking> findWithIdUser(@Param("id") Long id);

    @Query("Select b From Booking b Where b.idCar = :id")
    List<Booking> findWithIdCar(@Param("id") Long id);

    @Query("Select b From Booking b where (b.idUser = :idUser and b.idCar = :idCar)")
    List<Booking> findWithIdCarAndIdUser(@Param("idUser") Long idUser, @Param("idCar") Long idCar);


}
