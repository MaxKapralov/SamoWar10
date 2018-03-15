package project.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.data.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{

    @Query("Update UserInfo set name = :name, surname = :surname, email = :email, sex = :sex, pesel = :pesel, drivingLicense = :drivingLicense, role = :role Where id = :id")
    UserInfo edit(@Param("name")String name,@Param("surname") String surname, @Param("email") String email, @Param("sex") String sex,
                  @Param("pesel") String pesel, @Param("drivingLicense") String drivingLicense, @Param("role") String role, @Param("id") Long id);

}
