package com.lening.service;

import com.lening.entity.DeptBean;
import com.lening.utils.Page;

/**
 * @author 牛胜浩
 * @date 2021/4/8 16:25
 */
public interface DeptService {

    Page<DeptBean> getDeptListConn(DeptBean deptBean, Integer pageNum, Integer pageSize);

    DeptBean getDeptByDeptid(Long deptid);

    void saveDeptPost(Long deptid,Long[] postids);

}
