package org.ag.opensource.springtopics.service;

import lombok.RequiredArgsConstructor;
import org.ag.opensource.springtopics.entity.Employee;
import org.ag.opensource.springtopics.model.EmployeeDto;
import org.ag.opensource.springtopics.model.ModelApiResponse;
import org.ag.opensource.springtopics.repo.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Override
    public ResponseEntity<ModelApiResponse<EmployeeDto>> createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        Employee saved = employeeRepo.save(employee);
        BeanUtils.copyProperties(saved, employeeDto);
        ModelApiResponse<EmployeeDto> response = new ModelApiResponse<>(HttpStatus.CREATED.value(), "Employee created successfully", employeeDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ModelApiResponse<EmployeeDto>> getEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        ModelApiResponse<EmployeeDto> modelApiResponse;
        if (optionalEmployee.isPresent()) {
            BeanUtils.copyProperties(optionalEmployee.get(), employeeDto);
            modelApiResponse = new ModelApiResponse<>(HttpStatus.OK.value(), "Employee found", employeeDto);
        } else {
            modelApiResponse = new ModelApiResponse<>(HttpStatus.NOT_FOUND.value(), "Employee not found");
        }
        return new ResponseEntity<>(modelApiResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModelApiResponse<List<EmployeeDto>>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeRepo.findAll().stream().map(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }).collect(Collectors.toList());
        ModelApiResponse<List<EmployeeDto>> modelApiResponse;
        if (employeeDtos.isEmpty()) {
            modelApiResponse = new ModelApiResponse<>(HttpStatus.NOT_FOUND.value(), "Employee not found");
        } else {
            modelApiResponse = new ModelApiResponse<>(HttpStatus.OK.value(), "Employee found", employeeDtos);
        }
        return new ResponseEntity<>(modelApiResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModelApiResponse<EmployeeDto>> updateEmployee(Long id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        AtomicReference<ModelApiResponse<EmployeeDto>> modelApiResponse = new AtomicReference<>();
        optionalEmployee.ifPresentOrElse(employee -> {
            BeanUtils.copyProperties(employeeDto, employee, "id");
            employeeRepo.save(employee);
            modelApiResponse.set(new ModelApiResponse<>(HttpStatus.OK.value(), "Employee found", employeeDto));
        }, () -> modelApiResponse.set(new ModelApiResponse<>(HttpStatus.NOT_FOUND.value(), "Employee not found")));
        return new ResponseEntity<>(modelApiResponse.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModelApiResponse<EmployeeDto>> deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
        return new ResponseEntity<>(new ModelApiResponse<>(HttpStatus.OK.value(), "Employee deleted"), HttpStatus.OK);
    }
}
