package com.jjang051.calendar.entity;

import com.jjang051.calendar.dto.CalendarDto;

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
  private String startTime;

  private String endDate;
  private String endTime;

  private String title;

  private Boolean allDay;  //21c 이상에서는 true / false  boolean값 있음 이하 버전에서는 없음

  @Builder
  public Calendar(String startDate, String startTime,String endDate, String endTime,String title, Boolean allDay) {
    this.title=title;
    this.startDate=startDate;
    this.endDate=endDate;
    this.startTime=startTime;
    this.endTime=endTime;
    this.allDay=allDay;
  }

  public static CalendarDto fromEntity(Calendar calendar) {
        return CalendarDto.builder()
                .id(calendar.getId())
                .title(calendar.getTitle())
                .start(calendar.getStartDate()+" "+calendar.getStartTime())
                .startTime(calendar.getStartTime())
                .end(calendar.getEndDate()+" "+calendar.getEndTime())
                .endTime(calendar.getEndTime())
                .allDay(calendar.getAllDay())
                .build();
    }
}
