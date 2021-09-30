package com.online.edu.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.eduservice.entity.query.TeacherQueryConditions;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author HaiShun
 * @since 2021-09-29
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TeacherQueryConditions teacherQuery);
}
