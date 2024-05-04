package com.hit.webhomework.controller;

import com.hit.webhomework.domain.ResponseResult;
import com.hit.webhomework.domain.request.LoginRequest;
import com.hit.webhomework.service.EmpService;
import com.hit.webhomework.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Validated LoginRequest loginRequest) {
        return empService.login(loginRequest);
    }

    @PostMapping("/logout")
    public ResponseResult logout() {
        return ResponseResult.ok();
    }
}
