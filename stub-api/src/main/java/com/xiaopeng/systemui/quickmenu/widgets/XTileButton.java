package com.xiaopeng.systemui.quickmenu.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

@SuppressWarnings("unused")
public class XTileButton extends FrameLayout {

    public static final int HORIZONTAL = 1;
    public static final int VERTICAL   = 0;

    public XTileButton(Context context) {
        this(context, null);
    }

    public XTileButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XTileButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public XTileButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) throws Resources.NotFoundException {
        super(context, attrs, defStyleAttr, defStyleRes);
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    public void setImageLevel(int level) {
        throw new RuntimeException("Stub!");
    }

    public void refreshTheme() throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw new RuntimeException("Stub!");
    }

    private void init() throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        throw new RuntimeException("Stub!");
    }

    private void startAnimate(float beginValue, float endValue, Interpolator interpolator) {
        throw new RuntimeException("Stub!");
    }

    public void setImageResource(int iconRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTextRes(int textRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTitleRes(int textRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTitleColor(int color) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    public void setBackgroundRes(int backgroundRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTextColor(int colorResId) throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        throw new RuntimeException("Stub!");
    }

    private void setChildSelected(ViewGroup viewGroup, boolean selected) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    private void setChildEnabled(ViewGroup viewGroup, boolean enabled) {
        throw new RuntimeException("Stub!");
    }

    public void setRightCornerSignShow() {
        throw new RuntimeException("Stub!");
    }

    public void setWidthHeight(int width, int height) {
        throw new RuntimeException("Stub!");
    }

    public void setLarge() throws Resources.NotFoundException {
        throw new RuntimeException("Stub!");
    }

    public void setImageGone(boolean ifGone) {
        throw new RuntimeException("Stub!");
    }
}
