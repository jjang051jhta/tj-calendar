package com.jjang051.calendar.entity;

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

  private String allDay;

  @Builder
  public Calendar(String startDate, String startTime,String endDate, String endTime,String title, String allDay) {
    this.title=title;
    this.startDate=startDate;
    this.endDate=endDate;
    this.startTime=startTime;
    this.endTime=endTime;
    this.allDay=allDay;
  }
}
