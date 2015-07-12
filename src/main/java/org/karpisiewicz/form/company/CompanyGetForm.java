package org.karpisiewicz.form.company;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGetForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    Long id;
    
    String name;
    
}
