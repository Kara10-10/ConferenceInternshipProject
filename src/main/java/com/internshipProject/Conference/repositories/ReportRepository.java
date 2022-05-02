package com.internshipProject.Conference.repositories;

import com.internshipProject.Conference.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByTitle(String title);

    List<Report> findByTime(int time);
}
