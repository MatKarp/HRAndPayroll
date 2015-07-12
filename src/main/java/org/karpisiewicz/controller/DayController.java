package org.karpisiewicz.controller;

import java.util.List;
import org.karpisiewicz.entity.Day;
import org.karpisiewicz.form.day.DayCreateForm;
import org.karpisiewicz.form.day.DayEditForm;
import org.karpisiewicz.form.day.DayGetForm;
import org.karpisiewicz.service.DayService;
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
@RequestMapping(value = "/schedule")
public class DayController {

    @Autowired
    DayService dayService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/{scheduleId}/day", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    DayGetForm createDay(@RequestBody DayCreateForm dayCreateForm, @PathVariable("scheduleId") Long scheduleId) {

        Day day = dayService.createDay(dayCreateForm, scheduleId);
        DayGetForm dayGetForm = mapDayToDayGetForm(day);
        return dayGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/day/{day_Id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    DayGetForm editDay(@RequestBody DayEditForm dayEditForm, @PathVariable("day_Id") Long dayId) {

        Day day = dayService.editDay(dayEditForm, dayId);
        DayGetForm dayGetForm = mapDayToDayGetForm(day);
        return dayGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/day/{day_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    DayGetForm getDay(@PathVariable("day_id") Long dayId) {

        Day day = dayService.getDay(dayId);
        DayGetForm dayGetForm = mapDayToDayGetForm(day);
        return dayGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/day/{day_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    DayGetForm deleteDay(@PathVariable("day_id") Long dayId) {

        Day day = dayService.deleteDay(dayId);
        DayGetForm dayGetForm = mapDayToDayGetForm(day);
        return dayGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/day/type", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<String> getDayType() {

        List<String> dayTypeList = dayService.getDayType();
        return dayTypeList;
    }

    private DayGetForm mapDayToDayGetForm(Day day) {

        DayGetForm dayGetForm = new DayGetForm(
                day.getId(),
                day.getDate(),
                day.getType());

        return dayGetForm;

    }
}
