package xyz.immmmmmm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.immmmmmm.bean.User;
import xyz.immmmmmm.common.R;
import xyz.immmmmmm.service.MyWebService;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
// 这个注解相当于 @Controller + @ResponseBody
@RestController
public class MyWebController {

    @Autowired
    MyWebService myWebService;

    @PostMapping("/login")
    public R login(@RequestBody User user, HttpSession session){

        User login = myWebService.login(user);

        // 把数据存储到session作用域，以便下次请求时使用
        session.setAttribute("login",login);

        // 进行登录判断
        if(login != null){
            return R.success(login);
        }else{
            return R.error("用户名或密码错误！");
        }

    }
}
