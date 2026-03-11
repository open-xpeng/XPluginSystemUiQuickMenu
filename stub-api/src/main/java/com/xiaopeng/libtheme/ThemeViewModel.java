package com.xiaopeng.libtheme;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class ThemeViewModel {
    private HashMap<String, Integer> mAttributeSet;
    private List<OnCallback>         mCallbacks = new ArrayList();

    private OnCallback mCallback;
    private int        mUiMode;

    public interface OnCallback {
        void onThemeChanged();
    }

    private ThemeViewModel(Context context, HashMap<String, Integer> attributes) {
        throw new RuntimeException("Stub!");
    }

    public static ThemeViewModel create(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static ThemeViewModel create(Context context, AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public static ThemeViewModel create(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        throw new RuntimeException("Stub!");
    }

    public static ThemeViewModel create(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, Object extras) {
        throw new RuntimeException("Stub!");
    }

    public static List<String> asList(String... value) {
        throw new RuntimeException("Stub!");
    }

    public static HashMap<String, List<String>> asMaps(String key, String... value) {
        throw new RuntimeException("Stub!");
    }

    public static HashMap<String, List<String>> asMaps(String key, List<String> list) {
        throw new RuntimeException("Stub!");
    }

    public static HashMap<String, List<String>> getExtra(Object extras) {
        throw new RuntimeException("Stub!");
    }

    public void setCallback(OnCallback callback) {
        throw new RuntimeException("Stub!");
    }

    public void addCallback(OnCallback callback) {
        throw new RuntimeException("Stub!");
    }

    public void removeCallback(OnCallback callback) {
        throw new RuntimeException("Stub!");
    }

    public void onAttachedToWindow(View view) {
        throw new RuntimeException("Stub!");
    }

    public void onDetachedFromWindow(View view) {
        throw new RuntimeException("Stub!");
    }

    public void onWindowFocusChanged(View view, boolean hasWindowFocus) {
        throw new RuntimeException("Stub!");
    }

    public void onWindowVisibilityChanged(View view, int visibility) {
        throw new RuntimeException("Stub!");
    }

    public void onConfigurationChanged(View view, Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    public void setTextColor(int resid) {
        throw new RuntimeException("Stub!");
    }

    public void setBackground(Drawable background) {
        throw new RuntimeException("Stub!");
    }

    public void setBackgroundColor(int color) {
        throw new RuntimeException("Stub!");
    }

    public void setBackgroundResource(int resid) {
        throw new RuntimeException("Stub!");
    }

    public void setBackgroundDrawable(Drawable background) {
        throw new RuntimeException("Stub!");
    }

    public void setImageBitmap(Bitmap bm) {
        throw new RuntimeException("Stub!");
    }

    public void setImageResource(int resid) {
        throw new RuntimeException("Stub!");
    }

    public void setImageDrawable(Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    public void setThemeAttribute(String attr, int resid) {
        throw new RuntimeException("Stub!");
    }

    private boolean isUiModeChanged(int uiMode) {
        throw new RuntimeException("Stub!");
    }

    private void updateThemeResource(View view) {
        throw new RuntimeException("Stub!");
    }

    private String getAttrInfo() {
        throw new RuntimeException("Stub!");
    }

    private String getViewInfo(View view) {
        throw new RuntimeException("Stub!");
    }
}