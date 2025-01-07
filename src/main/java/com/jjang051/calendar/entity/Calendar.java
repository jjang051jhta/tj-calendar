package com.jjang051.calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjang051.calendar.dto.CalendarDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="table_calendar")
public class Calendar {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;


  private String startDate;

  private String endDate;
  private String title;
  private Boolean allDay;  //21c 이상에서는 true / false  boolean값 있음 이하 버전에서는 없음

  @Builder
  public Calendar(Integer id,String startDate,String endDate,String title, Boolean allDay) {
    this.id = id;
    this.title=title;
    this.startDate=startDate;
    this.endDate=endDate;
    this.allDay=allDay;
  }

  public static CalendarDto fromEntity(Calendar calendar) {
        return CalendarDto.builder()
                .id(calendar.getId())
                .title(calendar.getTitle())
                .start(calendar.getStartDate())
                .end(calendar.getEndDate())
                .allDay(calendar.getAllDay())
                .build();
    }
}
