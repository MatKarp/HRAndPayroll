package org.karpisiewicz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.karpisiewicz.entity.enumerated.WorkTimeType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "partition_work_time")
public class PartitionWorkTime implements Serializable {
    
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private WorkTimeType type;

    @JoinColumn(name = "work_time_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private WorkTime workTimeId;

    public PartitionWorkTime(Date duration, Date startTime, Date endTime, WorkTimeType type, WorkTime workTimeId) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.workTimeId = workTimeId;
    }
}
