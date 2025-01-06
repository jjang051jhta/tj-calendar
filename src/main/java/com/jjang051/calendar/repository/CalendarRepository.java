package com.jjang051.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjang051.calendar.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer>  {

}
