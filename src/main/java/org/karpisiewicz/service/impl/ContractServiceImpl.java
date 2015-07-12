package org.karpisiewicz.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.karpisiewicz.entity.Contract;
import org.karpisiewicz.entity.Employee;
import org.karpisiewicz.entity.Schedule;
import org.karpisiewicz.entity.enumerated.ContractType;
import org.karpisiewicz.form.contract.ContractCreateForm;
import org.karpisiewicz.form.contract.ContractEditForm;
import org.karpisiewicz.repository.ContractRepository;
import org.karpisiewicz.service.ContractService;
import org.karpisiewicz.service.EmployeeService;
import org.karpisiewicz.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;
    
    @Autowired
    ScheduleService scheduleService;
    
    @Autowired
    EmployeeService employeeSerivice;

    @Override
    public Contract createContract(ContractCreateForm contractCreateForm, Long employeeId, Long scheduleId) {

        Employee employee = employeeSerivice.getEmployee(employeeId);
        
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        
        Contract contract = new Contract(
                contractCreateForm.getType(),
                employee,
                schedule);

        contract = contractRepository.save(contract);
        
        return contract;
    }

    @Override
    public Contract editContract(ContractEditForm contractEditForm, Long contractId) {

        Contract contract = contractRepository.findOne(contractId);

        contract.setType(contractEditForm.getType());
        
        contract = contractRepository.save(contract);
        
        return contract;
    }

    @Override
    public Contract getContract(Long contractId) {

        Contract contract = contractRepository.findOne(contractId);

        return contract;
    }

    @Override
    public Contract deleteContract(Long contractId) {

        Contract contract = contractRepository.findOne(contractId);
        contractRepository.delete(contract);

        return contract;
    }

    @Override
    public List<String> getContractType() {

        List<String> contractTypeList = new ArrayList(Arrays.asList(ContractType.values()));

        return contractTypeList;
    }
   
}
