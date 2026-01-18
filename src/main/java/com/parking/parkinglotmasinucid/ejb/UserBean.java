package com.parking.parkinglotmasinucid.ejb;


import com.parking.parkinglotmasinucid.common.UserDto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;




    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");
        try{
            TypedQuery<User> typedQuery =
                    entityManager.createQuery("SELECT u FROM User u", User.class);
            typedQuery.getResultList();
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> userList){
        List<UserDto> userDtoList=new ArrayList<>();
        for(User user:userList){
            UserDto userDto=new UserDto(user.getId(),user.getUsername(), user.getEmail(),user.getPassword(), user.getCars());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
