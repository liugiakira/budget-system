package ru.liugiakira.budget.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.liugiakira.budget.domains.Report;
import ru.liugiakira.budget.services.ReportService;

/**
 * @author k.yakovleva
 */
@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) { this.reportService = reportService; }

    @GetMapping(path="/report")
    public Report getReportTransaction(@RequestParam(value="from") String from,
                                       @RequestParam(value="to") String to,
                                       @RequestParam(value="accountId", required = false) Long accountId) {
        return reportService.findTransaction(from, to, accountId);
    }
}
