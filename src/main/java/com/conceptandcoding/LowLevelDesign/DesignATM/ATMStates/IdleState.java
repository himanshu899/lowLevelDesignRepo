package com.conceptandcoding.LowLevelDesign.DesignATM.ATMStates;

import com.conceptandcoding.LowLevelDesign.DesignATM.ATM;
import com.conceptandcoding.LowLevelDesign.DesignATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(new HasCardState());
    }
}
