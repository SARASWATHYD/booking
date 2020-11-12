package com.saras.booking.service;

import com.saras.booking.entity.EmployeeEntity;
import com.saras.booking.entity.User;
import com.saras.booking.repository.EmployeeRepository;
import com.saras.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by saraswathy
 * on 2020-11-12 14:50
 */

@Service
public class UserService {


    @Autowired
    UserRepository repository;

    public List<User> getAll()
    {
        List<User> employeeList = repository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<>();
        }
    }

    public User getUserByEmail(String id) throws Exception
    {
        Optional<User> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception("No user record exist for given id");
        }
    }

    public User createOrUpdateUser(User entity) {
        System.out.println("repository::"+repository);

        Optional<User> employee = repository.findById(entity.getEmail());

        if (employee.isPresent()) {
            User newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setPhno(entity.getPhno());
            newEntity.setAddress(entity.getAddress());
            newEntity.setLoginType(entity.getLoginType());
            newEntity.setPswd(entity.getPswd());

            newEntity = repository.save(newEntity);

            return newEntity;

        }else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteUserById(String id) throws Exception
    {
        Optional<User> user = repository.findById(id);

        if(user.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }


}
