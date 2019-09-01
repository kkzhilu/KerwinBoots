package com.boot.controller;

import com.boot.pojo.CodeFile;
import com.boot.pojo.RootFile;
import com.boot.service.CodeFileImpl;
import com.boot.service.RootFileImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping("/*")
    public String list(Model model) {
        List<RootFile> list = rootFileImpl.getRootFiles();
        model.addAttribute("list", list);
        return "listCategory";
    }

    @RequestMapping("/index")
    public String index(Model model, String uuid) {
        RootFile rootFile = rootFileImpl.get(uuid);
        model.addAttribute("tree", rootFile.getContent());
        return "index";
    }

    @RequestMapping("/content")
    public String codeFile(Model model, String uuid) {
        CodeFile codeFile = codeFileImpl.get(uuid);
        if (codeFile != null) {
            model.addAttribute("content", codeFile.getContent());
        } else {
            model.addAttribute("content", "选择文件查看");
        }
        return "content";
    }
}
