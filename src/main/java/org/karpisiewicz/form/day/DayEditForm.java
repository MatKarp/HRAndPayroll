package org.karpisiewicz.form.day;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.DayType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayEditForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    DayType type;
    
}
