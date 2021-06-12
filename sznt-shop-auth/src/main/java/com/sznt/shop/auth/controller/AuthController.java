package com.sznt.shop.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证授权控制器
 *
 * @author S Mr.L 
 * @since 2021-06-12
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;



}
