package com.lening.service;

import com.lening.entity.MeunBean;
import com.lening.entity.PostBean;
import com.lening.utils.Page;

import java.util.List;

/**
 * @author 牛胜浩
 * @date 2021/4/8 16:25
 */
public interface PostService {

    Page<PostBean> getPostListConn(PostBean postBean, Integer pageNum, Integer pageSize);

    List<MeunBean> getMeunListById(Long id);

    void savePostMeun(Long postid,Long[] ids);
}
