package com.xiao.module;

import com.xiao.dto.User;
import com.xiao.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by xiaogan on 6/9.
 */
@Controller
@RequestMapping("/user")
public class UserModule {

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public ModelAndView index(){
        System.out.print("1------------------------------");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/index");
        return modelAndView;
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<User> userList = userService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/userAll");
        String message = "没有数据啊";
        if (userList.size() < 0) {
            modelAndView.addObject("message", message);
        } else {
            User user = new User();
            user.setUid(12345);
            user.setUname("jcci");
            user.setUage("233");
            modelAndView.addObject(user);
            modelAndView.addObject("userList",userList);
        }
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(String uid,String uname,String uage){
        User user = new User();
        user.setUid(Integer.parseInt(uid));
        user.setUname(uname);
        user.setUage(uage);
        ModelAndView modelAndView = new ModelAndView();
        System.out.print(user.getUage());
        String result = userService.insert(user);
        if ("ok".equals(result)) {
            modelAndView.setViewName("/user/success");
            String message = "插入成功";
            modelAndView.addObject("message",message);
        } else {
            String message = "插入失败";
            modelAndView.addObject("message",message);
        }
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView login(String uid){
        ModelAndView modelAndView = new ModelAndView();
        int uuid = Integer.parseInt(uid);
        String result = userService.delete(uuid);
        if ("ok".equals(result)) {
            modelAndView.setViewName("/user/success");
            String message = "删除成功";
            modelAndView.addObject("message",message);
        } else {
            String message = "删除失败";
            modelAndView.addObject("message",message);
        }
        return modelAndView;
    }
}
