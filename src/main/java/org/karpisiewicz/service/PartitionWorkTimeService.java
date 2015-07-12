package org.karpisiewicz.service;

import org.karpisiewicz.entity.PartitionWorkTime;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeCreateForm;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeEditForm;

public interface PartitionWorkTimeService{
    
    PartitionWorkTime createPartitionWorkTime(PartitionWorkTimeCreateForm partitionWorkTimeCreateForm, Long partitionWorkTimeId);
    
    PartitionWorkTime editPartitionWorkTime(PartitionWorkTimeEditForm partitionWorkTimeEditForm, Long partitionWorkTimeId);

    PartitionWorkTime getPartitionWorkTime(Long partitionWorkTimeId);
    
    PartitionWorkTime deletePartitionWorkTime(Long partitionWorkTimeId);
        
}
