package com.alan.api.controller;

import com.alan.api.core.Response.Result;
import com.alan.api.core.Response.ResultGenerator;
import com.alan.api.core.jwt.JwtUtil;
import com.alan.api.model.User;
import com.alan.api.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

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

    @PostMapping("/register")
    public Result register(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultGenerator.genFaildResult(msg);
        }
        this.userService.save(user);
        return this.getToken(user);
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        this.userService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PostMapping("/password")
    public Result validatePassword(@RequestBody User user){
        User oldUser = this.userService.findById(user.getId());
        boolean isValidate = this.userService.verifyPassword(user.getPassword(), oldUser.getPassword());
        return ResultGenerator.genOkResult(isValidate);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        this.userService.update(user);
        return this.getToken(this.userService.findById(user.getId()));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        User user = this.userService.findById(id);
        return ResultGenerator.genOkResult(user);
    }

    @GetMapping("/info")
    public Result info(Principal user) {
        User userDb = this.userService.findDetailByUsername(user.getName());
        return ResultGenerator.genOkResult(userDb);
    }

    @PreAuthorize("hasAuthority('user:list')")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page,size);
        List<User> list = this.userService.findAllUserWithRole();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genOkResult(pageInfo);
    }

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
