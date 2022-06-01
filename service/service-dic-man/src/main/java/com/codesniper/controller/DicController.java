package com.codesniper.controller;


import com.codesniper.common.result.Result;
import com.codesniper.service.DicService;
import com.codesniper.yygh.model.dict.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典项Controller
 *
 * @author CodeSniper
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/admin/dic")
@Api(tags = "字典项")
@CrossOrigin
public class DicController {

    @Autowired
    private DicService dicService;

    @ApiOperation("根据id查询子数据")
    @PostMapping("/getChildrenData")
    public Result<List<Dict>> getChildrenData(@RequestBody Dict dict) {
        List<Dict> dictList = dicService.getChildrenData(dict.getId());
        return Result.ok(dictList);
    }
}