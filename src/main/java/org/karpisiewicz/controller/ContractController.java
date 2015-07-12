package org.karpisiewicz.controller;

import org.karpisiewicz.entity.Contract;
import org.karpisiewicz.form.contract.ContractCreateForm;
import org.karpisiewicz.form.contract.ContractEditForm;
import org.karpisiewicz.form.contract.ContractGetForm;
import org.karpisiewicz.service.ContractService;
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
public class ContractController {

    @Autowired
    ContractService contractService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/user/company/employee/{employee_id}/contract/schedule/{schedule_id}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ContractGetForm createContract(@RequestBody ContractCreateForm contractCreateForm, @PathVariable("employee_id") Long employeeId, @PathVariable("schedule_id") Long scheduleId) {

        Contract contract = contractService.createContract(contractCreateForm, employeeId, scheduleId);
        ContractGetForm contractGetForm = mapContractToContractGetForm(contract);
        return contractGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/contract/{contract_id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ContractGetForm editContract(@RequestBody ContractEditForm contractEditForm, @PathVariable("contract_id") Long contractId) {

        Contract contract = contractService.editContract(contractEditForm, contractId);
        ContractGetForm contractGetForm = mapContractToContractGetForm(contract);
        return contractGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/contract/{contract_id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ContractGetForm getContract(@PathVariable("contract_id") Long contractId) {

        Contract contract = contractService.getContract(contractId);
        ContractGetForm contractGetForm = mapContractToContractGetForm(contract);
        return contractGetForm;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/user/company/employee/contract/{contract_id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody
    ContractGetForm deleteContract(@PathVariable("contract_id") Long contractId) {

        Contract contract = contractService.deleteContract(contractId);
        ContractGetForm contractGetForm = mapContractToContractGetForm(contract);
        return contractGetForm;
    }

    private ContractGetForm mapContractToContractGetForm(Contract contract) {

        ContractGetForm contractGetForm = new ContractGetForm(
                contract.getId(),
                contract.getType());
        
        return contractGetForm;

    }
}
