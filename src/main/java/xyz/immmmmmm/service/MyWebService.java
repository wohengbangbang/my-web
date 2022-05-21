package xyz.immmmmmm.service;

import xyz.immmmmmm.bean.User;

public interface MyWebService {

    /**
     * 登录
     * @return 返回User对象
     */
    User login(User user);
}
