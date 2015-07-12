package org.karpisiewicz.controller;

import org.karpisiewicz.entity.WorkTime;
import org.karpisiewicz.form.worktime.WorkTimeCreateForm;
import org.karpisiewicz.form.worktime.WorkTimeEditForm;
import org.karpisiewicz.form.worktime.WorkTimeGetForm;
import org.karpisiewicz.service.WorkTimeService;
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
public class WorkTimeController {

    @Autowired
    WorkTimeService workTimeService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user/company/employee/contract/{contract_id}/work_time/day/{day_id}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    WorkTimeGetForm createWorkTime(@RequestBody WorkTimeCreateForm workTimeCreateForm, @PathVariable("contract_id") Long contractId, @PathVariable("day_id") Long dayId) {

        WorkTime workTime = workTimeService.createWorkTime(workTimeCreateForm, contractId, dayId);
        WorkTimeGetForm workTimeGetForm = mapWorkTimeToWorkTimeGetForm(workTime);
        return workTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/contract/work_time/{worktime_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    WorkTimeGetForm editWorkTime(@RequestBody WorkTimeEditForm workTimeEditForm, @PathVariable Long workTimeId) {

        WorkTime workTime = workTimeService.editWorkTime(workTimeEditForm, workTimeId);
        WorkTimeGetForm workTimeGetForm = mapWorkTimeToWorkTimeGetForm(workTime);
        return workTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/work_time{work_time_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    WorkTimeGetForm getWorkTime(@PathVariable Long workTimeId) {

        WorkTime workTime = workTimeService.getWorkTime(workTimeId);
        WorkTimeGetForm workTimeGetForm = mapWorkTimeToWorkTimeGetForm(workTime);
        return workTimeGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/work_time/{work_time_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    WorkTimeGetForm deleteWorkTime(@PathVariable Long workTimeId) {

        WorkTime workTime = workTimeService.deleteWorkTime(workTimeId);
        WorkTimeGetForm workTimeGetForm = mapWorkTimeToWorkTimeGetForm(workTime);
        return workTimeGetForm;
    }

    private WorkTimeGetForm mapWorkTimeToWorkTimeGetForm(WorkTime workTime) {

        WorkTimeGetForm workTimeGetForm = new WorkTimeGetForm(
                workTime.getId(),
                workTime.getDuration(),
                workTime.getStartTime(),
                workTime.getEndTime());
        
        return workTimeGetForm;

    }
}
