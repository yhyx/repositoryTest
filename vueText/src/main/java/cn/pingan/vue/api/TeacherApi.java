package cn.pingan.vue.api;

import java.util.List;

import cn.pingan.vue.entity.TeacherEntity;

/**
 * 教师接口
 * @ClassName TeacherApi
 * @Description 
 * @author yanhuan
 * @Date 2018年2月8日 下午8:35:02
 * @version 1.0.0
 */
public interface TeacherApi {
    
    /**
     * 获取教师信息
     * @Description 
     * @return
     * @throws Exception
     */
    List<TeacherEntity> queryTeacherData() throws Exception;

}
