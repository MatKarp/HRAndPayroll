package org.karpisiewicz.controller;

import org.karpisiewicz.entity.PartitionWorkTime;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeCreateForm;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeEditForm;
import org.karpisiewicz.form.partitionworktime.PartitionWorkTimeGetForm;
import org.karpisiewicz.service.PartitionWorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping
public class PartitionWorkTimeController {

    @Autowired
    PartitionWorkTimeService partitionWorkTimeService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user/company/employee/contract/work_time/{work_time_id}/partition_work_time", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    PartitionWorkTimeGetForm createPartitionWorkTime(@RequestBody PartitionWorkTimeCreateForm partitionWorkTimeCreateForm, @PathVariable("work_time_id") Long workTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeService.createPartitionWorkTime(partitionWorkTimeCreateForm, workTimeId);
        PartitionWorkTimeGetForm partitionWorkTimeGetForm = mapPartitionWorkTimeToPartitionWorkTimeGetForm(partitionWorkTime);
        return partitionWorkTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/contract/work_time/partition_work_time/{partition_work_time_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    PartitionWorkTimeGetForm editPartitionWorkTime(@RequestBody PartitionWorkTimeEditForm partitionWorkTimeEditForm, @PathVariable("partition_work_time_id") Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeService.editPartitionWorkTime(partitionWorkTimeEditForm, partitionWorkTimeId);
        PartitionWorkTimeGetForm partitionWorkTimeGetForm = mapPartitionWorkTimeToPartitionWorkTimeGetForm(partitionWorkTime);
        return partitionWorkTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/work_time/partition_work_time/{partition_work_time_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    PartitionWorkTimeGetForm getPartitionWorkTime(@PathVariable("partition_work_time_id") Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeService.getPartitionWorkTime(partitionWorkTimeId);
        PartitionWorkTimeGetForm partitionWorkTimeGetForm = mapPartitionWorkTimeToPartitionWorkTimeGetForm(partitionWorkTime);
        return partitionWorkTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/work_time/partition_work_time/{partition_work_time_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    PartitionWorkTimeGetForm deletePartitionWorkTime(@PathVariable("partition_work_time_id") Long partitionWorkTimeId) {

        PartitionWorkTime partitionWorkTime = partitionWorkTimeService.deletePartitionWorkTime(partitionWorkTimeId);
        PartitionWorkTimeGetForm partitionWorkTimeGetForm = mapPartitionWorkTimeToPartitionWorkTimeGetForm(partitionWorkTime);
        return partitionWorkTimeGetForm;
    }

    private PartitionWorkTimeGetForm mapPartitionWorkTimeToPartitionWorkTimeGetForm(PartitionWorkTime partitionWorkTime) {

        PartitionWorkTimeGetForm partitionWorkTimeGetForm = new PartitionWorkTimeGetForm(
                partitionWorkTime.getId(),
                partitionWorkTime.getDuration(),
                partitionWorkTime.getStartTime(),
                partitionWorkTime.getEndTime(),
                partitionWorkTime.getType());
        
        return partitionWorkTimeGetForm;

    }
}
