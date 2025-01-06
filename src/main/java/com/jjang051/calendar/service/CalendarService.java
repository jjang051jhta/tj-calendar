package com.jjang051.calendar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.entity.Calendar;
import com.jjang051.calendar.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalendarService {

  private final CalendarRepository calendarRepository;

  public Calendar insert(CalendarDto calendarDto) {
     Calendar calendar = Calendar.builder()
     .startDate(calendarDto.getStart())
     .endDate(calendarDto.getEnd())
     .startTime(calendarDto.getStartTime())
     .endTime(calendarDto.getEndTime())
     .title(calendarDto.getTitle())
     .allDay(calendarDto.getAllDay())
     .build();
    Calendar savedCalendar = calendarRepository.save(calendar);
    return savedCalendar;
  }

  public List<CalendarDto> getList() {
    List<Calendar> calendarList = calendarRepository.findAll();
    List<CalendarDto> calendarDtoList = new ArrayList<>();
    calendarList.forEach(cL -> {
      calendarDtoList.add(Calendar.fromEntity(cL));
    });
    return calendarDtoList;
  }
}
