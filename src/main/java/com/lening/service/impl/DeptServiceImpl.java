package com.lening.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.DeptBean;
import com.lening.entity.DeptBeanExample;
import com.lening.entity.PostBean;
import com.lening.mapper.DeptMapper;
import com.lening.mapper.PostMapper;
import com.lening.service.DeptService;
import com.lening.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创作时间：2021/4/8 9:06
 * 作者： 牛胜浩
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Resource
    private PostMapper postMapper;

    public Page<DeptBean> getDeptListConn(DeptBean deptBean, Integer pageNum, Integer pageSize) {
        //没有默认值的话，这地方容易出现空指针
        PageHelper.startPage(pageNum, pageSize);

        //条件查询
        DeptBeanExample example = new DeptBeanExample();
        DeptBeanExample.Criteria criteria = example.createCriteria();
        //前台是否输入条件
        if(deptBean!=null){
            if(deptBean.getDeptname()!=null&&deptBean.getDeptname().length()>=1){
                criteria.andDeptnameLike("%"+deptBean.getDeptname()+"%");
            }
        }
        List<DeptBean> list = deptMapper.selectByExample(example);
        //分页，pagehelper的分页
        PageInfo pageInfo = new PageInfo(list);
        //总记录数查询出来，类型转换一下，分页助手的long类型，我们要转成Integer类型
        Long total = pageInfo.getTotal();
        //使用我们自己的分页工具类，我们接受的值类型不一样，转化一下
        Page<DeptBean> page = new Page(pageInfo.getPageNum()+"", total.intValue(), pageInfo.getPageSize()+"");
        page.setList(list);
        return page;

    }

    public DeptBean getDeptByDeptid(Long deptid) {
        DeptBean deptBean = deptMapper.selectByPrimaryKey(deptid);
        /**
         * 查询这个部门原来的职位（需要在中间表）
         * 还要查询职位列表（直接使用职位的mapper去查询就OK啦）
         */
        List<PostBean> list = postMapper.selectByExample(null);
        deptBean.setPlist(list);
        Long[] postIds = deptMapper.getDeptPostIds(deptid);
        deptBean.setPostids(postIds);
        return deptBean;
    }

    public void saveDeptPost(Long deptid, Long[] postids) {
        /**
         * 先删除后新增
         */
        deptMapper.depeteDeptPost(deptid);
        if (postids!=null&&postids.length>=1){
            for (Long postid : postids) {
                deptMapper.saveDeptPost(deptid, postid);
            }
        }
    }
}
