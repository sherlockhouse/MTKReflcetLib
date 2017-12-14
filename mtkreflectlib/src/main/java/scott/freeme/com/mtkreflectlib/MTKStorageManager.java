package scott.freeme.com.mtkreflectlib;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.util.Log;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


public class MTKStorageManager {
    private static final String TAG = "DroiSDCardManagerEx";
    private static String Sdstate;

    public static boolean isSDCardMount(){
        final String state = getSDCardStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

    private static String getSDCardStorageState() {
        try {
            if (Environment.MEDIA_MOUNTED.equals(Sdstate)) {
                return Environment.MEDIA_MOUNTED;
            }
            return Environment.MEDIA_UNKNOWN;
        } catch (Exception e) {
            android.util.Log.e(TAG, "failed to read sd state:" + e);
            return Environment.MEDIA_REMOVED;
        }
    }


    public static String getSDCardStoragePath(Context mContext, boolean is_removale) {
        Class<?> storageVolumeClazz = null;
        try {
            StorageManager mStorageManager = (StorageManager) mContext
                    .getSystemService(Context.STORAGE_SERVICE);
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method getState = storageVolumeClazz.getMethod("getState");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                String state = (String) getState.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (is_removale == removable) {
                    Sdstate = state;
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  static  String getVolumeState(StorageManager mStorageManager, String mountPoint) {
        String result = "lala";
        try {
            Method getVolumeState = mStorageManager.getClass().getMethod("getVolumeState", String.class);
            Type[] pType = getVolumeState.getGenericParameterTypes();
            result = (String) getVolumeState.invoke(mStorageManager, mountPoint);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;

    }
    public  static String[] getVolumePaths(StorageManager mStorageManager) {
        String[] result = null;
        try {
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumePaths");
            result = (String[]) getVolumeList.invoke(mStorageManager);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;

    }
    public static boolean isSDcardHasEnoughSpace(){
        return true;
    }

    public static boolean isPhoneHasEnoughSpace(){
        return true;
    }
}

