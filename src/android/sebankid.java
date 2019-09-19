package csam.sebankid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class sebankid extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startAuthCall")) {
            String message = args.getString(0);
            this.startAuthCall(message + "FROM JAVA CODE", callbackContext);
            return true;
        }
        return false;
    }
    public void startAuthCall(String starttoken, CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.setPackage("com.bankid.bus");
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bankid://autostarttoken=" + starttoken + "&redirect=null "));
        startActivity(intent);
        if (starttoken != null && starttoken.length() > 0) {
            callbackContext.success(starttoken + "FROM JAVA CODE");
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
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
