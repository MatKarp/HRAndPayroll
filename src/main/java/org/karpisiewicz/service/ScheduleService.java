package org.karpisiewicz.service;

import org.karpisiewicz.entity.Schedule;
import org.karpisiewicz.form.schedule.ScheduleCreateForm;
import org.karpisiewicz.form.schedule.ScheduleEditForm;

public interface ScheduleService{
    
    Schedule createSchedule(ScheduleCreateForm scheduleCreateForm);
    
    Schedule editSchedule(ScheduleEditForm scheduleEditForm, Long scheduleId);

    Schedule getSchedule(Long scheduleId);
    
    Schedule deleteSchedule(Long scheduleId);
        
}
