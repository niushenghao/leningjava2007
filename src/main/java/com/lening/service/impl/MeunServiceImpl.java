package com.lening.service.impl;

import com.lening.entity.MeunBean;
import com.lening.entity.MeunBeanExample;
import com.lening.mapper.MeunMapper;
import com.lening.service.MeunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/8 16:41
 */
@Service
public class MeunServiceImpl implements MeunService {

    @Resource
    private MeunMapper meunMapper;

    public List<MeunBean> getMeunListByPid(Long pid) {
        MeunBeanExample example = new MeunBeanExample();
        MeunBeanExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        return meunMapper.selectByExample(example);
    }

    public void saveMeun(MeunBean meunBean) {
        if (meunBean!=null){
            if (meunBean.getId()!=null){
                meunMapper.updateByPrimaryKeySelective(meunBean);
            }else {
                meunMapper.insertSelective(meunBean);
            }
        }
    }

    List<Long> ids = new ArrayList<Long>();

    public void deleteMeunById(Long id) {
        /**
         * 按照id等于pid去查询的方法，在service中已经有了，我们可以直接使用吗，当然使用了也没什么大问题，
         * 但是不符合面向对象的设计原则：单一职责原则，开闭原则，接口隔离原则，依赖倒置原则，里氏替换原则
         */
        getMeunListByPidToDelete(id);
        //在这里拿到ids，然后去删除
        for (Long id1 : ids) {
            meunMapper.deleteByPrimaryKey(id1);
        }
    }

    public void getMeunListByPidToDelete(Long pid) {
        ids.add(pid);
        MeunBeanExample example = new MeunBeanExample();
        MeunBeanExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<MeunBean> list = meunMapper.selectByExample(example);
        if (list!=null&&list.size()>=1){
            for (MeunBean bean : list) {
                getMeunListByPidToDelete(bean.getId());
            }
        }
    }
}
