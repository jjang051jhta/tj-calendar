package com.jjang051.calendar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjang051.calendar.dto.CalendarDto;
import com.jjang051.calendar.entity.Calendar;
import com.jjang051.calendar.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalendarService {

  private final CalendarRepository calendarRepository;

  public Calendar insert(CalendarDto calendarDto) {
    log.info("insert calendarDto==={}",calendarDto);
     Calendar calendar = Calendar.builder()
     .startDate(calendarDto.getStart())
     .endDate(calendarDto.getEnd())
     .title(calendarDto.getTitle())
     .allDay(calendarDto.isAllDay())
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

  //영속성
  @Transactional
  public Calendar change(CalendarDto calendarDto) {
    Optional<Calendar> optionalCalendar = calendarRepository.findById(calendarDto.getId());
    Calendar findedCalendar = null;
    log.info("calendarDto==={}",calendarDto);
    if(optionalCalendar.isPresent()) {
      findedCalendar = optionalCalendar.get();
      // Calendar changeCalendar = Calendar.builder()
      //                             .id(calendarDto.getId())
      //                             .startDate(calendarDto.getStart())
      //                             .endDate(calendarDto.getEnd())
      //                             .title(calendarDto.getTitle())
      //                             .allDay(calendarDto.isAllDay())
      //                             .build();
      //return calendarRepository.save(changeCalendar);
      findedCalendar.updateDate(calendarDto.getStart(), calendarDto.getStart());
      return findedCalendar;
    }
    return null;
  }
}
