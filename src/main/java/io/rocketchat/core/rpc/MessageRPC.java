package io.rocketchat.core.rpc;

import io.rocketchat.common.data.rpc.RPC;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sachin on 21/7/17.
 */
public class MessageRPC extends RPC{

    public static String SENDMESSAGE="sendMessage";

    public static String sendMessage(int integer, String msgId, String roomId, String message){
        JSONObject object=new JSONObject();
        try {
            object.put("_id",msgId);
            object.put("rid",roomId);
            object.put("msg",message);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getRemoteMethodObject(integer,SENDMESSAGE,object).toString();
    }

    // TODO: 24/7/17 Implement this
    public static String deleteMessage(int integer){
        return "";
    }

    // TODO: 24/7/17 Implement this
    public static String updateMessage(int integer){
        return "";
    }

    // TODO: 24/7/17 Implement this
    public static String pinMessage(int integer){
        return "";
    }

    // TODO: 24/7/17 Implement this
    public static String unpinMessage(int integer){
        return "";
    }

    // TODO: 24/7/17 Implement this
    public static String starMessage(int integer){
        return "";
    }

    // TODO: 24/7/17 Implement this
    public static String setReaction(int integer){
        return "";
    }
}
