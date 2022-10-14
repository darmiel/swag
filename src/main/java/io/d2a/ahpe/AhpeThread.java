package io.d2a.ahpe;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AhpeThread {

    /**
     * Runs a runnable after a specified amount of time.
     * <p>
     * Example: Open a dialog after 10s:
     * <pre>
     *     ApheThread.after(10, TimeUnit.SECONDS, () -> {
     *        ApheDialog.info("Hello World!");
     *     });
     * </pre>
     *
     * @param duration Duration of time to wait
     * @param unit     Unit of time to wait
     * @param runnable Runnable to execute after time
     */
    public static void after(final long duration, final TimeUnit unit, final Runnable runnable) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runnable.run();
            }
        }, TimeUnit.MILLISECONDS.convert(duration, unit));
    }

}
