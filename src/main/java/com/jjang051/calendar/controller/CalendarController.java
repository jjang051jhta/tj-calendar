package com.jjang051.calendar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.entity.Calendar;
import com.jjang051.calendar.service.CalendarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/calendar")
@Slf4j
@RequiredArgsConstructor
public class CalendarController {


  private final CalendarService calendarService;

  @GetMapping("/main")
  public String main() {
      return "/calendar/main";
  }

  @GetMapping("/list")
  @ResponseBody
  public List<CalendarDto> list() {
    //List<CalendarDto> calendarList = new ArrayList<>();
    // CalendarDto calendarDto01 = CalendarDto.builder()
    //                               .id(1)
    //                               .title("할 일 없음")
    //                               .start("2025-01-08 11:00")
    //                               .end("2025-01-10 12:00")
    //                               .build();

    //   CalendarDto calendarDto02 = CalendarDto.builder()
    //                               .id(2)
    //                               .title("할 일 많음")
    //                               .start("2025-01-12 11:00")
    //                               .end("2025-01-18 12:00")
    //                               .build();
    //   calendarList.add(calendarDto01);
    //   calendarList.add(calendarDto02);
       
      List<CalendarDto> calendarList = calendarService.getList();
      return calendarList;
  }
  @PostMapping("/insert")
  @ResponseBody
  public Map<String,String> insert(@RequestBody CalendarDto calendarDto) {
    log.info("calendarDto=={}",calendarDto.toString());
    Calendar savedcalendar = calendarService.insert(calendarDto);
    Map<String,String>  resultMap = new HashMap<>();
    if(savedcalendar!=null) {
      resultMap.put("isInsert", "ok");
    } else {
      resultMap.put("isInsert", "fail");
    }
    return resultMap;
  }

  @PostMapping("/change")
  @ResponseBody
  public Map<String,String> change(@RequestBody CalendarDto calendarDto) {
    log.info("calendarDto=={}",calendarDto.toString());
    Calendar changedCalendar = calendarService.change(calendarDto);
    Map<String,String>  resultMap = new HashMap<>();
    if(changedCalendar!=null) {
      resultMap.put("isChange", "ok");
    } else {
      resultMap.put("isChange", "fail");
    }
    return resultMap;
  }
}
