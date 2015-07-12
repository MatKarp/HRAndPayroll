package org.karpisiewicz.form.schedule;

import org.karpisiewicz.form.employee.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleEditForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    String name;
    
}
