package com.example.web;

import com.example.demo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<User> getUserList(){
        System.out.println("getUserList---------");
        return new ArrayList<User>();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="/",method=RequestMethod.POST)
    public String postUer(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = users.get(id);
        return user;
    }
}
