package net.shiftstudios.tools.android.sharedprefs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class SharedPreferencesHelper {

    private SharedPreferences s;
    private Context context;
    private Gson gson;

    public SharedPreferencesHelper(Context context) {
        this.context = context;
        this.s = PreferenceManager.getDefaultSharedPreferences(context);
        this.gson = new Gson();
    }

    public SharedPreferencesHelper(Context context, String name) {
        this.context = context;
        this.s = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    public SharedPreferencesHelper(Context context, String name, int mode) {
        this.context = context;
        this.s = context.getSharedPreferences(name, mode);
        this.gson = new Gson();
    }

    public Context getContext() {
        return context;
    }

    public SharedPreferences getSharedPreferences() {
        return s;
    }

    public boolean contains(String key) {
        return s.contains(key);
    }

    public void registerListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        s.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        s.unregisterOnSharedPreferenceChangeListener(listener);
    }

    public void remove(String key) {
        SharedPreferences.Editor e = s.edit();
        e.remove(key);
        e.commit();
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor e = s.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key, value);
        e.commit();
    }

    public void putFloat(String key, float value) {
        SharedPreferences.Editor e = s.edit();
        e.putFloat(key, value);
        e.commit();
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, value);
        e.commit();
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value);
        e.commit();
    }

    public void putBigInteger(String key, BigInteger value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value.toString());
        e.commit();
    }

    public void putBigDecimal(String key, BigDecimal value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value.toString());
        e.commit();
    }

    public void putDate(String key, Date value) {
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, value.getTime());
        e.commit();
    }

    public void putObject(String key, Object value) {
        String json = gson.toJson(value);

        SharedPreferences.Editor e = s.edit();
        e.putString(key, json);
        e.commit();
    }

    @TargetApi(11)
    public void putStringSet(String key, Set<String> value) {
        SharedPreferences.Editor e = s.edit();
        e.putStringSet(key, value);
        e.commit();
    }

    public Map<String, ?> getAll() {
        return s.getAll();
    }

    public boolean getBoolean(String key) {
        return s.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return s.getBoolean(key, defaultValue);
    }

    public int getInt(String key) {
        return s.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return s.getInt(key, defaultValue);
    }

    public float getFloat(String key) {
        return s.getFloat(key, 0.0f);
    }

    public float getFloat(String key, float defaultValue) {
        return s.getFloat(key, defaultValue);
    }

    public long getLong(String key) {
        return s.getLong(key, 0);
    }

    public long getLong(String key, long defaultValue) {
        return s.getLong(key, defaultValue);
    }

    public String getString(String key) {
        return s.getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        return s.getString(key, defaultValue);
    }

    public BigInteger getBigInteger(String key) {
        return new BigInteger(s.getString(key, "0"));
    }

    public BigInteger getBigInteger(String key, BigInteger defaultValue) {
        return new BigInteger(s.getString(key, defaultValue.toString()));
    }

    public BigDecimal getBigDecimal(String key) {
        return new BigDecimal(s.getString(key, "0"));
    }

    public BigDecimal getBigDecimal(String key, BigInteger defaultValue) {
        return new BigDecimal(s.getString(key, defaultValue.toString()));
    }

    public Date getDate(String key) {
        return new Date(s.getLong(key, System.currentTimeMillis()));
    }

    public Date getDate(String key, Date defaultValue) {
        return new Date(s.getLong(key, defaultValue.getTime()));
    }

    public Object getObject(String key) {
        String json = s.getString(key, "");
        return gson.fromJson(json, Object.class);
    }

    @TargetApi(11)
    public Set<String> getStringSet(String key) {
        return s.getStringSet(key, null);
    }

    @TargetApi(11)
    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return s.getStringSet(key, defaultValue);
    }
}
