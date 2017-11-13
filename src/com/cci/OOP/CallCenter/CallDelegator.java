package com.cci.OOP.CallCenter;

import com.cci.queue.Queue;

public class CallDelegator {

    static Queue<Call> calls = new Queue<>();
    static Queue<Call> manager_wait_calls = new Queue<>();
    static Queue<Call> director_wait_calls = new Queue<>();

    static int respondents=50;
    static int managers=5;
    static int directors=2;
    static int[] level = {0,1,2};


    void dispatchCall(Call call){
        if(getCallHandler()){
            Respondent respondent = new Respondent();
            respondent.startCall(call);
        }else {
            calls.add(call);
        }
    }

    boolean getCallHandler(){
        if (respondents!=0){
            respondents--;
            return true;
        }

        return false;
    }

}
