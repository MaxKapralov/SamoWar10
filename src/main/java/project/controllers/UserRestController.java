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
    public ResponseEntity<UserInfo> getUserWithId(@RequestParam("id") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userInfoRepository.findOne(id));
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


    @GetMapping(path = "/checkLogin")
    public ResponseEntity<Void> checkLogin(@RequestParam("login") String login)
    {
        User user = userRepository.findByLogin(login);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/checkEmail")
    public ResponseEntity<Void> checkEmail(@RequestParam("email") String email)
    {
        UserInfo user = userInfoRepository.findByEmail(email);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/checkPesel")
    public ResponseEntity<Void> checkPesel(@RequestParam("pesel") String pesel)
    {
        UserInfo user = userInfoRepository.findByPesel(pesel);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(path = "/checkDrivingLicense")
    public ResponseEntity<Void> checkDrivingLicense(String drivingLicense)
    {
        UserInfo user = userInfoRepository.findByDrivingLicense(drivingLicense);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
