package com.vms.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MessageNotification {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACf4b400422111f95284da6c48bb9e09e8";
    public static final String AUTH_TOKEN = "2f73bb2838ffad3524341f81c93ac4c3";

    public static void sendNotification(String messageString) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+919655713126"),
                new com.twilio.type.PhoneNumber("+16062892494"),
                messageString)
            .create();
    }
}
