package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.Admin;
import com.example.capstone2.Repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    public void update(Integer id ,Admin admin) {
       Admin admin1 = adminRepository.findAdminById(id);

       if(admin1 != null) {
           admin1.setName(admin.getName());
           admin1.setPassword(admin.getPassword());
           admin1.setUsername(admin.getUsername());
           adminRepository.save(admin1);
       }
       throw new ApiExcption("admin not found");

    }
    public void delete(Integer id) {
        Admin admin = adminRepository.findAdminById(id);
        if(admin != null) {
            adminRepository.delete(admin);
        }
        throw new ApiExcption("admin not found");
    }

    public void login(String username, String password) {
        Admin admin = adminRepository.findAdminByUsernameAndPassword(username, password);
        if(admin == null) {
            throw new ApiExcption("admin not found");
        }
        admin.setLoggedin(true);
        adminRepository.save(admin);

    }






}
