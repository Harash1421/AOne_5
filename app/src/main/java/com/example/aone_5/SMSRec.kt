package com.example.aone_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.widget.Toast

class SMSRec : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var Phone:String = ""
        var Text:String = ""
        var pdus = intent!!.extras!!.get("pdus") as Array<*>
        for (x in pdus.indices){
            var sms = SmsMessage.createFromPdu(pdus[x] as ByteArray)
            Phone = sms.displayOriginatingAddress.toString()
            Text = sms.messageBody
        }
        if (Text == "R"){
            var marks = School(context!!)
            var db = marks.readableDatabase
            var cur = db.rawQuery("select * from marks where Phone = ?", arrayOf(Phone))
            if (cur!!.count > 0){
                cur.moveToFirst()
                var result = "Name: " + cur.getString(0) + "\n" + "Marks: " + cur.getString(2) + "\n" +
                        "Result: " + cur.getString(3)
                var sms = SmsManager.getDefault();
                sms.sendTextMessage(Phone, null, result, null, null)
            }
        }
        Toast.makeText(context, Phone, Toast.LENGTH_SHORT).show()
    }
}