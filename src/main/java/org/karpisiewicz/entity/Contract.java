package org.karpisiewicz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.ContractType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
  
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContractType type;
    
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Schedule scheduleId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractId")
    private Collection<WorkTime> workTimeCollection = new ArrayList();
    
    public Contract(ContractType type, Employee employeeId, Schedule scheduleId) {
        this.type = type;
        this.employeeId = employeeId;
        this.scheduleId = scheduleId;
    }
    
}
