package com.dou.serviceuser.controller;
import com.dou.commonutils.util.R;
import com.dou.model.entity.OaPermission;
import com.dou.serviceuser.service.OaPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2022/3/3 18:56
 */
@RestController
@RequestMapping("/user/admin/acl")
public class UserController {

    @Autowired
    private OaPermissionService oaPermissionService;

    @PostMapping("/login")
    public R login(@RequestBody Map<String,String> params){
        String username = params.get("username");
        String password = params.get("password");
        if (username != null && password != null){
            if (username.equals("admin") && password.equals("111111")){
                return R.ok().data("token","admin");
            }
        }
        return R.error();
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

}
