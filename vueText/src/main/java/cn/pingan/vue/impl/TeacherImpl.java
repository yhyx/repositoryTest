package cn.pingan.vue.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pingan.vue.api.TeacherApi;
import cn.pingan.vue.entity.TeacherEntity;
import cn.pingan.vue.utils.JdbcTemplateUtils;
/**
 * 教师接口实现类
 * @ClassName TeacherImpl
 * @Description 
 * @author yanhuan
 * @Date 2018年2月8日 下午8:35:43
 * @version 1.0.0
 */
@Service
public class TeacherImpl implements TeacherApi{

    @Autowired
    JdbcTemplateUtils jdbcTemplateUtils;
    
    @Override
    public List<TeacherEntity>  queryTeacherData() throws Exception {
        try {
            return jdbcTemplateUtils.query(null);
        } catch (Exception e) {
           throw e;
        }
    }

}
