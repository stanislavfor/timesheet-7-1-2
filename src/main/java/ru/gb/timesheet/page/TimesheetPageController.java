package ru.gb.timesheet.page;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.timesheet.service.TimesheetPageService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//@Controller
//@RequestMapping("/home/timesheets")
//@RequiredArgsConstructor
//public class TimesheetPageController {
//
//  private final TimesheetPageService service;
//
//  // Метод для получения всех табелей
//  @GetMapping
//  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//  public String getAllTimesheets(Model model) {
//    List<TimesheetPageDto> timesheets = service.findAll();
//    model.addAttribute("timesheets", timesheets);
//    return "timesheets-page.html";
//  }
//
//  // Метод для получения табеля по ID
//  @GetMapping("/{id}")
//  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//  public String getTimesheetPage(@PathVariable Long id, Model model) {
//    Optional<TimesheetPageDto> timesheetOpt = service.findById(id);
//    if (timesheetOpt.isEmpty()) {
//      throw new NoSuchElementException();
//    }
//    model.addAttribute("timesheet", timesheetOpt.get());
//    return "timesheet-page.html";
//  }
//}


@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {

    private final TimesheetPageService service;

    @GetMapping
    public String getAllTimesheets(Model model) {
        List<TimesheetPageDto> timesheets = service.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheets-page.html";
    }

    @GetMapping("/{id}")
    public String getTimesheetPage(@PathVariable Long id, Model model) {
        Optional<TimesheetPageDto> timesheetOpt = service.findById(id);
        if (timesheetOpt.isEmpty()) {
            throw new NoSuchElementException();
        }
        model.addAttribute("timesheet", timesheetOpt.get());
        return "timesheet-page.html";
    }
}