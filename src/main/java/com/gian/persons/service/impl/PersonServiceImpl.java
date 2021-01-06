package com.gian.persons.service.impl;

import com.gian.persons.model.response.PersonResponse;
import com.gian.persons.service.IPersonService;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {
    @Override
    public Single<PersonResponse> getPerson(String s) {
        Observable<PersonResponse> person = Observable.just(
                new PersonResponse("1","10000000",true,false),
                new PersonResponse("2","10000001",false,false),
                new PersonResponse("3","10000002",true,true))
                .filter(x->x.getDocument().equals(s)&&x.isBlacklist()==false);

        return Single.fromObservable(person);
    }
}
