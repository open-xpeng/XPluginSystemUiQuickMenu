package com.xiaopeng.systemui.quickmenu.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes24.dex */
@SuppressWarnings("unused")
public class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        throw new RuntimeException("Stub!");
    }

    private int getDimensionOrInt(TypedArray a, int index, int defValue) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        throw new RuntimeException("Stub!");
    }

    private int getHorizontalGravityOffsetForRow(int horizontalGravity, int parentWidth, int horizontalPadding, int row) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public boolean isFlow() {
        throw new RuntimeException("Stub!");
    }

    public void setFlow(boolean flow) {
        throw new RuntimeException("Stub!");
    }

    public int getChildSpacing() {
        throw new RuntimeException("Stub!");
    }

    public void setChildSpacing(int childSpacing) {
        throw new RuntimeException("Stub!");
    }

    public int getChildSpacingForLastRow() {
        throw new RuntimeException("Stub!");
    }

    public void setChildSpacingForLastRow(int childSpacingForLastRow) {
        throw new RuntimeException("Stub!");
    }

    public float getRowSpacing() {
        throw new RuntimeException("Stub!");
    }

    public void setRowSpacing(float rowSpacing) {
        throw new RuntimeException("Stub!");
    }

    public int getMaxRows() {
        throw new RuntimeException("Stub!");
    }

    public void setMaxRows(int maxRows) {
        throw new RuntimeException("Stub!");
    }

    public void setGravity(int gravity) {
        throw new RuntimeException("Stub!");
    }

    public void setRowVerticalGravity(int rowVerticalGravity) {
        throw new RuntimeException("Stub!");
    }

    public boolean isRtl() {
        throw new RuntimeException("Stub!");
    }

    public void setRtl(boolean rtl) {
        throw new RuntimeException("Stub!");
    }

    public int getMinChildSpacing() {
        throw new RuntimeException("Stub!");
    }

    public void setMinChildSpacing(int minChildSpacing) {
        throw new RuntimeException("Stub!");
    }

    public int getRowsCount() {
        throw new RuntimeException("Stub!");
    }

    private float getSpacingForRow(int spacingAttribute, int rowSize, int usedSize, int childNum) {
        throw new RuntimeException("Stub!");
    }

    private float dpToPx(float dp) {
        throw new RuntimeException("Stub!");
    }
}
