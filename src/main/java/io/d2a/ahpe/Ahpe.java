package io.d2a.ahpe;

public class Ahpe {

    /**
     * If you don't really care about _any_ exceptions, you can use this.
     *
     * @param action The action which may throws exceptions
     * @param <T>    Type of result
     * @return Result of the action
     */
    public static <T> YoloResult<T> yolo(final YoloAction<T> action) {
        try {
            return new YoloResult<T>(action.yolo(), null);
        } catch (final Exception ex) {
            System.out.println("[AHPE] Exception when running action. See stacktrace below.");
            ex.printStackTrace();
            return new YoloResult<>(null, ex);
        }
    }

    ///

    public static class YoloResult<T> {

        private final T result;
        public final Exception exception;

        public YoloResult(final T result, final Exception exception) {
            this.result = result;
            this.exception = exception;
        }

        public T orElse(final T orElse) {
            if (this.result != null) {
                return this.result;
            }
            return orElse;
        }

        public T nil() {
            return this.result;
        }

    }

    public interface YoloAction<T> {
        T yolo() throws Exception;
    }

}
