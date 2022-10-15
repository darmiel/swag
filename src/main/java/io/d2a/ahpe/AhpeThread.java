package io.d2a.ahpe;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

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

    ///

    public static void interval(final long interval, final Function<Long, Boolean> onTick) {
        new Thread(() -> {
            long tick = 0;
            while (true) {
                if (onTick.apply(++tick)) {
                    return;
                }
                Ahpe.yolo(() -> {
                    Thread.sleep(interval);
                    return null;
                });
            }
        }).start();
    }

    public static void interval(final long interval, final Runnable onTick) {
        AhpeThread.interval(interval, (tick) -> {
            onTick.run();
            return false;
        });
    }

    public static void everySecond(final Runnable onTick) {
        AhpeThread.interval(1000, onTick);
    }

    public static void everySecond(final Function<Long, Boolean> onTick) {
        AhpeThread.interval(1000, onTick);
    }

    public static void everyMinute(final Runnable onTick) {
        AhpeThread.interval(60_000, onTick);
    }

    public static void everyMinute(final Function<Long, Boolean> onTick) {
        AhpeThread.interval(60_000, onTick);
    }

    ///

    public static void intervalForSecondsWithCondition(
            final long durationInSeconds,
            final Function<Long, Boolean> onRemaining,
            final Runnable onDone
    ) {
        final AtomicLong current = new AtomicLong();
        AhpeThread.interval(1000, tick -> {
            final long remaining = durationInSeconds - current.getAndIncrement();
            if (remaining <= 0) {
                onDone.run();
                return true;
            }
            return onRemaining.apply(remaining);
        });
    }

    public static void intervalForSeconds(
            final long durationInSeconds,
            final Consumer<Long> onRemaining,
            final Runnable onDone
    ) {
        AhpeThread.intervalForSecondsWithCondition(durationInSeconds,
                remaining -> {
                    onRemaining.accept(remaining);
                    return false;
                }, onDone);
    }


}
