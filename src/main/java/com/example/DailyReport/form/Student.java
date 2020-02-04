package com.example.DailyReport.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"受講者名", "メールアドレス", "所属"})

public class Student {

    @JsonProperty("受講者名")
    private Long name;
    @JsonProperty("メールアドレス")
    private Long email;
    @JsonProperty("affiliation")
    private Long affiliation;

    public Student() {}

    public Student(Long name, Long email, Long affiliation) {
        this.name = name;
        this.email = email;
        this.affiliation = affiliation;
    }
}
