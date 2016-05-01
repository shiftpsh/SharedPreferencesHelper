package net.shiftstudios.tools.android.sharedprefs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Park Shift on 2016-05-01.
 */

public class SharedPreferencesHelper {

    private SharedPreferences s;
    private Context context;
    private Gson gson;

    /**
     * Generates a new SharedPreferencesHelper object with default SharedPreferences.
     *
     * @param context Context
     */
    public SharedPreferencesHelper(Context context) {
        this.context = context;
        this.s = PreferenceManager.getDefaultSharedPreferences(context);
        this.gson = new Gson();
    }

    /**
     * Generates a new SharedPreferencesHelper object with default SharedPreferences and a
     * gson.
     *
     * @param context Context
     * @param gson    Gson
     */
    public SharedPreferencesHelper(Context context, Gson gson) {
        this.context = context;
        this.s = PreferenceManager.getDefaultSharedPreferences(context);
        this.gson = gson;
    }

    /**
     * Generates a new SharedPreferencesHelper object with specified preferences filename.
     *
     * @param context Context
     * @param name    SharedPreferences name
     */
    public SharedPreferencesHelper(Context context, String name) {
        this.context = context;
        this.s = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    /**
     * Generates a new SharedPreferencesHelper object with specified preferences filename
     * ana a gson.
     *
     * @param context Context
     * @param name    SharedPreferences name
     * @param gson    Gson
     */
    public SharedPreferencesHelper(Context context, String name, Gson gson) {
        this.context = context;
        this.s = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.gson = gson;
    }

    /**
     * Generates a new SharedPreferencesHelper object with specified preferences filename and
     * access mode.
     *
     * @param context Context
     * @param name    SharedPreferences name
     * @param mode    Access mode
     */
    public SharedPreferencesHelper(Context context, String name, int mode) {
        this.context = context;
        this.s = context.getSharedPreferences(name, mode);
        this.gson = new Gson();
    }

    /**
     * Generates a new SharedPreferencesHelper object with specified preferences filename,
     * access mode and a gson.
     *
     * @param context Context
     * @param name    SharedPreferences name
     * @param mode    Access mode
     * @param gson    Gson
     */
    public SharedPreferencesHelper(Context context, String name, int mode, Gson gson) {
        this.context = context;
        this.s = context.getSharedPreferences(name, mode);
        this.gson = gson;
    }


    /**
     * Gets the context which this helper is using now.
     *
     * @return Context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Gets the preferences which this helper is using now.
     *
     * @return SharedPreferences
     */
    public SharedPreferences getSharedPreferences() {
        return s;
    }

    /**
     * Gets the gson which this helper is using now.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Checks if specified key is in the preferences.
     *
     * @return true if preference contains value with specified key
     */
    public boolean contains(String key) {
        return s.contains(key);
    }

    /**
     * Registers listener.
     *
     * @param listener Listener
     */
    public void registerListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        s.registerOnSharedPreferenceChangeListener(listener);
    }

    /**
     * Unregisters listener.
     *
     * @param listener Listener
     */
    public void unregisterListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        s.unregisterOnSharedPreferenceChangeListener(listener);
    }

    /**
     * Remove any value assigned with specified key.
     */
    public void remove(String key) {
        SharedPreferences.Editor e = s.edit();
        e.remove(key);
        e.commit();
    }

    /**
     * Assign a boolean value to a specified key.
     */
    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor e = s.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    /**
     * Assign a boolean array to a specified key.
     */
    public void putBooleanArray(String key, boolean[] value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key + ".arrayLength", value.length);
        e.putString(key + ".arrayType", "Boolean");

        for (int i = 0; i < value.length; i++) e.putBoolean(key + '[' + i + ']', value[i]);
        e.commit();
    }

    /**
     * Assign a integer value to a specified key.
     */
    public void putInt(String key, int value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key, value);
        e.commit();
    }

    /**
     * Assign a integer array to a specified key.
     */
    public void putIntArray(String key, int[] value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key + ".arrayLength", value.length);
        e.putString(key + ".arrayType", "Integer");

        for (int i = 0; i < value.length; i++) e.putInt(key + '[' + i + ']', value[i]);
        e.commit();
    }

    /**
     * Assign a floating point value to a specified key.
     */
    public void putFloat(String key, float value) {
        SharedPreferences.Editor e = s.edit();
        e.putFloat(key, value);
        e.commit();
    }

    /**
     * Assign a floating point array to a specified key.
     */
    public void putFloatArray(String key, float[] value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key + ".arrayLength", value.length);
        e.putString(key + ".arrayType", "Float");

        for (int i = 0; i < value.length; i++) e.putFloat(key + '[' + i + ']', value[i]);
        e.commit();
    }

    /**
     * Assign a long value to a specified key.
     */
    public void putLong(String key, long value) {
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, value);
        e.commit();
    }

    /**
     * Assign a long array to a specified key.
     */
    public void putLongArray(String key, long[] value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key + ".arrayLength", value.length);
        e.putString(key + ".arrayType", "Long");

        for (int i = 0; i < value.length; i++) e.putLong(key + '[' + i + ']', value[i]);
        e.commit();
    }

    /**
     * Assign a string value to a specified key.
     */
    public void putString(String key, String value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value);
        e.commit();
    }

    /**
     * Assign a long array to a specified key.
     */
    public void putStringArray(String key, String[] value) {
        SharedPreferences.Editor e = s.edit();
        e.putInt(key + ".arrayLength", value.length);
        e.putString(key + ".arrayType", "String");

        for (int i = 0; i < value.length; i++) e.putString(key + '[' + i + ']', value[i]);
        e.commit();
    }

    /**
     * Assign a BigInteger value to a specified key.
     */
    public void putBigInteger(String key, BigInteger value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value.toString());
        e.commit();
    }

    /**
     * Assign a BigDecimal value to a specified key.
     */
    public void putBigDecimal(String key, BigDecimal value) {
        SharedPreferences.Editor e = s.edit();
        e.putString(key, value.toString());
        e.commit();
    }

    /**
     * Assign a date value to a specified key.
     */
    public void putDate(String key, Date value) {
        SharedPreferences.Editor e = s.edit();
        e.putLong(key, value.getTime());
        e.commit();
    }

    /**
     * Assign a serializable object to a specified key.
     */
    public void putObject(String key, Object value) {
        String json = gson.toJson(value);

        SharedPreferences.Editor e = s.edit();
        e.putString(key, json);
        e.commit();
    }

    /**
     * Assign a string set to a specified key.
     */
    @TargetApi(11)
    public void putStringSet(String key, Set<String> value) {
        SharedPreferences.Editor e = s.edit();
        e.putStringSet(key, value);
        e.commit();
    }


    /**
     * Get all values stored in this preference.
     *
     * @return All values in a map
     */
    public Map<String, ?> getAll() {
        return s.getAll();
    }

    /**
     * Get a boolean value assigned to a specified key. If no value assigned, return false.
     *
     * @return false if no value assigned
     */
    public boolean getBoolean(String key) {
        return s.getBoolean(key, false);
    }

    /**
     * Get a boolean value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return s.getBoolean(key, defaultValue);
    }

    /**
     * Get a boolean array assigned to a specified key.
     *
     * @throws NullPointerException if no array assigned
     */
    public boolean[] getBooleanArray(String key) throws NullPointerException {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) throw new NullPointerException();
        if (! s.getString(key + ".arrayType", "").equals("Boolean")) throw new NullPointerException();

        boolean[] value = new boolean[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getBoolean(key + '[' + i + ']', false);
        }
        return value;
    }

    /**
     * Get a boolean array assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public boolean[] getBooleanArray(String key, boolean[] defaultValue) {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) return defaultValue;
        if (! s.getString(key + ".arrayType", "").equals("Boolean")) return defaultValue;

        boolean[] value = new boolean[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getBoolean(key + '[' + i + ']', false);
        }
        return value;
    }

    /**
     * Get a integer value assigned to a specified key. If no value assigned, return 0.
     *
     * @return 0 if no value assigned
     */
    public int getInt(String key) {
        return s.getInt(key, 0);
    }

    /**
     * Get a integer value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public int getInt(String key, int defaultValue) {
        return s.getInt(key, defaultValue);
    }

    /**
     * Get a integer array assigned to a specified key.
     *
     * @throws NullPointerException if no array assigned
     */
    public int[] getIntArray(String key) throws NullPointerException {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) throw new NullPointerException();
        if (! s.getString(key + ".arrayType", "").equals("Integer")) throw new NullPointerException();

        int[] value = new int[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getInt(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a integer array assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public int[] getIntArray(String key, int[] defaultValue) {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) return defaultValue;
        if (! s.getString(key + ".arrayType", "").equals("Integer")) return defaultValue;

        int[] value = new int[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getInt(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a floating point value assigned to a specified key. If no value assigned, return 0.0.
     *
     * @return 0.0 if no value assigned
     */
    public float getFloat(String key) {
        return s.getFloat(key, 0.0f);
    }

    /**
     * Get a floating point value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public float getFloat(String key, float defaultValue) {
        return s.getFloat(key, defaultValue);
    }

    /**
     * Get a floating point array assigned to a specified key.
     *
     * @throws NullPointerException if no array assigned
     */
    public float[] getFloatArray(String key) throws NullPointerException {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) throw new NullPointerException();
        if (! s.getString(key + ".arrayType", "").equals("Float")) throw new NullPointerException();

        float[] value = new float[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getFloat(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a floating point array assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public float[] getFloatArray(String key, float[] defaultValue) {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) return defaultValue;
        if (! s.getString(key + ".arrayType", "").equals("Float")) return defaultValue;

        float[] value = new float[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getFloat(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a long value assigned to a specified key. If no value assigned, return 0.
     *
     * @return 0 if no value assigned
     */
    public long getLong(String key) {
        return s.getLong(key, 0);
    }

    /**
     * Get a long value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public long getLong(String key, long defaultValue) {
        return s.getLong(key, defaultValue);
    }

    /**
     * Get a long array assigned to a specified key.
     *
     * @throws NullPointerException if no array assigned
     */
    public long[] getLongArray(String key) throws NullPointerException {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) throw new NullPointerException();
        if (! s.getString(key + ".arrayType", "").equals("Long")) throw new NullPointerException();

        long[] value = new long[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getLong(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a long array assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public long[] getLongArray(String key, long[] defaultValue) {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) return defaultValue;
        if (! s.getString(key + ".arrayType", "").equals("Long")) return defaultValue;

        long[] value = new long[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getLong(key + '[' + i + ']', 0);
        }
        return value;
    }

    /**
     * Get a string value assigned to a specified key. If no value assigned, return null.
     *
     * @return null if no value assigned
     */
    public String getString(String key) {
        return s.getString(key, null);
    }

    /**
     * Get a string value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public String getString(String key, String defaultValue) {
        return s.getString(key, defaultValue);
    }

    /**
     * Get a string array assigned to a specified key.
     *
     * @throws NullPointerException if no array assigned
     */
    public String[] getStringArray(String key) throws NullPointerException {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) throw new NullPointerException();
        if (! s.getString(key + ".arrayType", "").equals("String")) throw new NullPointerException();

        String[] value = new String[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getString(key + '[' + i + ']', null);
        }
        return value;
    }

    /**
     * Get a string array assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public String[] getStringArray(String key, String[] defaultValue) {
        int length = s.getInt(key + ".arrayLength", -1);
        if (length == -1) return defaultValue;
        if (! s.getString(key + ".arrayType", "").equals("String")) return defaultValue;

        String[] value = new String[length];
        for (int i = 0; i < length; i++) {
            value[i] = s.getString(key + '[' + i + ']', null);
        }
        return value;
    }

    /**
     * Get a BigInteger value assigned to a specified key. If no value assigned, return 0.
     *
     * @return 0 if no value assigned
     */
    public BigInteger getBigInteger(String key) {
        return new BigInteger(s.getString(key, "0"));
    }

    /**
     * Get a BigInteger value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public BigInteger getBigInteger(String key, BigInteger defaultValue) {
        return new BigInteger(s.getString(key, defaultValue.toString()));
    }

    /**
     * Get a BigDecimal value assigned to a specified key. If no value assigned, return 0.
     *
     * @return 0 if no value assigned
     */
    public BigDecimal getBigDecimal(String key) {
        return new BigDecimal(s.getString(key, "0"));
    }

    /**
     * Get a BigDecimal value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public BigDecimal getBigDecimal(String key, BigInteger defaultValue) {
        return new BigDecimal(s.getString(key, defaultValue.toString()));
    }

    /**
     * Get a date value assigned to a specified key. If no value assigned, return current date.
     *
     * @return Current date if no value assigned
     */
    public Date getDate(String key) {
        return new Date(s.getLong(key, System.currentTimeMillis()));
    }

    /**
     * Get a date value assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    public Date getDate(String key, Date defaultValue) {
        return new Date(s.getLong(key, defaultValue.getTime()));
    }

    /**
     * Get a object assigned to a specified key.
     *
     * @return Object
     * @throws NullPointerException if no object assigned
     */
    public Object getObject(String key) throws NullPointerException {
        String json = s.getString(key, "");
        Object object;

        try {
            object = gson.fromJson(json, Object.class);
        } catch (NullPointerException e) {
            throw e;
        }

        return object;
    }

    /**
     * Get a object assigned to a specified key and a type.
     *
     * @param type Type of the object
     * @return Object
     * @throws NullPointerException if no object assigned
     */
    public Object getObject(String key, Type type) throws NullPointerException {
        String json = s.getString(key, "");
        Object object;

        try {
            object = gson.fromJson(json, type);
        } catch (NullPointerException e) {
            throw e;
        }

        return object;
    }

    /**
     * Get a string set assigned to a specified key. If no value assigned, return null.
     *
     * @return null if no value assigned
     */
    @TargetApi(11)
    public Set<String> getStringSet(String key) {
        return s.getStringSet(key, null);
    }

    /**
     * Get a string set assigned to a specified key.
     *
     * @param defaultValue Default value
     * @return Default value if no value assigned
     */
    @TargetApi(11)
    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        return s.getStringSet(key, defaultValue);
    }
}
