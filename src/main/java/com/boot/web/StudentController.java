package com.boot.web;

import com.boot.pojo.Student;
import com.boot.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/9/16 11:25
 * description:  StudentController
 * version:      V1.0
 * ******************************
 */
@RestController
public class StudentController {

    @Resource
    StudentServiceImpl studentService;

    @RequestMapping("/insert")
    public boolean insert (String name) {
        return studentService.insert(name);
    }

    @RequestMapping("/insertTestTrans")
    public boolean insertTestTrans (String name) throws Exception {
        return studentService.insertTestTrans(name);
    }

    @RequestMapping("/list")
    public List<Student> list () {
        return studentService.list();
    }
}
