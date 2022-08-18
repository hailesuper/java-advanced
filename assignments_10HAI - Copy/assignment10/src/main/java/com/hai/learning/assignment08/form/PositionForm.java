package com.hai.learning.assignment08.form;

import com.hai.learning.assignment08.entity.Department;
import com.hai.learning.assignment08.entity.Position;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class PositionForm {

    @NonNull
    private String name;

    public Position toEntity() {
        return new Position(Position.PositionName.valueOf(name));
    }
}
