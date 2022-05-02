package com.internshipProject.Conference.services;

import com.internshipProject.Conference.models.Report;
import com.internshipProject.Conference.models.User;
import com.internshipProject.Conference.repositories.ReportRepository;
import com.internshipProject.Conference.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import  java.util.ArrayList;
import  java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReportService {
    private  final ReportRepository reportRepository;
    private  final UserRepository userRepository;
    public List<Report> listReports(String title) {
        if(title != null)
        {
            return reportRepository.findByTitle(title);
        }
        return reportRepository.findAll();
    }

    public List<Report> listReportsByTime(int time) {
        if(time != 0)
        {
            return reportRepository.findByTime(time);
        }
        return reportRepository.findAll();
    }

    public void saveReport(Principal principal, Report report)
    {
        report.setUser(getUserByPrincipal(principal));
            log.info("Saving new {}", report);
            reportRepository.save(report);
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteReport(Long id)
    {
       reportRepository.deleteById(id);
    }

    public Report getReportById(Long id){
        return  reportRepository.findById(id).orElse(null);
    }

}
