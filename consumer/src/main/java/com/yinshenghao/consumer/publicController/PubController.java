package com.yinshenghao.consumer.publicController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * ClassName:PubController
 * Package:com.yinshenghao.consumer.publicController
 * Description:
 *
 * @Date:2020/2/29 10:31
 * @Author:ysh0806@sina.com
 */
@Controller
public class PubController {

    @GetMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/toChgPwd")
    public String toChgPwd() {
        return "chgPwd";
    }
}
