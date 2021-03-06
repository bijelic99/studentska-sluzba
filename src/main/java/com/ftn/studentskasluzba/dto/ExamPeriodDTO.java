package com.ftn.studentskasluzba.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ftn.studentskasluzba.model.Exam;
import com.ftn.studentskasluzba.model.ExamPeriod;
import org.joda.time.DateTime;

import java.util.HashSet;

public record ExamPeriodDTO(
        @JsonProperty("id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("startTime")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime startTime,
        @JsonProperty("endTime")
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        DateTime endTime,
        @JsonProperty("deleted")
        Boolean deleted
) implements ToAndFromModel<ExamPeriod, ExamPeriodDTO> {

    public ExamPeriodDTO(ExamPeriod examPeriod) {
        this(examPeriod.getId(), examPeriod.getName(), examPeriod.getStartTime(), examPeriod.getEndTime(), examPeriod.getDeleted());
    }

    @Override
    public ExamPeriod toModel() {
        return new ExamPeriod(id, name, startTime, endTime, new HashSet<Exam>(), deleted);
    }

    @Override
    public ExamPeriodDTO fromModel(ExamPeriod modelObject) {
        return new ExamPeriodDTO(modelObject);
    }
}
