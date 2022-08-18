package com.ai.demo;

import camundajar.impl.scala.concurrent.impl.Promise;
import com.google.gson.Gson;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.camunda.spin.Spin.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Value("${maxWarriors}")
    private int maxWarriors;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        //String probability = "";


        int warriors = (int) delegateExecution.getVariable("warriors");
        int enemyWarriors = (int) (Math.random() * 100);

        //String battleStatus = "undefined";
        //boolean isWin = false;

        maxWarriors = maxWarriors == 0 ? 100 : maxWarriors;

        if(warriors < 1 || warriors > maxWarriors){

            throw new BpmnError("warriorError");
        }

        List<Boolean> army = new ArrayList<>(Collections.nCopies(warriors,true));


/*
        if ((warriors - enemyWarriors) > 1){
            isWin = true;
            battleStatus = "Victory";
        }else{
            battleStatus = "fail (((";
        }

 */
        System.out.println("готов к битве! enemy army: " + enemyWarriors + ". Our army: " + warriors);

        delegateExecution.setVariable("army", army);
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        String asd = "asd";
        delegateExecution.setVariable("asd", asd);
        //delegateExecution.setVariable("battleStatus", battleStatus);
        //delegateExecution.setVariable("isWin", isWin);


    }
}
