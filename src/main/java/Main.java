import io.rocketchat.common.data.model.ErrorObject;
import io.rocketchat.common.data.model.Message;
import io.rocketchat.common.listener.ConnectListener;
import io.rocketchat.core.RocketChatAPI;
import io.rocketchat.core.callback.HistoryListener;
import io.rocketchat.core.callback.LoginListener;
import io.rocketchat.core.callback.SubscriptionListener;
import io.rocketchat.core.model.SubscriptionObject;
import io.rocketchat.core.model.TokenObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sachin on 7/6/17.
 */

public class Main implements ConnectListener, LoginListener, SubscriptionListener.GetSubscriptionListener, HistoryListener {


    RocketChatAPI api;
    private static String serverurl="wss://demo.rocket.chat/websocket";
    Date lasttimestamp;
    private String roomId;


    public void call(){
        api=new RocketChatAPI(serverurl);
        api.setReconnectionStrategy(null);
        api.connect(this);
    }

    public static void main(String [] args){
        new Main().call();
    }


    @Override
    public void onConnect(String sessionID) {
        System.out.println("Connected to server with id "+sessionID);
        api.login("sachin.shinde","sachin123",this);
    }

    @Override
    public void onDisconnect(boolean closedByServer) {
        System.out.println("Disconnected from server");
    }

    @Override
    public void onConnectError(Exception websocketException) {
        System.out.println("Got connect error with the server");
    }

    @Override
    public void onLogin(TokenObject token, ErrorObject error) {
        System.out.println("Logged in successfully with token "+token);
        api.getSubscriptions(this);
    }

    @Override
    public void onGetSubscriptions(ArrayList<SubscriptionObject> subscriptions, ErrorObject error) {
        roomId=subscriptions.get(2).getRoomId();
        System.out.println("room is "+subscriptions.get(2).getRoomName());
        api.getChatHistory(roomId,20,lasttimestamp,null,this);
    }

    @Override
    public void onLoadHistory(ArrayList<Message> list, int unreadNotLoaded, ErrorObject error) {
        for (Message message:list){
            System.out.println("Message is "+message.getMessage());
        }
        lasttimestamp=list.get(list.size()-1).getMsgTimestamp();
        api.getChatHistory(roomId,20,lasttimestamp,null,this);
    }
}


/**
 * RocketChat server dummy user : {"userName":"guest-3829","roomId":"1hrjr4sruo9q1","userId":"9kAri3uXquAnkMeb4","visitorToken":"-57c7cb8f9c53963712368351705f4d9b","authToken":"qTcmnjIrfQB55bTd9GYhuGOOU63WY0-_afbCe8hyX_r"}
 */

/**
 * Localhost dummy user: {"userName":"guest-18","roomId":"u7xcgonkr7sh","userId":"rQ2EHbhjryZnqbZxC","visitorToken":"707d47ae407b3790465f61d28ee4c63d","authToken":"VYIvfsfIdBaOy8hdWLNmzsW0yVsKK4213edmoe52133"}
 */

