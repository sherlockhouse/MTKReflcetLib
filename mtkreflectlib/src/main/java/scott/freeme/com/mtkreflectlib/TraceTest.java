package scott.freeme.com.mtkreflectlib;

import android.os.Trace;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by server on 17-8-31.
 */

public class TraceTest {

    public static void  traceBegin(long traceTag, String methodName) {
        try {
            Method mTraceBegin = Trace.class.getMethod("traceBegin", long.class, String.class);
            mTraceBegin.invoke(Trace.class, traceTag, methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void  traceEnd(long traceTag) {
        try {
            Method mTraceBegin = Trace.class.getMethod("traceEnd", long.class);
            mTraceBegin.invoke(Trace.class, traceTag);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void traceCounter(long traceTag, String counterName, int counterValue) {
        try {
            Method mTraceBegin = Trace.class.getMethod("traceCounter", long.class, String.class, int.class);
            mTraceBegin.invoke(Trace.class, traceTag, counterName, counterValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return;
    }

    public static boolean isTagEnabled(long traceTag) {
        boolean result = false;
        try {
            Method mTraceBegin = Trace.class.getMethod("isTagEnabled", long.class);
            mTraceBegin.invoke(Trace.class, traceTag);
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
