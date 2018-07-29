package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.Report;

@Controller
public class ReportController {

    @RequestMapping("addReport")
    public String addReport(){
        return "report/addReport";
    }

    @ResponseBody
    @RequestMapping("addReportDo")
    public String addReportDo(@RequestBody Report report){
        System.out.println(report);
        return "ok";
    }
}
