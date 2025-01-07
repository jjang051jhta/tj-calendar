package com.jjang051.calendar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CalendarDto {
  private Integer id;
  private String title;
  private String start;

  //private String startTime;
  private String end;

  //private String endTime;

  private boolean allDay;
}
