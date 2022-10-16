package io.d2a.swag.placeholder;

public interface PlaceholderCallback {

    void onShowPlaceholder();

    void onHidePlaceholder();

    static PlaceholderCallback dummy() {
        return new PlaceholderCallback() {
            @Override
            public void onShowPlaceholder() {

            }

            @Override
            public void onHidePlaceholder() {

            }
        };
    }

}
