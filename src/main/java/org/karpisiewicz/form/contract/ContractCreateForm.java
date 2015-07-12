package org.karpisiewicz.form.contract;

import java.io.Serializable;
import lombok.Data;
import org.karpisiewicz.entity.enumerated.ContractType;

@Data
public class ContractCreateForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    ContractType type;
    
}
