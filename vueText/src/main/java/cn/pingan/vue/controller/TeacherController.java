package cn.pingan.vue.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pingan.vue.api.TeacherApi;
import cn.pingan.vue.entity.TeacherEntity;

/**
 * 教师控制层
 * @ClassName TeacherController
 * @Description 
 * @author yanhuan
 * @Date 2018年2月8日 下午8:36:40
 * @version 1.0.0
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    
    @Autowired TeacherApi teacherApi;
    
    @ResponseBody
    @RequestMapping("queryTeacherData")
    public List<TeacherEntity> queryTeacherData(HttpServletRequest request) throws Exception{
        return teacherApi.queryTeacherData();
    }
}
