package com.jjang051.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
  @GetMapping("/main")
  public String main() {
      return "/calendar/main";
  }
}
