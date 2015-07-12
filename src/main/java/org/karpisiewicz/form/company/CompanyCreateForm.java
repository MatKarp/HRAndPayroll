package org.karpisiewicz.form.company;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CompanyCreateForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    @Size(min = 1, max = 100)
    String name;
    
}
