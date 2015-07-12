package org.karpisiewicz.form.partitionworktime;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.WorkTimeType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartitionWorkTimeEditForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date duration;

    private Date startTime;

    private Date endTime;
    
    private WorkTimeType type;
    
}
