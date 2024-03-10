package org.ag.opensource.springtopics.service;

import org.ag.opensource.springtopics.model.EmployeeDto;
import org.ag.opensource.springtopics.model.ModelApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<ModelApiResponse<EmployeeDto>> createEmployee(EmployeeDto employeeDto);
    ResponseEntity<ModelApiResponse<EmployeeDto>> getEmployee(Long id);
    ResponseEntity<ModelApiResponse<List<EmployeeDto>>> getAllEmployees();
    ResponseEntity<ModelApiResponse<EmployeeDto>> updateEmployee(Long id, EmployeeDto employeeDto);
    ResponseEntity<ModelApiResponse<EmployeeDto>> deleteEmployee(Long id);
}
