package com.shelter.worker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@RequestMapping("/workers")
	@ResponseBody
	public List<Worker> getWorkers(){
		return workerService.getAllWorkers();
	}
	
	@RequestMapping(value="workers/add", method=RequestMethod.POST)
	public void addWorker(@RequestBody Worker worker) {
		workerService.addWorker(worker);
	}
	
}
