package springmvc.service;

import springmvc.entity.Admin;

public interface AdminService {
	
	public Admin getAdmin(String name);
	public void guardarAdmin(Admin admin);

}
