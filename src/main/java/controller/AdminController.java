package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.AdminService;
//import exception.ResourceNotFoundException;
import model.Admin;


@RestController
public class AdminController {

	 @Autowired
	    private AdminService adminService;

	    @GetMapping("/admins")
	    public List<Admin> getAllAdmins() {
	        return adminService.findAllAdmins();
	    }
//
//	    @GetMapping("/admins/{id}")
//	    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable(value = "id") Long adminId)
//	        throws ResourceNotFoundException {
//	    	Optional<Admin> admin = adminService.findById(adminId);
//	        return ResponseEntity.ok().body(admin);
//	    }
//	    
//	    @PostMapping("/admins")
//	    public Admin createAdmin(@Valid @RequestBody Admin admin) {
//	        return adminService.save(admin);
//	    }
//
//	    @PutMapping("/admins/{id}")
//	    public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Long adminsId,
//	         @Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
//	    	Admin admin = adminService.findById(adminsId)
//	        .orElseThrow(() -> new ResourceNotFoundException("admin not found for this id :: " + adminsId));
//
//	        
//	    	admin.setId(adminDetails.getId());
//	    	admin.setName(adminDetails.getName());
//	    	admin.setEmail(adminDetails.getEmail());
//	    	admin.setPassword(adminDetails.getPassword());
//	        final Admin updateAdmin = adminService.save(admin);
//	        return ResponseEntity.ok(updateAdmin);
//	    }
//
//	    @DeleteMapping("/admins/{id}")
//	    public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long adminId)
//	         throws ResourceNotFoundException {
//	    	Admin admin = adminService.findById(adminId)
//	       .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
//
//	    	adminService.delete(admin);
//	        Map<String, Boolean> response = new HashMap<>();
//	        response.put("deleted", Boolean.TRUE);
//	        return response;
//	    }
	}
