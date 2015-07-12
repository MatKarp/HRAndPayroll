package org.karpisiewicz.form.day;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.DayType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayCreateForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    Date date;
    
    DayType type;
    
}
