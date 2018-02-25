package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>{

    UserInfo save(UserInfo info);

}
