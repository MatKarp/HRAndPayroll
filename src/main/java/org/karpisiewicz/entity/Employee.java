package org.karpisiewicz.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")

public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "surname")
    private String surname;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<Contract> contractCollection;
    
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Company companyId;

    public Employee(String name, String surname, Company companyId) {
        this.name = name;
        this.surname = surname;
        this.companyId = companyId;
    }
}
