package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.data.UserRegisterForm;
import project.model.data.User;
import project.model.data.UserInfo;
import project.model.repositories.UserInfoRepository;
import project.model.repositories.UserRepository;

@RestController
public class UserRestController {

    private UserRepository userRepository;
    private UserInfoRepository userInfoRepository;


    @Autowired
    public void setUserRepository(UserRepository repository)
    {
        this.userRepository = repository;
    }

    @Autowired
    public void setUserInfoRepository(UserInfoRepository repository)
    {
        this.userInfoRepository = repository;
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfo getUserWithId(@RequestParam("id") Long id)
    {
         return userInfoRepository.findOne(id);
    }

    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody UserRegisterForm form)
    {
        Long id = saveUser(form);
        saveUserInfo(form, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "user")
    public ResponseEntity<Void>deleteUser(@RequestParam("id") Long id)
    {
        userRepository.delete(id);
        userInfoRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/user")
    public ResponseEntity<Void> editUser(@RequestParam("id") Long id, @RequestBody UserInfo user)
    {
        userInfoRepository.edit(user.getName(), user.getSurname(), user.getEmail(), user.getSex(), user.getPesel(), user.getDrivingLicense(), user.getRole(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Long saveUser(UserRegisterForm form)
    {
        User user = new User(form.getLogin(), form.getPassword());
        return userRepository.save(user).getId();

    }

    private void saveUserInfo(UserRegisterForm form, Long id)
    {
        UserInfo user = new UserInfo(id, form.getName(), form.getSurname(), form.getEmail(), form.getSex(), form.getPesel(), form.getDrivingLicense(), form.getRole());
        userInfoRepository.save(user);
    }
}
