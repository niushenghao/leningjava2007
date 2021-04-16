package com.lening.controller;

import com.lening.entity.MeunBean;
import com.lening.service.MeunService;
import com.lening.utils.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/8 19:18
 */
@RestController
@RequestMapping("/meun")
public class MeunController {

    @Resource
    private MeunService meunService;

    @RequestMapping("/getMeunListByPid")
    public List<MeunBean> getMeunListByPid(@RequestParam(defaultValue = "1")Long pid){
        return meunService.getMeunListByPid(pid);
    }

    @RequestMapping("/saveMeun")
    public ResultInfo saveMeun(@RequestBody MeunBean meunBean){
        /**
         * 使用递归
         * 1 1 2 3 5 8 13 21
         *         a1=1;
         *         a2=1
         *         a3=a1+a2;
         *         a30
         *
         *         6!=6*5*4*3*2*1
         *         30!的阶乘
         */
        try {
            meunService.saveMeun(meunBean);
            return new ResultInfo(true, "编辑成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(false, "编辑失败");
        }
    }

    @RequestMapping("/deleteMeunById")
    public ResultInfo deleteMeunById(Long id){
        try {
            meunService.deleteMeunById(id);
            return new ResultInfo(true, "删除成功");
        }catch (Exception e){
            return new ResultInfo(false, "删除失败");
        }
    }
}
