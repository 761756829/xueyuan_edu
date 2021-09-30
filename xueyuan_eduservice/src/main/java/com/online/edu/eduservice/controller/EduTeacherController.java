package com.online.edu.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.common.R;
import com.online.edu.eduservice.entity.EduTeacher;
import com.online.edu.eduservice.entity.query.TeacherQueryConditions;
import com.online.edu.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author HaiShun
 * @since 2021-09-29
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("/getAllTeacher")
    public R getAllTeacher() {

        List<EduTeacher> res = eduTeacherService.list(null);
        return R.ok().data("items", res);
    }

    @DeleteMapping("/deleteTeacherById/{id}")
    public boolean deleteTeacherById(@PathVariable("id") String id) {
        boolean res = eduTeacherService.removeById(id);
        return res;
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "分页条件查询讲师列表")
    @PostMapping("/conditions/{page}/{limit}")
    public R pageQuery(@PathVariable Long page,
                       @PathVariable Long limit,
                       @RequestBody(required = false) TeacherQueryConditions teacherQuery) {
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> teacherList = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.ok().data("total", total).data("teacherList", teacherList);
    }

    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {

        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        }
        return R.error();
    }


}

