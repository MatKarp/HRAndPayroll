package org.karpisiewicz.controller;

import javax.validation.Valid;
import org.karpisiewicz.entity.Schedule;
import org.karpisiewicz.form.schedule.ScheduleCreateForm;
import org.karpisiewicz.form.schedule.ScheduleEditForm;
import org.karpisiewicz.form.schedule.ScheduleGetForm;
import org.karpisiewicz.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/schedule", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ScheduleGetForm createSchedule(@Valid @RequestBody ScheduleCreateForm scheduleCreateForm, BindingResult result) throws BindException {

        if(result.hasErrors()){throw new BindException(result);}
        
        Schedule schedule = scheduleService.createSchedule(scheduleCreateForm);
        ScheduleGetForm scheduleGetForm = mapScheduleToScheduleGetForm(schedule);
        return scheduleGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/schedule/{schedule_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ScheduleGetForm editSchedule(@Valid @RequestBody ScheduleEditForm scheduleEditForm, @PathVariable("schedule_id") Long scheduleId, BindingResult result) throws BindException {

        if(result.hasErrors()){throw new BindException(result);}
        
        Schedule schedule = scheduleService.editSchedule(scheduleEditForm, scheduleId);
        ScheduleGetForm scheduleGetForm = mapScheduleToScheduleGetForm(schedule);
        return scheduleGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/schedule/{schedule_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ScheduleGetForm getSchedule(@PathVariable("schedule_id") Long scheduleId) {

        Schedule schedule = scheduleService.getSchedule(scheduleId);
        ScheduleGetForm scheduleGetForm = mapScheduleToScheduleGetForm(schedule);
        return scheduleGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/schedule/{schedule_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    ScheduleGetForm deleteSchedule(@PathVariable("schedule_id") Long scheduleId) {

        Schedule schedule = scheduleService.deleteSchedule(scheduleId);
        ScheduleGetForm scheduleGetForm = mapScheduleToScheduleGetForm(schedule);
        return scheduleGetForm;
    }

    private ScheduleGetForm mapScheduleToScheduleGetForm(Schedule schedule) {

        ScheduleGetForm scheduleGetForm = new ScheduleGetForm(
                schedule.getId(),
                schedule.getName());
        
        return scheduleGetForm;

    }
}
