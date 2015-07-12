package org.karpisiewicz.service.impl;

import org.karpisiewicz.entity.WorkTime;
import org.karpisiewicz.entity.PartitionWorkTime;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeCreateForm;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeEditForm;
import org.karpisiewicz.repository.PartitionWorkTimeRepository;
import org.karpisiewicz.service.WorkTimeService;
import org.karpisiewicz.service.PartitionWorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartitionWorkTimeServiceImpl implements PartitionWorkTimeService {

    @Autowired
    PartitionWorkTimeRepository partitionWorkTimeRepository;
    
    @Autowired
    WorkTimeService workTimeService;

    @Override
    public PartitionWorkTime createPartitionWorkTime(PartitionWorkTimeCreateForm partitionTimeCreateForm, Long workTimeId) {
        
        WorkTime workTime = workTimeService.getWorkTime(workTimeId);
        
        PartitionWorkTime partitionWorkTime = new PartitionWorkTime(
                partitionTimeCreateForm.getDuration(),
                partitionTimeCreateForm.getStartTime(),
                partitionTimeCreateForm.getEndTime(),
                partitionTimeCreateForm.getType(),
                workTime);

        partitionWorkTime = partitionWorkTimeRepository.save(partitionWorkTime);
        
        return partitionWorkTime;
    }

    @Override
    public PartitionWorkTime editPartitionWorkTime(PartitionWorkTimeEditForm partitionWorkTimeEditForm, Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeRepository.findOne(partitionWorkTimeId);

        partitionWorkTime.setDuration(partitionWorkTimeEditForm.getDuration());
        partitionWorkTime.setStartTime(partitionWorkTimeEditForm.getStartTime());
        partitionWorkTime.setEndTime(partitionWorkTimeEditForm.getEndTime());
        partitionWorkTime.setType(partitionWorkTimeEditForm.getType());
        
        partitionWorkTime = partitionWorkTimeRepository.save(partitionWorkTime);
        
        return partitionWorkTime;
    }

    @Override
    public PartitionWorkTime getPartitionWorkTime(Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeRepository.findOne(partitionWorkTimeId);

        return partitionWorkTime;
    }

    @Override
    public PartitionWorkTime deletePartitionWorkTime(Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeRepository.findOne(partitionWorkTimeId);
        partitionWorkTimeRepository.delete(partitionWorkTime);

        return partitionWorkTime;
    }  
}
