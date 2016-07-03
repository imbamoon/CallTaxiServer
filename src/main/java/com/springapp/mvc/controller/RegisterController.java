package com.springapp.mvc.controller;

import com.springapp.mvc.dao.DriverInfoDao;
import com.springapp.mvc.dao.UserInfoDao;
import com.springapp.mvc.db.entities.DriverInfoEntity;
import com.springapp.mvc.db.entities.UserInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyw on 2016/7/2.
 */
@Controller
@RequestMapping("/")
public class RegisterController {

    @RequestMapping(value = "register/user",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerUser(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest req, HttpServletResponse rep) throws Exception {
        String username = userInfoEntity.getUsername();
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(username);
        UserInfoDao userInfoDao = new UserInfoDao();
        if (userInfoDao.queryUserInfo(username)) {
            map.put("result", "exist");
        } else {
            userInfoDao.addUserInfo(userInfoEntity);
            map.put("result", "success");
        }
        return map;
    }

    @RequestMapping(value = "register/driver",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerDriver(@RequestBody DriverInfoEntity driverInfoEntity, HttpServletRequest req, HttpServletResponse rep) throws Exception {
        String username = driverInfoEntity.getUsername();
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(username);
        DriverInfoDao driverInfoDao = new DriverInfoDao();
        if (driverInfoDao.queryDriverInfo(username)) {
            map.put("result", "exist");
        } else {
            driverInfoDao.addDriverInfo(driverInfoEntity);
            map.put("result", "success");
        }
        return map;
    }
}
