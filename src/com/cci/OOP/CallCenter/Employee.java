package com.cci.OOP.CallCenter;

public abstract class Employee {

    String name;
    String age;
    int level;

    abstract void startCall(Call call);

    abstract void delegateCall(Call call);

    abstract void endCall(Call call);

}
