package com.codesniper.controller.api;

import com.codesniper.common.result.Result;
import com.codesniper.service.DepartmentService;
import com.codesniper.service.HospitalService;
import com.codesniper.yygh.model.hosp.Hospital;
import com.codesniper.yygh.vo.hosp.DepartmentVo;
import com.codesniper.yygh.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 医院前台Controller
 *
 * @author CodeSniper
 * @since 2022/6/28 05:55
 */
@RestController
@RequestMapping("/api/hosp/hospital")
@Api(tags = "医院前台接口")
public class HospitalApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/getHospitalList")
    @ApiOperation("查询医院列表")
    public Result<Page<Hospital>> getHospitalList(@RequestBody HospitalQueryVo hospitalQueryVo) {
        return Result.ok(hospitalService.getHospitalList(hospitalQueryVo));
    }

    @PostMapping("/getHospitalByHosname")
    @ApiOperation("根据医院名称模糊查询")
    public Result<List<Hospital>> getHospitalByHosname(@RequestBody HospitalQueryVo hospitalQueryVo) {
        return Result.ok(hospitalService.getHospitalByHosname(hospitalQueryVo));
    }

    @GetMapping("/getHospitalByHoscode/{hoscode}")
    @ApiOperation("根据医院编号查询科室")
    public Result<List<DepartmentVo>> getHospitalByHoscode(@PathVariable String hoscode) {
        return Result.ok(departmentService.getDepartmentList(hoscode));
    }

    @GetMapping("/getScheduleDetailByHoscode/{hoscode}")
    @ApiOperation("根据医院编号查询预约挂号详情")
    public Result<Map<String, Object>> getScheduleDetailByHoscode(@PathVariable String hoscode) {
        return Result.ok(hospitalService.getScheduleDetailByHoscode(hoscode));
    }
}