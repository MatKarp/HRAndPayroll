package org.karpisiewicz.service;

import org.karpisiewicz.entity.WorkTime;
import org.karpisiewicz.form.worktime.WorkTimeCreateForm;
import org.karpisiewicz.form.worktime.WorkTimeEditForm;

public interface WorkTimeService{
    
    WorkTime createWorkTime(WorkTimeCreateForm workTimeCreateForm, Long contractId, Long dayId);
    
    WorkTime editWorkTime(WorkTimeEditForm workTimeEditForm, Long workTimeId);

    WorkTime getWorkTime(Long workTimeId);
    
    WorkTime deleteWorkTime(Long workTimeId);
        
}
