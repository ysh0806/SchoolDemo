package com.yinshenghao.consumer.StuController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Student;
import com.yinshenghao.service.StudentService;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:StuController
 * Package:com.yinshenghao.consumer.StuController
 * Description:
 *
 * @Date:2020/2/29 20:45
 * @Author:ysh0806@sina.com
 */
@Controller
public class StuController {

    @Reference(version = "1.0.0")
    private StudentService studentService;

    @GetMapping("/stuWork")
    public String stuWork (HttpSession session) {
        Student stu = (Student) session.getAttribute("stu");
        if (stu != null) {
            return "stuPage";
        }
        return "stuLogin";
    }

    @PostMapping("/stuLogin")
    public String StuLogin (Student student, HttpSession session) {
        Student stu = studentService.findStudent(student);
        if (stu != null && student.getSpwd().equals(stu.getSpwd())) {
            session.setAttribute("stu",stu);
            session.setAttribute("username",stu.getSname());
            return "stuPage";
        }
        return "stuLogin";
    }

    @PostMapping("/stuChgPwd")
    public String stuChgPwd (Student student, String newspwd) {
        Student stu = studentService.findStudent(student);
        if (stu != null && student.getSpwd().equals(stu.getSpwd())) {
            stu.setSpwd(newspwd);
            int result = studentService.modifySpwd(stu);
            if (result == 1) {
                return "index";
            }
            return "chgPwd";
        }
        return "chgPwd";
    }

    @GetMapping("stuFindCourse")
    public String stuFindCourse (Integer curPage, Model model, HttpSession session) {
        Student stu = (Student) session.getAttribute("stu");
        if (stu != null) {
            if (curPage == null || curPage < 1) {
                curPage = 1;
            }
            int pageSize = 1;
            int total = studentService.getCourseTotal(stu);
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            if (curPage > totalPages) {
                curPage = totalPages;
            }
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("student", stu);
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Course> stuCourses = studentService.findCourseByPage(paramMap);

            model.addAttribute("stuCourses", stuCourses);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);

            return "stuPage";
        }

        return "stuLogin";
    }
}
