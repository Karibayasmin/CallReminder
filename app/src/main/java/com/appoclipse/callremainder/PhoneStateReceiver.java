package com.appoclipse.callremainder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneStateReceiver extends  BroadcastReceiver {

    static boolean ring=false;
    static boolean callReceived=false;

    @Override
    public void onReceive(Context context, Intent intent) {

        try {
            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);


            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                ring =true;
               // Toast.makeText(context,"Incoming Call State",Toast.LENGTH_SHORT).show();
               // Toast.makeText(context,"Ringing State Number is -"+incomingNumber,Toast.LENGTH_SHORT).show();


            }
            if ((state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))){
                callReceived=true;
               // Toast.makeText(context,"Call Received State",Toast.LENGTH_SHORT).show();
            }
            if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
               // Toast.makeText(context,"Call idle State",Toast.LENGTH_SHORT).show();

                if(ring==true&&callReceived==false)
                {
                    Toast.makeText(context, "It was A MISSED CALL from : "+incomingNumber, Toast.LENGTH_LONG).show();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}






