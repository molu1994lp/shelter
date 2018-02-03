package com.shelter.worker;

import java.util.List;

public interface WorkerDao {
	
	public List<Worker> getWorkers();
	
	public void addWorker(Worker worker);
	
	public List<String> getAllEmails();

}
