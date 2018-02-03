package com.shelter.worker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
	
	@Autowired
	WorkerDaoImpl workerDaoImpl;
	
	public List<Worker> getAllWorkers(){
		return workerDaoImpl.getWorkers();
	}
	
	/**
	 * Przed dodaniem sprawdzam czy email istnieje w bazie
	 * @param worker
	 */
	
	public void addWorker(Worker worker) {
		boolean flag = true;
		for(String email : workerDaoImpl.getAllEmails()) {
			if(email.equals(worker.getEmail())) {
				flag = false;
			}
		}
		if(flag) {
			workerDaoImpl.addWorker(worker);
		}
		else {
			System.out.println("Email istnieje w bazie");
		}
		
	}

}
