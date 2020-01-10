package com.boot.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.bean.ScriptDir;
import com.boot.common.ApiResult;
import com.boot.common.PageList;
import com.boot.common.ResultCode;
import com.boot.service.ScriptDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
@Controller
@RequestMapping("/scriptDir")
public class ScriptDirController {

    @Autowired
    ScriptDirService service;

    /**
     * 具体字段请根据实际情况处理
     * 参数请求报文:
     *
     * {
     *   "eid": 9999,
     *   "projectid": 999,
     *   "parentDirId": 999
     * }
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public ApiResult insert (@RequestBody ScriptDir scriptDir, HttpServletRequest request) {
        int affectRows = service.insert(scriptDir);
        return new ApiResult<>(ResultCode.success.getCode(), affectRows, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /**
     * 参数请求报文:
     *
     * [
     *     {
     *         "eid": 9999,
     *         "projectid": 999,
     *         "parentDirId": 999,
     *         "scriptDirName": "sdasd"
     *     },
     *     {
     *         "eid": 9999,
     *         "projectid": 999,
     *         "parentDirId": 999,
     *         "scriptDirName": "sdasd"
     *     }
     * ]
     */
    @RequestMapping(value = "/batchInsert")
    @ResponseBody
    public ApiResult batchInsert (@RequestBody List<ScriptDir> list, HttpServletRequest request) {
        int affectRows = service.batchInsert(list);
        return new ApiResult<>(ResultCode.success.getCode(), affectRows, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /**
     * 参数请求报文:
     *
     * {
     *   "eid": 9999,
     *   "projectid": 999,
     *   "parentDirId": 999
     * }
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public ApiResult update (@RequestBody ScriptDir scriptDir, HttpServletRequest request) {
        int affectRows = service.update(scriptDir);
        return new ApiResult<>(ResultCode.success.getCode(), affectRows, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /**
     * 参数请求报文:
     *
     * {
     *   "key":1
     * }
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public ApiResult delete (@RequestBody Object key, HttpServletRequest request) {
        int affectRows = service.delete(key);
        return new ApiResult<>(ResultCode.success.getCode(), affectRows, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /**
     * 参数请求报文:
     *
     * [
     *     9,
     *     11
     * ]
     */
    @RequestMapping(value = "/batchDelete")
    @ResponseBody
    public ApiResult batchDelete (@RequestBody List<Object> keys, HttpServletRequest request) {
        int affectRows = service.batchDelete(keys);
        return new ApiResult<>(ResultCode.success.getCode(), affectRows, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /**
     * 参数请求报文:
     *
     * {
     *   "key":1
     * }
     */
    @RequestMapping(value = "/selectByKey")
    @ResponseBody
    public ApiResult selectByKey (@RequestBody Object key, HttpServletRequest request) {
        ScriptDir scriptDir = service.selectByKey(key);
        return new ApiResult<>(ResultCode.success.getCode(), scriptDir, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /***
     * 参数请求报文:
     *
     * {
     *   "eid": 9999,
     *   "projectid": 999,
     *   "parentDirId": 999
     * }
     */
    @RequestMapping(value = "/selectList")
    @ResponseBody
    public ApiResult selectList (@RequestBody ScriptDir scriptDir, HttpServletRequest request) {
        List<ScriptDir> result = service.selectList(scriptDir);
        return new ApiResult<>(ResultCode.success.getCode(), result, ResultCode.success.getDescr(), request.getRequestURI());
    }

    /***
     * 参数请求报文:
     *
     * {
     *     "eid": 1,
     *     "page": 1,
     *     "pageSize": 15
     * }
     */
    @RequestMapping(value = "/selectPage")
    @ResponseBody
    public ApiResult selectPage (@RequestBody JSONObject object,
                                 HttpServletRequest request) {

        Integer page     = (Integer) object.getOrDefault("page"    , 1);
        Integer pageSize = (Integer) object.getOrDefault("pageSize", 15);

        // 剔除page, pageSize参数
        object.remove("page");
        object.remove("pageSize");

        ScriptDir scriptDir = object.toJavaObject(ScriptDir.class);
        PageList<ScriptDir> pageList = service.selectPage(scriptDir, page, pageSize);
        return new ApiResult<>(ResultCode.success.getCode(), pageList, ResultCode.success.getDescr(), request.getRequestURI());
    }
}
