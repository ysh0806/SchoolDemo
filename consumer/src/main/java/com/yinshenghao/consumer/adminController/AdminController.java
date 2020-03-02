package com.yinshenghao.consumer.adminController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yinshenghao.beans.Admin;
import com.yinshenghao.beans.Class;
import com.yinshenghao.beans.Course;
import com.yinshenghao.beans.Student;
import com.yinshenghao.beans.Teacher;
import com.yinshenghao.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:AdminController
 * Package:com.yinshenghao.consumer.adminController
 * Description:
 *
 * @Date:2020/2/29 11:48
 * @Author:ysh0806@sina.com
 */
@Controller
public class AdminController {

    @Reference(version = "1.0.0")
    private AdminService adminService;

    @GetMapping("/adminWork")
    public String adminWork (HttpSession session) {
        Admin adm = (Admin) session.getAttribute("adm");
        if (adm != null) {
            session.setAttribute("flag",1);
            return "adminPage";
        }
        return "adminLogin";
    }

    @PostMapping("/adminLogin")
    public String adminLogin (Admin admin, HttpSession session) {
        Admin adm = adminService.findAdmin(admin);
        if (adm != null && adm.getApwd().equals(admin.getApwd())) {
            session.setAttribute("adm", adm);
            session.setAttribute("username", adm.getAname());
            session.setAttribute("flag",1);
            return "adminPage";
        }
        return "adminLogin";
    }

    @PostMapping("/adminChgPwd")
    public String adminChgPwd (Admin admin, String newapwd) {
        Admin adm = adminService.findAdmin(admin);
        if (adm != null && adm.getApwd().equals(admin.getApwd())) {
            adm.setApwd(newapwd);
            int result = adminService.modifyAdmin(adm);
            if (result == 1) {
                return "index";
            }
            return "chgPwd";
        }
        return "chgPwd";
    }

    @GetMapping("/findStudents")
    public String findStudents (Integer curPage, Model model, HttpSession session) {
        if (curPage == null || curPage < 1) {
            curPage = 1;
        }
        int pageSize = 1;
        int total = adminService.getStudentsTotal();
        int totalPages = total / pageSize;
        if (total % pageSize > 0) {
            totalPages = totalPages + 1;
        }
        if (curPage > totalPages) {
            curPage = totalPages;
        }
        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<Student> students = adminService.findStudentsByPage(paramMap);

        model.addAttribute("students", students);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        session.setAttribute("flag", 1);

        return "adminPage";
    }

    @GetMapping("/findTeachers")
    public String findTeachers (Integer curPage, Model model, HttpSession session) {
        if (curPage == null || curPage < 1) {
            curPage = 1;
        }
        int pageSize = 1;
        int total = adminService.getTeachersTotal();
        int totalPages = total / pageSize;
        if (total % pageSize > 0) {
            totalPages = totalPages + 1;
        }
        if (curPage > totalPages) {
            curPage = totalPages;
        }
        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<Teacher> teachers = adminService.findTeachersByPage(paramMap);

        model.addAttribute("teachers", teachers);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        session.setAttribute("flag", 2);

        return "adminPage";
    }

    @GetMapping("/findCourses")
    public String findCourses (Integer curPage, Model model, HttpSession session) {
        if (curPage == null || curPage < 1) {
            curPage = 1;
        }
        int pageSize = 1;
        int total = adminService.getCoursesTotal();
        int totalPages = total / pageSize;
        if (total % pageSize > 0) {
            totalPages = totalPages + 1;
        }
        if (curPage > totalPages) {
            curPage = totalPages;
        }
        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<Course> courses = adminService.findCoursesByPage(paramMap);

        model.addAttribute("courses", courses);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        session.setAttribute("flag", 3);

        return "adminPage";
    }

    @GetMapping("/findClasses")
    public String findClasses (Integer curPage, Model model, HttpSession session) {
        if (curPage == null || curPage < 1) {
            curPage = 1;
        }
        int pageSize = 1;
        int total = adminService.getClassesTotal();
        int totalPages = total / pageSize;
        if (total % pageSize > 0) {
            totalPages = totalPages + 1;
        }
        if (curPage > totalPages) {
            curPage = totalPages;
        }
        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<Class> classes = adminService.findClassesByPage(paramMap);

        model.addAttribute("classes", classes);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        session.setAttribute("flag", 4);

        return "adminPage";
    }

    @GetMapping("/findAdmins")
    public String findAdmins (Integer curPage, Model model, HttpSession session) {
        if (curPage == null || curPage < 1) {
            curPage = 1;
        }
        int pageSize = 1;
        int total = adminService.getAdminsTotal();
        int totalPages = total / pageSize;
        if (total % pageSize > 0) {
            totalPages = totalPages + 1;
        }
        if (curPage > totalPages) {
            curPage = totalPages;
        }
        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<Admin> admins = adminService.findAdminsByPage(paramMap);

        model.addAttribute("admins", admins);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        session.setAttribute("flag", 5);

        return "adminPage";
    }

    @GetMapping("/toAddStudent")
    public String toAddStudent () {
        return "addStudent";
    }

    @PostMapping("addStudent")
    public String addStudent (Student student, Model model, HttpSession session) {
        int result = adminService.addStudent(student);
        if (result == 1) {
            int pageSize = 1;
            int total = adminService.getStudentsTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            int curPage = totalPages;
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Student> students = adminService.findStudentsByPage(paramMap);

            model.addAttribute("students", students);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 1);

            return "adminPage";
        }
        return "addStudent";
    }

    @GetMapping("/toAddTeacher")
    public String toAddTeacher () {
        return "addTeacher";
    }

    @PostMapping("addTeacher")
    public String addTeacher (Teacher teacher, Model model, HttpSession session) {
        int result = adminService.addTeacher(teacher);
        if (result == 1) {
            int pageSize = 1;
            int total = adminService.getTeachersTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            int curPage = totalPages;
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Teacher> teachers = adminService.findTeachersByPage(paramMap);

            model.addAttribute("teachers", teachers);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 2);

            return "adminPage";
        }
        return "addTeacher";
    }

    @GetMapping("/toAddCourse")
    public String toAddCourse () {
        return "addCourse";
    }

    @PostMapping("addCourse")
    public String addCourse (Course course, Model model, HttpSession session) {
        int result = adminService.addCourse(course);
        if (result == 1) {
            int pageSize = 1;
            int total = adminService.getCoursesTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            int curPage = totalPages;
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Course> courses = adminService.findCoursesByPage(paramMap);

            model.addAttribute("courses", courses);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 3);

            return "adminPage";
        }
        return "addCourse";
    }

    @GetMapping("/toAddClass")
    public String toAddClass () {
        return "addClass";
    }

    @PostMapping("addClass")
    public String addClass (Class classs, Model model, HttpSession session) {
        int result = adminService.addClass(classs);
        if (result == 1) {
            int pageSize = 1;
            int total = adminService.getClassesTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            int curPage = totalPages;
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Class> classes = adminService.findClassesByPage(paramMap);

            model.addAttribute("classes", classes);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 4);

            return "adminPage";
        }
        return "addClass";
    }

    @GetMapping("/toAddAdmin")
    public String toAddAdmin () {
        return "addAdmin";
    }

    @PostMapping("addAdmin")
    public String addAdmin (Admin admin, Model model, HttpSession session) {
        int result = adminService.addAdmin(admin);
        if (result == 1) {
            int pageSize = 1;
            int total = adminService.getAdminsTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            int curPage = totalPages;
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Admin> admins = adminService.findAdminsByPage(paramMap);

            model.addAttribute("admins", admins);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 5);

            return "adminPage";
        }
        return "addAdmin";
    }

    @GetMapping("/toModifyStudent")
    public String toModifyStudent (Integer sid, Integer curPage, HttpSession session) {
        Student stuMod = new Student();
        stuMod.setSid(sid);
        stuMod = adminService.findStudent(stuMod);
        session.setAttribute("stuMod", stuMod);
        session.setAttribute("curPage", curPage);
        return "modifyStudent";
    }

    @PostMapping("/modifyStudent")
    public String modifyStudent (Student student, Model model, HttpSession session) {
        Student stuMod = (Student) session.getAttribute("stuMod");
        if (stuMod != null) {
            student.setSid(stuMod.getSid());
            int result = adminService.modifyStudent(student);
            Integer curPage = (Integer) session.getAttribute("curPage");
            if (curPage != null && result == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getStudentsTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Student> students = adminService.findStudentsByPage(paramMap);

                model.addAttribute("students", students);
                model.addAttribute("curPage", curPage);
                session.removeAttribute("curPage");
                session.removeAttribute("stuMod");
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 1);
            }
        }
        return "adminPage";
    }

    @GetMapping("/toModifyTeacher")
    public String toModifyTeacher (Integer tid, Integer curPage, HttpSession session) {
        Teacher teaMod = new Teacher();
        teaMod.setTid(tid);
        teaMod = adminService.findTeacher(teaMod);
        session.setAttribute("teaMod", teaMod);
        session.setAttribute("curPage", curPage);
        return "modifyTeacher";
    }

    @PostMapping("/modifyTeacher")
    public String modifyTeacher (Teacher teacher, Model model, HttpSession session) {
        Teacher teaMod = (Teacher) session.getAttribute("teaMod");
        if (teaMod != null) {
            teacher.setTid(teaMod.getTid());
            System.out.println(teacher);
            int result = adminService.modifyTeacher(teacher);
            Integer curPage = (Integer) session.getAttribute("curPage");
            if (curPage != null && result == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getTeachersTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Teacher> teachers = adminService.findTeachersByPage(paramMap);

                model.addAttribute("teachers", teachers);
                model.addAttribute("curPage", curPage);
                session.removeAttribute("curPage");
                session.removeAttribute("teaMod");
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 2);
            }
        }
        return "adminPage";
    }

    @GetMapping("/toModifyCourse")
    public String toModifyCourse (Integer coid, Integer curPage, HttpSession session) {
        Course couMod = new Course();
        couMod.setCoid(coid);
        couMod = adminService.findCourse(couMod);
        session.setAttribute("couMod", couMod);
        session.setAttribute("curPage", curPage);
        return "modifyCourse";
    }

    @PostMapping("/modifyCourse")
    public String modifyCourse (Course course, Model model, HttpSession session) {
        Course couMod = (Course) session.getAttribute("couMod");
        if (couMod != null) {
            course.setCoid(couMod.getCoid());
            int result = adminService.modifyCourse(course);
            Integer curPage = (Integer) session.getAttribute("curPage");
            if (curPage != null && result == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getCoursesTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Course> courses = adminService.findCoursesByPage(paramMap);

                model.addAttribute("courses", courses);
                model.addAttribute("curPage", curPage);
                session.removeAttribute("curPage");
                session.removeAttribute("couMod");
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 3);
            }
        }
        return "adminPage";
    }

    @GetMapping("/toModifyClass")
    public String toModifyClass (Integer clid, Integer curPage, HttpSession session) {
        Class claMod = new Class();
        claMod.setClid(clid);
        claMod = adminService.findClass(claMod);
        session.setAttribute("claMod", claMod);
        session.setAttribute("curPage", curPage);
        return "modifyClass";
    }

    @PostMapping("/modifyClass")
    public String modifyClass (Class classs, Model model, HttpSession session) {
        Class claMod = (Class) session.getAttribute("claMod");
        if (claMod != null) {
            classs.setClid(claMod.getClid());
            int result = adminService.modifyClass(classs);
            Integer curPage = (Integer) session.getAttribute("curPage");
            if (curPage != null && result == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getClassesTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Class> classes = adminService.findClassesByPage(paramMap);

                model.addAttribute("classes", classes);
                model.addAttribute("curPage", curPage);
                session.removeAttribute("curPage");
                session.removeAttribute("claMod");
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 4);
            }
        }
        return "adminPage";
    }

    @GetMapping("/toModifyAdmin")
    public String toModifyAdmin (Integer aid, Integer curPage, HttpSession session) {
        Admin admMod = new Admin();
        admMod.setAid(aid);
        admMod = adminService.findAdmin(admMod);
        session.setAttribute("admMod", admMod);
        session.setAttribute("curPage", curPage);
        return "modifyAdmin";
    }

    @PostMapping("/modifyAdmin")
    public String modifyAdmin (Admin admin, Model model, HttpSession session) {
        Admin admMod = (Admin) session.getAttribute("admMod");
        if (admMod != null) {
            admin.setAid(admMod.getAid());
            int result = adminService.modifyAdmin(admin);
            Integer curPage = (Integer) session.getAttribute("curPage");
            if (curPage != null && result == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getAdminsTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Admin> admins = adminService.findAdminsByPage(paramMap);

                model.addAttribute("admins", admins);
                model.addAttribute("curPage", curPage);
                session.removeAttribute("curPage");
                session.removeAttribute("admMod");
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 5);
            }
        }
        return "adminPage";
    }

    @GetMapping("/removeStudent")
    public String removeStudent (Integer sid, Integer curPage, Model model, HttpSession session) {
        Student stu = new Student();
        stu.setSid(sid);
        if (adminService.removeStudent(stu) == 1) {
            if (curPage < 1) {
                curPage = 1;
            }
            int pageSize = 1;
            int total = adminService.getStudentsTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            if (curPage > totalPages) {
                curPage = totalPages;
            }
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Student> students = adminService.findStudentsByPage(paramMap);

            model.addAttribute("students", students);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 1);
        }
        return "adminPage";
    }

    @GetMapping("/removeTeacher")
    public String removeTeacher (Integer tid, Integer curPage, Model model, HttpSession session) {
        Teacher tea = new Teacher();
        tea.setTid(tid);
        try {
            if (adminService.removeTeacher(tea) == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getTeachersTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Teacher> teachers = adminService.findTeachersByPage(paramMap);

                model.addAttribute("teachers", teachers);
                model.addAttribute("curPage", curPage);
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 2);
            }
            return "adminPage";
        } catch (Exception e) {
            return "rmTeacherErrorPage";
        }
    }

    @GetMapping("/removeCourse")
    public String removeCourse (Integer coid, Integer curPage, Model model, HttpSession session) {
        Course cou = new Course();
        cou.setCoid(coid);
        if (adminService.removeCourse(cou) == 1) {
            if (curPage < 1) {
                curPage = 1;
            }
            int pageSize = 1;
            int total = adminService.getCoursesTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            if (curPage > totalPages) {
                curPage = totalPages;
            }
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Course> courses = adminService.findCoursesByPage(paramMap);

            model.addAttribute("courses", courses);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 3);
        }
        return "adminPage";
    }

    @GetMapping("/removeClass")
    public String removeClass (Integer clid, Integer curPage, Model model, HttpSession session) {
        Class cla = new Class();
        cla.setClid(clid);
        try {
            if (adminService.removeClass(cla) == 1) {
                if (curPage < 1) {
                    curPage = 1;
                }
                int pageSize = 1;
                int total = adminService.getClassesTotal();
                int totalPages = total / pageSize;
                if (total % pageSize > 0) {
                    totalPages = totalPages + 1;
                }
                if (curPage > totalPages) {
                    curPage = totalPages;
                }
                int startRow = (curPage - 1) * pageSize;

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("startRow", startRow);
                paramMap.put("pageSize", pageSize);
                List<Class> classes = adminService.findClassesByPage(paramMap);

                model.addAttribute("classes", classes);
                model.addAttribute("curPage", curPage);
                model.addAttribute("totalPages", totalPages);
                session.setAttribute("flag", 4);
            }
            return "adminPage";
        } catch (Exception e) {
            return "rmClassErrorPage";
        }
    }

    @GetMapping("/removeAdmin")
    public String removeAdmin (Integer aid, Integer curPage, Model model, HttpSession session) {
        Admin adm = new Admin();
        adm.setAid(aid);
        if (adminService.removeAdmin(adm) == 1) {
            if (curPage < 1) {
                curPage = 1;
            }
            int pageSize = 1;
            int total = adminService.getAdminsTotal();
            int totalPages = total / pageSize;
            if (total % pageSize > 0) {
                totalPages = totalPages + 1;
            }
            if (curPage > totalPages) {
                curPage = totalPages;
            }
            int startRow = (curPage - 1) * pageSize;

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("startRow", startRow);
            paramMap.put("pageSize", pageSize);
            List<Admin> admins = adminService.findAdminsByPage(paramMap);

            model.addAttribute("admins", admins);
            model.addAttribute("curPage", curPage);
            model.addAttribute("totalPages", totalPages);
            session.setAttribute("flag", 5);
        }
        return "adminPage";
    }
}
