package com.dataJpaAssignment.Data_Jpa_Assignment.Controller;

import com.dataJpaAssignment.Data_Jpa_Assignment.Model.UserReg;
import com.dataJpaAssignment.Data_Jpa_Assignment.Service.UserRegService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersRegController {

//    @Autowired
//    UserRegService service;
//
//    @GetMapping("/getUsers")
//    public ResponseEntity<List<UserReg>>  getUsersData(){
//        List<UserReg> reg = service.getUsersData();
//        return new ResponseEntity<>(reg, HttpStatus.OK);
//    }
//    @PostMapping("/addUsers")
//    public String addUSerData(@RequestBody UserReg userReg){
//        String result = service.addUsers(userReg.getUserName(),userReg.getPassword(),userReg.getMobileNumber(),userReg.getAge());
//        return "success";
//    }
//
//    @GetMapping("/getDataById/{id}")
//    public ResponseEntity<UserReg> getById(@PathVariable Integer id){
//        UserReg data = service.getDataById(id);
//        if(data != null){
//            return new ResponseEntity<>(data,HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    //    @PostMapping()
//    public ResponseEntity<List<UserReg>> saveMultiple(@RequestBody List<UserReg> userreg){
//        List<UserReg> res =  service.saveMultipleData(userreg);
//        if(res != null) {
//            return new ResponseEntity<>(res, HttpStatus.CREATED);
//        }else {
//            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
//        }
//    }


    //java 8 features applied for the abouve rest apis

    private final UserRegService service;

    @Autowired
    public UsersRegController(UserRegService service) {
        this.service = service;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserReg>> getUsersData() {
        List<UserReg> reg = service.getUsersData();
        return new ResponseEntity<>(reg, HttpStatus.OK);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUserData(@RequestBody UserReg userReg) {
        String result = service.addUsers(userReg.getUserName(), userReg.getPassword(), userReg.getMobileNumber(), userReg.getAge());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getDataById/{id}")
    public ResponseEntity<UserReg> getById(@PathVariable Integer id) {
        Optional<UserReg> data = service.getDataById(id);
        return data.map(userReg -> new ResponseEntity<>(userReg, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        boolean isDeleted = service.deleteUserByID(id);
        String res = isDeleted ? "User deleted successfully" : "User deletion failed";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping("/saveBulkData")
    public ResponseEntity<List<UserReg>> saveMultiple(@RequestBody List<UserReg> userreg) {
        List<UserReg> res = service.saveMultipleData(userreg);
        HttpStatus status = (res != null && !res.isEmpty()) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(res, status);
    }

    /* pageable concept for getting data as per need

     http://localhost:8080/users/getUsersDataByPagination?page=0&size=5&sort=userName,asc
     In pageable interface we have some methods to fetch data
     Size
     page=0 ---for first page
     sort --by username or any fields we do sorting
     asc and des also posible with this pageable interface
     */
    @GetMapping("/getUsersDataByPagination")
    public ResponseEntity<Page<UserReg>> getdata(Pageable pageable){
        Page<UserReg> users = service.getDataByPagination(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
