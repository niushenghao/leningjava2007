package com.lening.controller;

import com.lening.entity.DeptBean;
import com.lening.service.DeptService;
import com.lening.utils.Page;
import com.lening.utils.ResultInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 牛胜浩
 * @date 2021/4/8 16:43
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping("/getDeptListConn")
    public Page<DeptBean> getDeptListConn(@RequestBody  DeptBean deptBean, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize){
        return deptService.getDeptListConn(deptBean, pageNum, pageSize);
    }

    @RequestMapping("/getDeptByDeptid")
    public DeptBean getDeptByDeptid(Long deptid){
        return deptService.getDeptByDeptid(deptid);
    }

    @RequestMapping("/saveDeptPost")
    public ResultInfo saveDeptPost(Long deptid,@RequestBody Long[] postids){
        try {
            deptService.saveDeptPost(deptid, postids);
            return new ResultInfo(true, "编辑成功");
        }catch (Exception e){
            return new ResultInfo(false, "编辑失败");
        }
    }
}
