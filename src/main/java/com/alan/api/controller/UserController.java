package com.alan.api.controller;

import com.alan.api.core.Response.Result;
import com.alan.api.core.Response.ResultGenerator;
import com.alan.api.core.jwt.JwtUtil;
import com.alan.api.model.User;
import com.alan.api.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author: alan.peng
 * description:
 * date: create in 16:42 2018/11/7
 * modified By：
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User dbUser = null;
        if (user.getUsername() != null) {
            dbUser = this.userService.findDetailBy("username", user.getUsername());
            if (dbUser == null) {
                return ResultGenerator.genFaildResult("username error");
            }
        }

        if(user.getEmail() != null) {
            dbUser = this.userService.findDetailBy("email", user.getEmail());
            if (dbUser == null) {
                return ResultGenerator.genFaildResult("email error");
            }
            user.setUsername(dbUser.getUsername());
        }

        // 验证密码
        if (!this.userService.verifyPassword(user.getPassword(), dbUser.getPassword())) {
            return ResultGenerator.genFaildResult("password error");
        }

        this.userService.updateLoginTimeByUsername(user.getUsername());
        return this.getToken(user);
    }

    private Result getToken(User user){
        String username = user.getUsername();
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        String token = this.jwtUtil.sign(username,userDetails.getAuthorities());
        return ResultGenerator.genOkResult(token);
    }
}
