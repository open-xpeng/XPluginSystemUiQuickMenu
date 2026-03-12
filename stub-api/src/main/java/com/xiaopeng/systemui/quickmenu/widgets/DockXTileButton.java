package com.xiaopeng.systemui.quickmenu.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaopeng.libtheme.ThemeViewModel;

/* loaded from: classes24.dex */
@SuppressWarnings("unused")
public class DockXTileButton extends FrameLayout {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL   = 0;

    private static final long  PRESS_DURATION = 100;
    private static final float SCALE_RULES    = 0.97f;

    private int     mBackground;
    private int     mImage;
    private boolean mIsLarge;
    private int     mOrientation;
    private String  mText;
    private int     mTextColor;

    ImageView      mImageView;
    ImageView      mRightCornerSign;
    ObjectAnimator mScaleXAnimator;
    ObjectAnimator mScaleYAnimator;
    TextView       mTextView;
    ThemeViewModel mThemeViewModel;
    View           mTileLayout;

    public DockXTileButton(Context context) {
        this(context, null);
    }

    public DockXTileButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DockXTileButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DockXTileButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        throw new RuntimeException("Stub!");
    }

    public void setImageLevel(int level) {
        throw new RuntimeException("Stub!");
    }

    public void refreshTheme() {
        throw new RuntimeException("Stub!");
    }

    private void init() {
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

    public void setImageResource(int iconRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTextRes(int textRes) {
        throw new RuntimeException("Stub!");
    }

    public void setBackgroundRes(int backgroundRes) {
        throw new RuntimeException("Stub!");
    }

    public void setTextColor(int color) {
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
}