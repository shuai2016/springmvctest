package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReportController {

    @RequestMapping("addReport")
    public String addReport(){
        return "report/addReport";
    }

    @ResponseBody
    @RequestMapping("addReportDo")
    public String addReportDo(@RequestParam("array[]") List<String> list){
        System.out.println(list);
        return "ok";
    }
}
