package cn.pingan.vue.entity;

/**
 * 教师实体类
 * @ClassName TeacherEntity
 * @Description 
 * @author yanhuan
 * @Date 2018年2月8日 下午8:38:23
 * @version 1.0.0
 */
public class TeacherEntity {
    
    /*
     * 主键id
     */
    private Integer tid ;
    /*
     * 年龄
     */
    private Integer age ;
    /*
     * 姓名
     */
    private String name ;
    
    public Integer getTid() {
        return tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
