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
     *     AhpeThread.after(10, TimeUnit.SECONDS, () -> {
     *        AhpeDialog.info("Hello World!");
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

    /**
     * Executes the {onTick} function every {intervalInMilliseconds} ms.
     * If you return <code>true</code> from the function, the thread will stop.
     * If you return <code>false</code> the thread continues.
     *
     * @param duration Duration of time to wait
     * @param unit     Unit of time to wait
     * @param onTick   Function which is executed every tick
     */
    public static Thread every(final long duration, final TimeUnit unit, final Function<Long, Boolean> onTick) {
        final Thread thread = new Thread(() -> {
            long tick = 0;
            while (true) {
                if (onTick.apply(++tick)) {
                    return;
                }
                Ahpe.yolo(() -> {
                    Thread.sleep(TimeUnit.MILLISECONDS.convert(duration, unit));
                    return null;
                });
            }
        });
        thread.start();
        return thread;
    }

    /**
     * Executes the {onTick} function every {intervalInMilliseconds} ms.
     * This method has no (inbuilt) way to stop the thread.
     *
     * @param duration Duration of time to wait
     * @param unit     Unit of time to wait
     * @param onTick   Runnable which is executed every tick
     */
    public static Thread every(final long duration, final TimeUnit unit, final Runnable onTick) {
        return AhpeThread.every(duration, unit, (tick) -> {
            onTick.run();
            return false;
        });
    }

    /**
     * Executes {onTick} every second with no way to stop.
     *
     * @param onTick Runnable to run every second
     * @return Thread
     */
    public static Thread everySecond(final Runnable onTick) {
        return AhpeThread.every(1, TimeUnit.SECONDS, onTick);
    }

    /**
     * Executes {onTick} every second. If you return <code>true</code> from {onTick}
     * the thread will stop. If you return <code>false</code> the thread continues.
     *
     * @param onTick Function to run every second
     * @return Thread
     */
    public static Thread everySecond(final Function<Long, Boolean> onTick) {
        return AhpeThread.every(1, TimeUnit.SECONDS, onTick);
    }

    /**
     * Executes {onTick} every minute with no way to stop.
     *
     * @param onTick Runnable to run every minute
     * @return Thread
     */
    public static Thread everyMinute(final Runnable onTick) {
        return AhpeThread.every(1, TimeUnit.MINUTES, onTick);
    }

    /**
     * Executes {onTick} every minute. If you return <code>true</code> from {onTick}
     * the thread will stop. If you return <code>false</code> the thread continues.
     *
     * @param onTick Function to run every minute
     * @return Thread
     */
    public static Thread everyMinute(final Function<Long, Boolean> onTick) {
        return AhpeThread.every(1, TimeUnit.MINUTES, onTick);
    }

    ///

    /**
     * Starts a countdown for {seconds} seconds.
     * Every second {onRemaining} receives the seconds remaining in the countdown.
     * If you return <code>true</code> from that function, the thread ends and the countdown stops.
     * If you return <code>false</code> the thread and the countdown continues.
     * When the countdown completes, {onDone} is executed..
     *
     * @param seconds     Seconds to run the countdown
     * @param onRemaining Function which is executed every second while the countdown is active
     * @param onDone      Runnable which is executed after the countdown ends
     */
    public static void countdownWithCondition(
            final long seconds,
            final Function<Long, Boolean> onRemaining,
            final Runnable onDone
    ) {
        final AtomicLong current = new AtomicLong();
        AhpeThread.every(1, TimeUnit.SECONDS, tick -> {
            final long remaining = seconds - current.getAndIncrement();
            if (remaining <= 0) {
                onDone.run();
                return true;
            }
            return onRemaining.apply(remaining);
        });
    }

    /**
     * Starts a countdown for {seconds} seconds.
     * Every second {onRemaining} receives the seconds remaining in the countdown.
     * When the countdown completes, {onDone} is executed..
     *
     * @param seconds     Seconds to run the countdown
     * @param onRemaining Function which is executed every second while the countdown is active
     * @param onDone      Runnable which is executed after the countdown ends
     */
    public static void countdown(
            final long seconds,
            final Consumer<Long> onRemaining,
            final Runnable onDone
    ) {
        AhpeThread.countdownWithCondition(seconds,
                remaining -> {
                    onRemaining.accept(remaining);
                    return false;
                }, onDone);
    }

    /**
     * Counts for {seconds} seconds.
     * Every second {onTick} receives the seconds the counter already counted.
     * If you return <code>true</code> from that function, the thread ends and the counter stops.
     * If you return <code>false</code> the thread and the counter continues.
     * When the counter completes, {onDone} is executed..
     *
     * @param seconds Seconds to count
     * @param onTick  Function which is executed every second while the counter is active
     * @param onDone  Runnable which is executed after the counter completes
     */
    public static void countWithCondition(
            final long seconds,
            final Function<Long, Boolean> onTick,
            final Runnable onDone
    ) {
        AhpeThread.countdownWithCondition(seconds,
                remaining -> onTick.apply(seconds - remaining),
                onDone
        );
    }

    /**
     * Counts for {seconds} seconds.
     * Every second {onTick} receives the seconds the counter already counted..
     * When the counter completes, {onDone} is executed..
     *
     * @param seconds Seconds to count
     * @param onTick  Runnable which is executed every second while the counter is active
     * @param onDone  Runnable which is executed after the counter completes
     */
    public static void count(
            final long seconds,
            final Consumer<Long> onTick,
            final Runnable onDone
    ) {
        AhpeThread.countdown(seconds,
                remaining -> onTick.accept(seconds - remaining),
                onDone
        );
    }

}
