package com.lening.entityvo;

import com.lening.entity.DeptBean;
import com.lening.entity.UserBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/10 10:54
 */
public class UserVo extends UserBean implements Serializable {

    private Long[] deptids;

    private List<DeptBean> dlist;
}
