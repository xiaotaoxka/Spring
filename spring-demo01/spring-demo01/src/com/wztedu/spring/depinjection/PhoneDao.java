package com.wztedu.spring.depinjection;

import org.springframework.stereotype.Repository;

@Repository
public class PhoneDao extends BaseDao<Phone>{
    @Override
    public void save() {
        System.out.println("PhoneDao save()");
    }
}
