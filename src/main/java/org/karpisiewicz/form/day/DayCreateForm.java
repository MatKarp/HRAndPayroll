package org.karpisiewicz.form.day;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.DayType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayCreateForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @DateTimeFormat(iso = ISO.DATE)
    LocalDate date;
    
    DayType type;
    
}
