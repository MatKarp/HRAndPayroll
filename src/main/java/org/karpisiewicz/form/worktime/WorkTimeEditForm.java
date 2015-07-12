package org.karpisiewicz.form.worktime;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkTimeEditForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date duration;

    private Date startTime;

    private Date endTime;
    
}
