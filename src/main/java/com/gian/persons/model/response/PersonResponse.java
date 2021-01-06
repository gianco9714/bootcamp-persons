package com.gian.persons.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
    private String id;
    private String document;
    private boolean fingerprint;
    private boolean blacklist;
}
