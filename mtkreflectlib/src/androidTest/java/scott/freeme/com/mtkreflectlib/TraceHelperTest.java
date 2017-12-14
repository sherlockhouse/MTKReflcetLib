package scott.freeme.com.mtkreflectlib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TraceHelperTest {
    public static final long TRACE_TAG_VIEW = 1L << 3;
    public static final long TRACE_TAG_PERF = 1L << 12;
    private static final long TRACE_DEFAULT_TAG = TRACE_TAG_VIEW;
    private static final long TARCE_PERF_TAG = TRACE_TAG_PERF;

    @Test
    public void traceBegin() throws Exception {
       TraceTest.traceBegin(TRACE_DEFAULT_TAG, ">>>>FeatureHelper-perfService Enabled");
    }

    @Test
    public void isTagEnabled() throws Exception {
        boolean b = TraceTest.isTagEnabled(TARCE_PERF_TAG);
        assertEquals(b, false);
    }
}
