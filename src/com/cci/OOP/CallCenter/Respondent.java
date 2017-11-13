package com.cci.OOP.CallCenter;

public class Respondent extends Employee {
    @Override
    void startCall(Call call) {
        System.out.println("Call Started");

    }

    @Override
    void delegateCall(Call call) {
        if(CallDelegator.managers!=0){
            CallDelegator.managers--;
            Manager manager = new Manager();
            manager.startCall(call);
        }else{
                CallDelegator.manager_wait_calls.add(call);
        }
    }

    @Override
    void endCall(Call call) {

    }
}
