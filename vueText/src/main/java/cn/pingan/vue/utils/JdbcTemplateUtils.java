package cn.pingan.vue.utils;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.pingan.vue.entity.TeacherEntity;

@Repository
public class JdbcTemplateUtils {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateUtils.class);

    /**
     * 新增
     * 
     * @Description
     * @param teacherEntity
     */
    public void insert(TeacherEntity teacherEntity) throws Exception {
        try {
            String sql = "insert into teacher(age,name)values(?,?)";
            Object args[] = {teacherEntity.getAge(), teacherEntity.getName() };
            int temp = jdbcTemplate.update(sql, args);
            if (temp > 0) {
                logger.info("插入成功1！");
            } else {
                logger.info("插入失败");
            }
        } catch (Exception e) {
            logger.error("新增失败", e.getMessage());
            throw e;
        }
    }

    /**
     * 删除
     * 
     * @Description
     * @param id
     */
    public void delete(Integer id) throws Exception {
        try {
            String sql = "delete from teacher where id = ?";
            Object args[] = new Object[] {id };
            int temp = jdbcTemplate.update(sql, args);
            if (temp > 0) {
                logger.info("删除成功");
            } else {
                logger.info("删除失败");
            }
        } catch (Exception e) {
            logger.error("删除失败", e.getMessage());
            throw e;
        }

    }

    /**
     * 更新
     * 
     * @Description
     * @param user
     */
    public void update(TeacherEntity teacher) throws Exception {
        try {
            String sql = "update teacher set name = ?, age = ? where tid = ?";
            Object args[] = new Object[] {teacher.getName(), teacher.getAge(), teacher.getTid() };
            int temp = jdbcTemplate.update(sql, args);
            if (temp > 0) {
                logger.info("更新成功");
            } else {
                logger.info("更新失败");
            }
        } catch (Exception e) {
            logger.error("更新失败", e.getMessage());
            throw e;
        }
    }

    /**
     * 查询
     * 
     * @Description
     * @param id
     * @return
     */
    public List<TeacherEntity>  query(Integer id) throws Exception {
        try {
            String sql = "select * from teacher where tid = ? or ? is null ";
            RowMapper<TeacherEntity> rowMapper = new BeanPropertyRowMapper<>(TeacherEntity.class);
            List<TeacherEntity>  teacherList = jdbcTemplate.query(sql, rowMapper, id, id); 
            return teacherList;
        } catch (Exception e) {
            logger.error("查询失败[{}]", e.getMessage());
            throw e;
        }
    }

}
