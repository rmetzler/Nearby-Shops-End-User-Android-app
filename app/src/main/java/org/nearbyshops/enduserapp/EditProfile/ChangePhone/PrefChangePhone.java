package org.nearbyshops.enduserapp.EditProfile.ChangePhone;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;


import org.nearbyshops.enduserapp.ModelRoles.User;
import org.nearbyshops.enduserapp.R;
import org.nearbyshops.enduserapp.Utility.UtilityFunctions;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sumeet on 6/8/17.
 */

public class PrefChangePhone {


    public static final String TAG_CHANGE_PHONE = "tag_change_phone";


    public static void saveUser(User user, Context context)
    {

        //Creating a shared preference

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPref.edit();

        Gson gson = UtilityFunctions.provideGson();
        String json = gson.toJson(user);
        prefsEditor.putString(TAG_CHANGE_PHONE, json);

        prefsEditor.apply();
    }


    public static User getUser(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);

        Gson gson = UtilityFunctions.provideGson();
        String json = sharedPref.getString(TAG_CHANGE_PHONE, null);

        return gson.fromJson(json, User.class);
    }

}
