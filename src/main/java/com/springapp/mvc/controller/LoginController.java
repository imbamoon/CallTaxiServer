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
public class LoginController {

    @RequestMapping(value = "login/user", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> loginUser(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest req, HttpServletResponse rep) throws Exception {

        String username = userInfoEntity.getUsername();
        String password = userInfoEntity.getPwd();
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(username + password);
        UserInfoDao userInfoDao = new UserInfoDao();
        if (userInfoDao.queryUserInfo(username, password)) {
            map.put("result", "yes");
        } else {
            map.put("result", "no");
        }

        return map;
    }

    @RequestMapping(value = "login/driver", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> loginDriver(@RequestBody DriverInfoEntity driverInfoEntity, HttpServletRequest req, HttpServletResponse rep) throws Exception {

        String username = driverInfoEntity.getUsername();
        String password = driverInfoEntity.getPwd();
        Map<String, String> map = new HashMap<String, String>();
        System.out.println(username + password);
        DriverInfoDao driverInfoDao = new DriverInfoDao();
        if (driverInfoDao.queryDriverInfo(username, password)) {
            map.put("result", "yes");
        } else {
            map.put("result", "no");
        }

        return map;
    }
}
