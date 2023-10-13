package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Employee;
import com.youcode.resourcium.repository.EmployeRepository;

public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(){
        employeRepository=new EmployeRepository();
    }
}
