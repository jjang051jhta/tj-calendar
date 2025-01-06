package com.jjang051.calendar.service;

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
}
