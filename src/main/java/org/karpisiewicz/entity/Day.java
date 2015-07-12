package org.karpisiewicz.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.karpisiewicz.entity.enumerated.DayType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "day")
public class Day implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
   
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DayType type;
    
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Schedule scheduleId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dayId")
    private Collection<WorkTime> workTimeCollection = new ArrayList();

    public Day(Date date, DayType type, Schedule scheduleId) {
        this.date = date;
        this.type = type;
        this.scheduleId = scheduleId;
    }  
}