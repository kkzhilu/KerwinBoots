package com.boot.controller;

import com.boot.pojo.RootFile;
import com.boot.service.CodeFileImpl;
import com.boot.service.RootFileImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/8/31 14:00
 * description:  CodeFileController 代码相关控制层
 * version:      V1.0
 * ******************************
 */
@Controller
public class CodeFileController {

    @Resource
    RootFileImpl rootFileImpl;

    @Resource
    CodeFileImpl codeFileImpl;

    @RequestMapping("/content")
    public String content(Model model) {
        RootFile rootFile = rootFileImpl.get("4891007c-de49-4ee6-84d5-d69fa26da2b9");


        model.addAttribute("tree", rootFile.getContent());
        model.addAttribute("code", codeFileImpl.get("03f9e09e-a256-42ce-a0a2-61068e93c842").getContent());
        return "content";
    }
}
