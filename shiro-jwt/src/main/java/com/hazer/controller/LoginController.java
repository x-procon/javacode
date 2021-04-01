package com.hazer.controller;

import com.hazer.entity.User;
import com.hazer.model.ResultModel;
import com.hazer.service.UserService;
import com.hazer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


/**
 * @author hazer
 */
@RestController
public class LoginController {


	private final UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public ResultModel<String> login(@RequestParam String username, @RequestParam String password) throws UnsupportedEncodingException {
		User user=userService.findByUsernameAndPassword(username, password);
		Assert.notNull(user,"用户名或密码错误");
		String token= JwtUtil.createToken(user);
		return ResultModel.ok(token,"登陆成功");
	}

	@RequestMapping(path = "/unauthorized/{message}")
	public ResultModel<String> unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
		return ResultModel.fail(message);
	}

}
