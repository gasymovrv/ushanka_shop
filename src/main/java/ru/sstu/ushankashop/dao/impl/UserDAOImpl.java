package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sstu.ushankashop.dao.UserDAO;
import ru.sstu.ushankashop.domain.UserEntity;

import javax.persistence.EntityManager;

@Service
public class UserDAOImpl implements UserDAO{

    @Autowired
    EntityManager entityManager;
    
    public UserEntity merge(UserEntity user) {
        return entityManager.merge(user);
    }
    
    
    public UserEntity findById(Long id){
        return entityManager.find(UserEntity.class,id);
    }
}
