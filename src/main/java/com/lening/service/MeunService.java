package com.lening.service;

import com.lening.entity.MeunBean;

import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/8 16:25
 */
public interface MeunService {

    List<MeunBean> getMeunListByPid(Long pid);

    void saveMeun(MeunBean meunBean);

    void deleteMeunById(Long id);

    void getMeunListByPidToDelete(Long pid);

}

