package com.example.demo;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Resource
	RepositoryService repositoryService;

   @Test
   public void TestStartProcess() {
       repositoryService.createDeployment()
			   .name("qjlc111")
			   .addClasspathResource("processes/MyProcess.bpmn").deploy();
    }
}
