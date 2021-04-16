package com.lening.service;

import com.lening.entity.MeunBean;
import com.lening.entity.UserBean;
import com.lening.utils.Page;

import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/7 20:12
 */
public interface UserService {

    List<UserBean> getUserList();

    List<MeunBean> getMeunList();

    Page<UserBean> getUserListConn(UserBean ub,Integer pageNum,Integer pageSize);

    UserBean getUserVoById(Long id);

    void saveUserDept(Long id,Long[] deptids);

    UserBean getUserInfo(Long id);

    void saveuserPost(UserBean userBean);

    UserBean getLogin(UserBean ub);
}
