package org.karpisiewicz.service;

import java.util.List;
import org.karpisiewicz.entity.Day;
import org.karpisiewicz.form.day.DayCreateForm;
import org.karpisiewicz.form.day.DayEditForm;

public interface DayService {
    
    Day createDay(DayCreateForm dayCreateForm, Long scheduleId);
            
    Day editDay(DayEditForm dayEditForm, Long dayId);
    
    Day getDay(Long dayId);
    
    Day deleteDay(Long dayId);
    
    List<String> getDayType();
            
}
