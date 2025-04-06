package com.dataJpaAssignment.Data_Jpa_Assignment.Service;

import com.dataJpaAssignment.Data_Jpa_Assignment.Dao.UserRegDao;
import com.dataJpaAssignment.Data_Jpa_Assignment.Model.UserReg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserRegService {

//    @Autowired
//    UserRegDao dao;
//        public List<UserReg> getUsersData() {
//        return dao.findAll();
//    }
//    public String addUsers(String userName, String password, String mobileNumber, Integer age) {
//        UserReg reg = new UserReg();
//            reg.setUserName(userName);
//            reg.setPassword(password);
//            reg.setMobileNumber(mobileNumber);
//            reg.setAge(age);
//        UserReg output = dao.save(reg);
//        if(output != null){
//            return  "Success";
//        }
//        else{
//             return "Something went wrong ";
//        }
//    }
//
//    public UserReg getDataById(Integer id) {
//        return dao.findById(id).orElse(null);
//    }
    // java 8 features applied for service layers
private final UserRegDao dao;

    @Autowired
    public UserRegService(UserRegDao dao) {
        this.dao = dao;
    }

    public List<UserReg> getUsersData() {
        return dao.findAll();
    }

    public String addUsers(String userName, String password, String mobileNumber, Integer age) {
        UserReg reg = new UserReg();
            reg.setUserName(userName);
            reg.setPassword(password);
            reg.setMobileNumber(mobileNumber);
            reg.setAge(age);
            UserReg output = dao.save(reg);
        return Optional.ofNullable(output)
                .map(o -> "Success")
                .orElse("Something went wrong");
    }

    public Optional<UserReg> getDataById(Integer id) {
        return dao.findById(id);
    }

    public boolean deleteUserByID(Integer id) {
        try {
            dao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public List<UserReg> saveMultipleData(List<UserReg> userreg) {
         return dao.saveAll(userreg);
    }

    public Page<UserReg> getDataByPagination(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
