package org.karpisiewicz.form.contract;

import org.karpisiewicz.form.company.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.karpisiewicz.entity.enumerated.ContractType;

@Data
public class ContractEditForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    ContractType type;
    
}
