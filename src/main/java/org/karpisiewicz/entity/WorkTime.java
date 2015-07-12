package org.karpisiewicz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "work_time")
public class WorkTime implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @Column(name = "duration")
    @Temporal(TemporalType.TIME)
    private Date duration;

    
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;

    
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;

    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contract contractId;

    @JoinColumn(name = "day_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Day dayId;
    
    public WorkTime(Date duration, Date startTime, Date endTime, Contract contractId, Day dayId) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.contractId = contractId;
        this.dayId = dayId;
    }
}
