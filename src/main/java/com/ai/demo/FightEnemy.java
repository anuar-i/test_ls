package com.ai.demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class FightEnemy implements JavaDelegate{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ArrayList<Boolean> army = (ArrayList<Boolean>) delegateExecution.getVariable("army");

        //List<Boolean> armyList = new ArrayList<>(Collections.nCopies(warriors,true));

//        Type listType = new TypeToken<ArrayList<Boolean>>(){}.getType();
//
//        String armyStr = (String) delegateExecution.getVariable("army");
//
//        ArrayList<Boolean> army = new Gson().fromJson(armyStr, listType);

        int enemyWarriors = (int) delegateExecution.getVariable("enemyWarriors");
        //Thread.sleep(1000);

        if (new Random().nextBoolean()){
            enemyWarriors--;
            System.out.println("Enemy warrior killed");
        }else{
            army.remove(army.size()-1);

            System.out.println("Our warrior killed");
        }

        System.out.println("enemyWarriors:" + enemyWarriors);
        System.out.println("warriors:" + army.size());
        System.out.println("army:" + army);
        delegateExecution.setVariable("enemyWarriors", enemyWarriors);
        delegateExecution.setVariable("warriors", army.size());
        delegateExecution.setVariable("army", army);

    }
}
