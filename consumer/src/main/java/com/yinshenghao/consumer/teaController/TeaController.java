package com.yinshenghao.consumer.teaController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Teacher;
import com.yinshenghao.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:TeaController
 * Package:com.yinshenghao.consumer.TeaController
 * Description:
 *
 * @Date:2020/2/29 22:22
 * @Author:ysh0806@sina.com
 */
@Controller
public class TeaController {

    @Reference(version = "1.0.0")
    private TeacherService teacherService;

    @GetMapping("/teaWork")
    public String teaWork (HttpSession session) {
        Teacher tea = (Teacher) session.getAttribute("tea");
        if (tea != null) {
            return "teaPage";
        }
        return "teaLogin";
    }

    @PostMapping("/teaLogin")
    public String TeaLogin (Teacher teacher, HttpSession session) {
        Teacher tea = teacherService.findTeacher(teacher);
        if (tea != null && teacher.getTpwd().equals(tea.getTpwd())) {
            session.setAttribute("tea",tea);
            session.setAttribute("username",tea.getTname());
            return "teaPage";
        }
        return "teaLogin";
    }

    @PostMapping("/teaChgPwd")
    public String teaChgPwd (Teacher teacher, String newtpwd) {
        Teacher tea = teacherService.findTeacher(teacher);
        if (tea != null && teacher.getTpwd().equals(tea.getTpwd())) {
            tea.setTpwd(newtpwd);
            int result = teacherService.modifyTpwd(tea);
            if (result == 1) {
                return "index";
            }
            return "chgPwd";
        }
        return "chgPwd";
    }

    @GetMapping("teaFindCourse")
    public String teaFindCourse (Integer curPage, Model model, HttpSession session) {
        Teacher tea = (Teacher) session.getAttribute("tea");
        if (tea != null) {
            if (curPage == null || curPage < 1) {
                curPage = 1;
            }
            int pageSize = 1;
            int total = teacherService.getCourseTotal(tea);
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            if (curPage > totalPages) {
                curPage = totalPages;
            }
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("teacher", tea);
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Course> teaCourses = teacherService.findCourseByPage(paramMap);

            model.addAttribute("teaCourses", teaCourses);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);

            return "teaPage";
        }

        return "teaLogin";
    }
}
