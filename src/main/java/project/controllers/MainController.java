package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.model.data.User;
import project.model.data.UserInfo;
import project.model.repositories.UserInfoRepository;
import project.model.repositories.UserRepository;

@RestController
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @RequestMapping("/")
    public String test()
    {
        User user = new User("maks", "MyPassword1@");
        user = userRepository.save(user);
        UserInfo info = new UserInfo(user.getId(), "Maksim", "Kapralov", "maxkapralov997@gmail.com", "male", null, null, "ROLE_ADMIN");
        userInfoRepository.save(info);
        return "test";
    }
}
