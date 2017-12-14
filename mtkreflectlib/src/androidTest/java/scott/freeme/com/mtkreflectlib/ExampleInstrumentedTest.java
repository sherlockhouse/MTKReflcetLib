package scott.freeme.com.mtkreflectlib;

import android.content.Context;
import android.os.storage.StorageManager;
import android.util.Log;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.storage.StorageVolume;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static final String TAG = "instrumScott";
    private Context appContext;
    private StorageManager mStorageManager;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("scott.freeme.com.mtkreflectionsample", appContext.getPackageName());
    }

    @Test
    public void getVolumePaths() throws Exception {
        String[] s = MTKStorageManager.getVolumePaths(mStorageManager);
        assertNotNull(s);
        for (String st : s) {
            Log.d(TAG, st);
        }
    }

    @Before
    public void setUp() throws Exception {
        appContext = InstrumentationRegistry.getTargetContext();
        mStorageManager = (StorageManager) appContext
                .getSystemService(Context.STORAGE_SERVICE); 

    }

    @Test
    public void getVolumeState() throws Exception {
        String[] s = MTKStorageManager.getVolumePaths(mStorageManager);
        for (String st : s) {
            String state = MTKStorageManager.getVolumeState(mStorageManager, st);
            assertNotNull(state);
            Log.d(TAG, state);
        }

    }

    @Test
    public void getDefaultPath() throws Exception {
        String str = MTKStorageManagerEx.getDefaultPath();
        assertNotNull(str);
        Log.d(TAG, str);
    }

    @Test
    public void isExternalSDCard() throws Exception {
        String[] s = MTKStorageManager.getVolumePaths(mStorageManager);
        for (String st : s) {
            boolean b = MTKStorageManagerEx.isExternalSDCard(st);
            Log.d(TAG, st + " isExternalSDCard :" + b);
        }
    }

    @Test
    public void isUSBOTG() throws Exception {
        String[] s = MTKStorageManager.getVolumePaths(mStorageManager);
        for (String st : s) {
            boolean b = MTKStorageManagerEx.isUSBOTG(st);
            Log.d(TAG, st + " isUSBOTG :" + b);
            assertEquals(b, false);
        }
    }
}
