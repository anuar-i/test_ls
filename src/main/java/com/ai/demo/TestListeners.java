package com.ai.demo;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.*;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import static org.camunda.spin.Spin.*;


@Component
public class TestListeners implements TaskListener {

    //public void execute(DelegateExecution delegateExecution) throws Exception {
        //var s = (String) execution.getProcessInstanceId();
        //System.out.println("testListeners test");

        //ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //String s = processEngine.get
        //RuntimeService runtimeService = processEngine.getRuntimeService();
        //TaskService taskService = processEngine.getTaskService();
        //runtimeService.
    //}

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("testListeners test TaskListener");


    }
}
