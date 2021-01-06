package com.gian.persons.service;


import com.gian.persons.model.response.PersonResponse;
import io.reactivex.Single;

public interface IPersonService {
    Single<PersonResponse> getPerson(String s);
}
