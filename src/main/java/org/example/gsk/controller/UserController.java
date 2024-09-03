package org.example.gsk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.gsk.common.Result;
import org.example.gsk.entity.User;
import org.example.gsk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping("/login")
    public Result<User> Login(@RequestBody User user) {
        //1、将页面提交的密码password进行md5加密处理
       String password = user.getPsd();
       password = DigestUtils.md5DigestAsHex (password.getBytes ());

        //2、根据页面提交的用户名userid查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId,user.getId ());
       User user1=userService.getOne (queryWrapper);
        //3、如果没有查询到则返回登录失败结果
        if(user1==null)
        {
            return Result.error("登录失败");
        }
        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPsd ().equals (user.getPsd ()))
        {
            return Result.error ("登录失败");
        }
        //5、查看状态，如果为已禁用状态，则返回员工已禁用结果
        //6、登录成功，将员工id存入Session并返回登录成功结果
        return Result.success(user1);
    }

}
