package org.ag.opensource.springtopics.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.ag.opensource.springtopics.model.constant.DepartmentEnum;

import java.util.Date;

/**
 * Employee
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Data
public class EmployeeDto {
    /**
     * ID of the employee auto-generated
     */
    @Schema(name = "id", example = "1", description = "ID of the employee auto-generated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;

    /**
     * Name of the employee
     */
    @Schema(name = "name", example = "John Doe", description = "Name of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty
    private String name;
    /**
     * Age of the employee
     */
    @Schema(name = "age", example = "25", description = "Age of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 18, message = "Age should be greater than 18")
    private Integer age;

    /**
     * Department of the employee
     */
    @Schema(name = "department", examples = "IT", description = "Department of the employee", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty
    private DepartmentEnum department;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;
}

