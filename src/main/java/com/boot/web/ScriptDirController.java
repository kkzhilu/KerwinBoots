package com.boot.web;

import com.boot.bean.ScriptDir;
import com.boot.service.ScriptDirServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2019/12/30 10:44
 * description:  ScriptDirController
 * version:      V1.0
 * ******************************
 */
@RestController
public class ScriptDirController {

    @Autowired
    ScriptDirServiceImpl service;

    /**
     * [新增]
     **/
    @RequestMapping("/insert")
    public Object insert(ScriptDir scriptdir){
        return service.insert(scriptdir);
    }

    /**
     * [刪除]
     **/
    @RequestMapping("/delete")
    public int delete(int id){
        return service.delete(id);
    }

    /**
     * [更新]
     * @author 大狼狗
     * @date 2019/12/30
     **/
    @RequestMapping("/update")
    public int update(ScriptDir scriptdir){
        return service.update(scriptdir);
    }

    /**
     * [查询] 根据主键 id 查询
     * @author 大狼狗
     * @date 2019/12/30
     **/
    @RequestMapping("/load")
    public Object load(int id){
        return service.load(id);
    }

    /**
     * [查询] 分页查询
     * @author 大狼狗
     * @date 2019/12/30
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        List<ScriptDir> list = service.pageList(offset, pagesize);

        Map<String, Object> map = new HashMap<>();
        map.put("LIST", list);
        return map;
    }

}
