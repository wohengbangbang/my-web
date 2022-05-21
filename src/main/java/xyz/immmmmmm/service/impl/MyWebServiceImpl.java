package xyz.immmmmmm.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import xyz.immmmmmm.bean.User;
import xyz.immmmmmm.dao.UserDao;
import xyz.immmmmmm.service.MyWebService;

// 让Spring来管理事务
@Transactional
// 表示这是一个Service类，并让SpringBoot管理
@Service
public class MyWebServiceImpl implements MyWebService {

    // 注入UserDao的对象，让Spring管理
        @Autowired
        UserDao userDao;
    /**
     * 登录
     *
     * @param user 传入的是一个User对象
     * @return 返回User对象
     */
    @Override
    public User login(User user) {

        // 创建条件对象
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        
        // 和数据库中的用户名，密码做判断， 密码进行md5加密
        lqw.eq(User::getUsername,user.getUsername());
        lqw.eq(User::getPassword, DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        
        // 传入条件
        return userDao.selectOne(lqw);

    }
}
