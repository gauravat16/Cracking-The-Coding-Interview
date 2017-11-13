package com.cci.OOP.CallCenter;

public class Director extends Employee {


    @Override
    void startCall(Call call) {

    }

    @Override
    void delegateCall(Call call) {
        if(CallDelegator.directors==0){
            CallDelegator.director_wait_calls.add(call);

        }
    }

    @Override
    void endCall(Call call) {

    }
}
