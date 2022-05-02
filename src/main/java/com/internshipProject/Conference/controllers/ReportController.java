package com.internshipProject.Conference.controllers;

import com.internshipProject.Conference.models.Report;
import com.internshipProject.Conference.services.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/{id}")
    public  String reportInfo(@PathVariable Long id, Model model){
        model.addAttribute("report", reportService.getReportById(id));
        return "report-info";
    }
    @GetMapping("/")
    public  String reports(@RequestParam(name = "title", required = false) String title, Principal principal, Model model){
        model.addAttribute("reports", reportService.listReports(title));
        model.addAttribute("user", reportService.getUserByPrincipal(principal));
        return "reports";
    }

    @PostMapping("/report/create")
    public String createReport(Report report, Principal principal){
        if((!reportService.listReportsByTime(report.getTime()).isEmpty())&&(roomIsFree(report)))
        {
            return "redirect:/";
        }
        else reportService.saveReport(principal, report);
        return "redirect:/";
    }

    private boolean roomIsFree(Report report)
    {
        boolean isfree = false;
        for (Report element: reportService.listReportsByTime(report.getTime())) {
            if(element.getRoom() == report.getRoom()) {
                isfree= true;
                break;
            }
        }
        return isfree;
    }

    @PostMapping("/report/delete/{id}")
    public String deleteReport(@PathVariable Long id){
        reportService.deleteReport(id);
        return "redirect:/";
    }
}
