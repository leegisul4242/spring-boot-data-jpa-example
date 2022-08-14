package com.springbootdev.examples.controller;

import com.springbootdev.examples.entity.User;
import com.springbootdev.examples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired //
    private UserRepository userRepository;


    @PostMapping("/users")
    public User create(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    //PathVariable은 뭐지?
    //쿼리스트링 하는 것 같긴한데
    @PutMapping("/users/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject)
    {
        User user = userRepository.findOne(userId);
        user.setName(userObject.getName());
        user.setCountry(userObject.getCountry());
        return userRepository.save(user);
    }



    @DeleteMapping("/users/{user_id}")
    public List<User> delete(@PathVariable("user_id") Long userId)
    {
        userRepository.delete(userId);
        return userRepository.findAll();
    }



    @GetMapping("/users/{user_id}")
    @ResponseBody
    public User findByUserId(@PathVariable("user_id") Long userId)
    {
        return userRepository.findOne(userId);
    }
    //메서드 반환타입이 User.
    // 객체변수명.findOne(userId); 하면 user이 나온단거고
    // 따라서, User == "행"레코드
    // User == boardVO 같은거
    // 근데, boardVO는 테이블명이 tbl_review(userId, title, content, sysDate, editDate) 이런거였는데ㅡ
    // 객체명 User로 하면 (자동) 테이블명 User 되는 것같음. -- 안헷갈리나?
}
