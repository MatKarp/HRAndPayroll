package org.karpisiewicz.service.impl;

import org.karpisiewicz.entity.Contract;
import org.karpisiewicz.entity.Day;
import org.karpisiewicz.entity.WorkTime;
import org.karpisiewicz.form.worktime.WorkTimeCreateForm;
import org.karpisiewicz.form.worktime.WorkTimeEditForm;
import org.karpisiewicz.repository.WorkTimeRepository;
import org.karpisiewicz.service.ContractService;
import org.karpisiewicz.service.DayService;
import org.karpisiewicz.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    @Autowired
    WorkTimeRepository workTimeRepository;
    
    @Autowired
    ContractService contractService;
    
    @Autowired
    DayService dayService;

    @Override
    public WorkTime createWorkTime(WorkTimeCreateForm workTimeCreateForm, Long contractId, Long dayId) {

        Contract contract = contractService.getContract(contractId);
        
        Day day = dayService.getDay(dayId);
        
        WorkTime workTime = new WorkTime(
                workTimeCreateForm.getDuration(),
                workTimeCreateForm.getStartTime(),
                workTimeCreateForm.getEndTime(), 
                contract,
                day);

        workTime = workTimeRepository.save(workTime);
        
        return workTime;
    }

    @Override
    public WorkTime editWorkTime(WorkTimeEditForm workTimeEditForm, Long workTimeId) {

        WorkTime workTime = workTimeRepository.findOne(workTimeId);

        workTime.setDuration(workTimeEditForm.getDuration());
        workTime.setStartTime(workTimeEditForm.getStartTime());
        workTime.setEndTime(workTimeEditForm.getEndTime());
        
        workTime = workTimeRepository.save(workTime);
        
        return workTime;
    }

    @Override
    public WorkTime getWorkTime(Long workTimeId) {

        WorkTime workTime = workTimeRepository.findOne(workTimeId);

        return workTime;
    }

    @Override
    public WorkTime deleteWorkTime(Long workTimeId) {

        WorkTime workTime = workTimeRepository.findOne(workTimeId);
        workTimeRepository.delete(workTime);

        return workTime;
    }  
}
