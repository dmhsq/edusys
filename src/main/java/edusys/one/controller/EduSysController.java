package edusys.one.controller;

import edusys.one.domain.RespBean;
import edusys.one.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 张灿
 * @Time: 2021/1/6 16:30
 */
@CrossOrigin
@RestController
@Api(tags = "接口")
public class EduSysController {

    private final static Logger logger = LoggerFactory.getLogger(EduSysController.class);


    @Autowired
    private QueryService queryService;


    @GetMapping("/find")
    @ApiOperation(value = "按页查找所有信息接口(支持模糊查询)",notes = "接口说明:type类型0为学生1为老师2为考试3为成绩," +
            "查询学生需要userId/userName/grade，" +
            "查询老师需要teacherId/teacherName，" +
            "查询考试需要examName/examDate，" +
            "查询成绩需要examName/userId/classes")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "类型",defaultValue = "0",required = true),
            @ApiImplicitParam(name = "currentPage",value = "当前页",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",defaultValue = "5"),
            @ApiImplicitParam(name = "userId",value = "学号"),
            @ApiImplicitParam(name = "userName",value = "学生姓名"),
            @ApiImplicitParam(name = "teacherId",value = "教师编号"),
            @ApiImplicitParam(name = "teacherName",value = "教师姓名"),
            @ApiImplicitParam(name = "examName",value = "考试名"),
            @ApiImplicitParam(name = "examDate",value = "考试日期"),
            @ApiImplicitParam(name = "classes",value = "班级"),
            @ApiImplicitParam(name = "grade",value = "年级")
    })
    public RespBean Systest(@RequestParam("type") Integer type,
                            @RequestParam(name = "userId",required = false,defaultValue = "") String userId,
                            @RequestParam(name = "userName",required = false,defaultValue = "") String userName,
                            @RequestParam(name = "teacherId",required = false,defaultValue = "") String teacherId,
                            @RequestParam(name = "teacherName",required = false,defaultValue = "") String teacherName,
                            @RequestParam(name = "examName",required = false,defaultValue = "") String examName,
                            @RequestParam(name = "examDate",required = false,defaultValue = "") String examDate,
                            @RequestParam(name = "classes",required = false,defaultValue = "") String classes,
                            @RequestParam(name = "grade",required = false,defaultValue = "") String grade,
                            @RequestParam(name = "currentPage",required = false,defaultValue = "1") Integer currentPage,
                            @RequestParam(name = "pageSize",required = false,defaultValue = "5") Integer pageSize){
        return queryService.find(type,userId,userName,teacherId,teacherName,examName,examDate,classes,grade,currentPage,pageSize);

    }

}
