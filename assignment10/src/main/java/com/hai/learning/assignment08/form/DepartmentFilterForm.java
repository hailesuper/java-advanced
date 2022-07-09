package com.hai.learning.assignment08.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {
    private Integer minID;
    private Integer maxID;
}
