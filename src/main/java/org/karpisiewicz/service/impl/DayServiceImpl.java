package org.karpisiewicz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.karpisiewicz.entity.Day;
import org.karpisiewicz.entity.Schedule;
import org.karpisiewicz.entity.enumerated.DayType;
import org.karpisiewicz.form.day.DayCreateForm;
import org.karpisiewicz.form.day.DayEditForm;
import org.karpisiewicz.repository.DayRepository;
import org.karpisiewicz.service.DayService;
import org.karpisiewicz.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    DayRepository dayRepository;
    
    @Autowired
    ScheduleService scheduleService;

    @Override
    public Day createDay(DayCreateForm dayCreateForm, Long scheduleId) {

        Schedule schedule = scheduleService.getSchedule(scheduleId);
        
        Day day = new Day(
                dayCreateForm.getDate(),
                dayCreateForm.getType(),
                schedule);

        day = dayRepository.save(day);
        
        return day;
    }

    @Override
    public Day editDay(DayEditForm dayEditForm, Long dayId) {

        Day day = dayRepository.findOne(dayId);

        day.setType(dayEditForm.getType());
        
        day = dayRepository.save(day);
        
        return day;
    }

    @Override
    public Day getDay(Long dayId) {

        Day day = dayRepository.findOne(dayId);

        return day;
    }

    @Override
    public Day deleteDay(Long dayId) {

        Day day = dayRepository.findOne(dayId);
        dayRepository.delete(day);

        return day;
    }

    @Override
    public List<String> getDayType() {

        List<String> dayTypeList = new ArrayList(Arrays.asList(DayType.values()));

        return dayTypeList;
    }

   
}
