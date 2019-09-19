package csam.sebankid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbacksContext;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
/**
 * This class echoes a string called from JavaScript.
 */
public class sebankid extends CordovaPlugin {

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
    
        if (action.equals("startAuthCall")) {
            String token = args.getString(0);
            this.startAuthCall(token, callbackContext);
            return true;
        }
        return false;
    }
    public void startAuthCall(String starttoken, CallbackContext context) {
        System.out.println("test");
        if (starttoken != null && starttoken.length() > 0) {
            context.success(starttoken + "FROM JAVA CODE");
        } else {
            context.error("Expected one non-empty string argument.");
        }
        Intent intent = new Intent(context);
        intent.setPackage("com.bankid.bus");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bankid://autostarttoken=" + starttoken + "&redirect=null "));
        this.cordova.getActivity().startActivity(intent);

    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        System.out.println("test");
        if (message != null && message.length() > 0) {
            callbackContext.success(message + "FROM JAVA CODE");
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
