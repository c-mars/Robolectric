package c.mars.robo1;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLaunch() {
        MainActivity activity= Robolectric.setupActivity(MainActivity.class);

        Button button= (Button) activity.findViewById(R.id.b);
        TextView textView= (TextView) activity.findViewById(R.id.t);

        button.performClick();
        assertEquals(textView.getText().toString(), "a");

        Intent expectedIntent = new Intent(activity, NewActivity.class);
        assertThat(Shadows.shadowOf(activity).getNextStartedActivity(), is(equalTo(expectedIntent)));
    }
}