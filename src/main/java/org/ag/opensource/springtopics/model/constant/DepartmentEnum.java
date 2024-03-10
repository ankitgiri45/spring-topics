package org.ag.opensource.springtopics.model.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Department of the employee
 */
public enum DepartmentEnum {
    IT("IT"),
    HR("HR"),
    FINANCE("Finance"),
    MARKETING("Marketing");

    private final String value;

    DepartmentEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DepartmentEnum fromValue(String value) {
        for (DepartmentEnum b : DepartmentEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}
