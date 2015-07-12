package org.karpisiewicz.service.impl;

import org.karpisiewicz.entity.Schedule;
import org.karpisiewicz.form.schedule.ScheduleCreateForm;
import org.karpisiewicz.form.schedule.ScheduleEditForm;
import org.karpisiewicz.repository.ScheduleRepository;
import org.karpisiewicz.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(ScheduleCreateForm scheduleCreateForm) {
        
        Schedule schedule = new Schedule(scheduleCreateForm.getName());
        
        schedule = scheduleRepository.save(schedule);
        
        return schedule;     
    }

    @Override
    public Schedule editSchedule(ScheduleEditForm scheduleEditForm, Long scheduleId) {
        
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        
        schedule.setName(scheduleEditForm.getName());
        
        schedule = scheduleRepository.save(schedule);
        
        return schedule;
    }

    @Override
    public Schedule getSchedule(Long scheduleId) {
        
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        
        return schedule;
    }

    @Override
    public Schedule deleteSchedule(Long scheduleId) {
        
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        
        scheduleRepository.delete(schedule);
        
        return schedule;
    }
      
}
