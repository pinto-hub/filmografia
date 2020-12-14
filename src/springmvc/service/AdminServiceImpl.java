package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Admin;
import springmvc.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	@Transactional
	public Admin getAdmin(String name) {
		
		return this.adminRepository.getAdmin(name);
	}

	@Override
	@Transactional
	public void guardarAdmin(Admin admin) {
		this.adminRepository.save(admin);
		
	}

}
