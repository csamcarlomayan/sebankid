package csam.sebankid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.content.Context;
import android.content.Intent;
/**
 * This class echoes a string called from JavaScript.
 */
public class sebankid extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, context , callbackContext);
            callbackContext.error("result calculated in Java: " + message);
            return false;
        }
        return false;
    }
    public void startAuthCall(String starttoken, CallbackContext callbackContext) {
        if (starttoken != null && starttoken.length() > 0) {
            callbackContext.success(starttoken);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
        /* Intent intent = new Intent();
        intent.setPackage("com.bankid.bus");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bankid://autostarttoken=" + starttoken + "&redirect=null "));
        startActivity(intent); */
    }

    private void coolMethod(String message, Context context, CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.setPackage("com.bankid.bus");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bankid://autostarttoken=" + message + "&redirect=null "));
        context.startActivity(intent);
        
    }
}