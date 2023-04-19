package com.weblab.system.controller;

import com.weblab.common.vo.Result;
import com.weblab.system.entity.Admin;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@RestController
//访问地址的前缀
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @PostMapping("/login")
    public Result<Map<String,Object>> adminLogin(@RequestBody LoginUserVo user){
        Map<String, Object> data = adminService.AdminLogin(user);
        if(data!=null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误!");
    }

    @PutMapping("/Password")
    public Result<Map<String,Object>> changePassword(@RequestBody Admin admin){
        String data = adminService.setPassword(admin);

        if(data==null){
            return Result.fail(20003,"此用户不存在！!");
        }

        return Result.success(data);
    }

}
