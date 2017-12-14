package scott.freeme.com.mtkreflectlib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MTKStorageManagerEx {


    public static String getDefaultPath() {
        String result = "";
        try {
            Class mStorageManagerEx = Class.forName("com.mediatek.storage.StorageManagerEx");
            Method getDefaultPath = mStorageManagerEx.getMethod("getDefaultPath");
            result = (String)getDefaultPath.invoke(mStorageManagerEx);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean isExternalSDCard(String path) {
        boolean result = false;
        try {
            Class mStorageManagerEx = Class.forName("com.mediatek.storage.StorageManagerEx");
            Method isExternalSDCard = mStorageManagerEx.getMethod("isExternalSDCard", String.class);
            result = (boolean)isExternalSDCard.invoke(mStorageManagerEx, path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean isUSBOTG(String path) {
        boolean result = false;
        try {
            Class mStorageManagerEx = Class.forName("com.mediatek.storage.StorageManagerEx");
            Method isUSBOTG = mStorageManagerEx.getMethod("isUSBOTG", String.class);
            result = (boolean)isUSBOTG.invoke(mStorageManagerEx, path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
