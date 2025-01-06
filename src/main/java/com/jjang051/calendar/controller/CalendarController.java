package com.jjang051.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.calendar.dto.CalendarDto;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
  @GetMapping("/main")
  public String main() {
      return "/calendar/main";
  }

  @GetMapping("/list")
  @ResponseBody
  public List<CalendarDto> list() {
      List<CalendarDto> calendarList =  new ArrayList<>();
      CalendarDto calendarDto01 = CalendarDto.builder()
                                  .id(1)
                                  .title("할 일 없음")
                                  .start("2025-01-08 11:00")
                                  .end("2025-01-10 12:00")
                                  .build();

      CalendarDto calendarDto02 = CalendarDto.builder()
                                  .id(2)
                                  .title("할 일 많음")
                                  .start("2025-01-12 11:00")
                                  .end("2025-01-18 12:00")
                                  .build();
      calendarList.add(calendarDto01);
      calendarList.add(calendarDto02);
      return calendarList;
  }

  
}
