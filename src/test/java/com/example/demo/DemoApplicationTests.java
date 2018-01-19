package com.example.demo;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	RuntimeService runtimeService;
	
	@Resource
	RepositoryService repositoryService;
	
	
	/*@Test
	public void contextLoads() {
	}*/
   @Test
   public void TestStartProcess() {
  /*      Map<String, Object> variables = new HashMap<>();
        variables.put("applicantName", "John Doe");
       variables.put("email", "john.doe@activiti.com");
       variables.put("phoneNumber", "123456789");
       ProcessInstance startProcessInstanceByKey = runtimeService.startProcessInstanceByKey("leaveProcess", variables);
       System.out.println(startProcessInstanceByKey);*/
	   
       repositoryService.createDeployment().name("qjlc111").addClasspathResource("processes/MyProcess.bpmn").deploy();
    }
}
