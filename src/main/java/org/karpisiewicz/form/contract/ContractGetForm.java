package org.karpisiewicz.form.contract;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.ContractType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractGetForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    Long id;
    
    ContractType type;
    
}
