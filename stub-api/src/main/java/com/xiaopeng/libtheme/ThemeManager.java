package com.xiaopeng.libtheme;

import android.R;
import android.app.IUiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
@SuppressWarnings("unused")
public class ThemeManager {
    public static final boolean DEBUG;
    public static final String  KEY_APPEND = "extra_append";
    public static final String  KEY_GLOBAL = "extra_global";

    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_NO   = 1;
    public static final int MODE_NIGHT_YES  = 2;

    private static final String  TAG = "ThemeManager";
    public static final  boolean THEME;

    public static final long THEME_ANIMATION_INTERVAL = 1;
    public static final long THEME_TIMEOUT_DELAY      = 1;
    public static final int  UI_MODE_NIGHT_UNDEFINED  = 0;
    public static final int  UI_MODE_NIGHT_MASK       = 48;
    public static final int  UI_MODE_NIGHT_YES        = 32;
    public static final int  UI_MODE_NIGHT_NO         = 16;
    public static final int  UI_MODE_THEME_CLEAR      = 63;
    public static final int  UI_MODE_THEME_MASK       = 192;
    public static final int  UI_MODE_THEME_UNDEFINED  = 0;

    public static final int VERSION = 3;

    private Context mContext;

    static {
        THEME = SystemProperties.getInt("persist.sys.theme.logger", 0) == 1;
        DEBUG = THEME;
    }

    private ThemeManager(Context context, View root, String xml, List<ThemeView> list) {
        throw new RuntimeException("Stub!");
    }

    public static ThemeManager create(Context context, View root, String xml, List<ThemeView> list) {
        throw new RuntimeException("Stub!");
    }

    public void onConfigurationChanged(Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    public static boolean isThemeChanged(Configuration newConfig) {
        throw new RuntimeException("Stub!");
    }

    public static int getThemeMode(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static int getDayNightMode(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static int getDayNightAutoMode(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static int getUiMode(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static boolean isNightMode(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static boolean isThemeWorking(Context context) {
        throw new RuntimeException("Stub!");
    }

    public static void applyThemeMode(Context context, int themeMode) {
        throw new RuntimeException("Stub!");
    }

    public static void applyDayNightMode(Context context, int daynightMode) {
        throw new RuntimeException("Stub!");
    }

    public static IUiModeManager getUiModeManager() {
        throw new RuntimeException("Stub!");
    }

    public static void setWindowBackgroundResource(Configuration newConfig, Window window, int resId) {
        throw new RuntimeException("Stub!");
    }

    public static void setWindowBackgroundDrawable(Configuration newConfig, Window window, Drawable drawable) {
        throw new RuntimeException("Stub!");
    }

    public static HashMap<String, Integer> resolveAttribute(Context context, android.util.AttributeSet attrs) {
        throw new RuntimeException("Stub!");
    }

    public static HashMap<String, Integer> resolveAttribute(Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes, HashMap<String, List<String>> extras) {
        throw new RuntimeException("Stub!");
    }

    public static void setAttributeValue(HashMap<String, Integer> map, String attr, int resId) {
        throw new RuntimeException("Stub!");
    }

    public static void updateAttribute(View view, HashMap<String, Integer> map) {
        throw new RuntimeException("Stub!");
    }

    public static class Logger {
        public static void log(String msg) {
            throw new RuntimeException("Stub!");
        }

        public static void log(String tag, String msg) {
            throw new RuntimeException("Stub!");
        }
    }

    public static class ViewBuilder {
        private List<ThemeView> list = new ArrayList();

        private ViewBuilder() {
            this.list.clear();
        }

        public static ViewBuilder create() {
            return new ViewBuilder();
        }

        public ViewBuilder add(int resId, String resAttr, int resValue) {
            return add(resId, resAttr, -1, resValue);
        }

        public ViewBuilder add(int resId, String resAttr, int resRoot, int resValue) {
            throw new RuntimeException("Stub!");
        }

        public List<ThemeView> get() {
            throw new RuntimeException("Stub!");
        }
    }

    public static class ResourceType {
        public static final int                      ANIM          = 0;
        public static final int                      ARRAY         = 1;
        public static final int                      ATTR          = 2;
        public static final int                      BOOL          = 3;
        public static final int                      COLOR         = 4;
        public static final int                      DIMEN         = 5;
        public static final int                      DRAWABLE      = 6;
        public static final int                      ID            = 7;
        public static final int                      INTEGER       = 8;
        public static final int                      LAYOUT        = 9;
        public static final int                      MIPMAP        = 10;
        public static final int                      STRING        = 11;
        public static final int                      STYLE         = 12;
        public static final int                      STYLEABLE     = 13;
        public static final HashMap<String, Integer> sResourceType = new HashMap<>();

        static {
            sResourceType.clear();
            sResourceType.put("anim", 0);
            sResourceType.put("array", 1);
            sResourceType.put("attr", 2);
            sResourceType.put("bool", 3);
            sResourceType.put("color", 4);
            sResourceType.put("dimen", 5);
            sResourceType.put("drawable", 6);
            sResourceType.put("id", 7);
            sResourceType.put("integer", 8);
            sResourceType.put("layout", 9);
            sResourceType.put("mipmap", 10);
            sResourceType.put("string", 11);
            sResourceType.put(AttributeSet.STYLE, 12);
            sResourceType.put("styleable", 13);
        }

        public static int getType(String type) {
            if (TextUtils.isEmpty(type)) {
                return -1;
            }
            int ret = sResourceType.get(type).intValue();
            return ret;
        }
    }

    public static class AttributeSet {
        public static final String                   ALPHA                    = "alpha";
        public static final String                   BACKGROUND               = "background";
        public static final String                   BUTTON                   = "button";
        public static final String                   DIVIDER                  = "divider";
        public static final String                   DRAWABLE_BOTTOM          = "drawableBottom";
        public static final String                   DRAWABLE_END             = "drawableEnd";
        public static final String                   DRAWABLE_LEFT            = "drawableLeft";
        public static final String                   DRAWABLE_RIGHT           = "drawableRight";
        public static final String                   DRAWABLE_START           = "drawableStart";
        public static final String                   DRAWABLE_TOP             = "drawableTop";
        public static final String                   FOREGROUND               = "foreground";
        public static final String                   PROGRESS_DRAWABLE        = "progressDrawable";
        public static final String                   SCROLLBAR_THUMB_VERTICAL = "scrollbarThumbVertical";
        public static final String                   SRC                      = "src";
        public static final String                   STYLE                    = "style";
        public static final String                   TEXT_COLOR               = "textColor";
        public static final String                   TEXT_COLOR_HINT          = "textColorHint";
        public static final String                   THEME                    = "theme";
        public static final String                   THUMB                    = "thumb";
        public static final HashMap<String, Integer> sAttributeMap            = new HashMap<>();

        static {
            sAttributeMap.clear();
            sAttributeMap.put(STYLE, 0);
            sAttributeMap.put(THEME, Integer.valueOf(R.attr.theme));
            sAttributeMap.put(ALPHA, Integer.valueOf(R.attr.alpha));
            sAttributeMap.put(FOREGROUND, Integer.valueOf(R.attr.foreground));
            sAttributeMap.put(BACKGROUND, Integer.valueOf(R.attr.background));
            sAttributeMap.put(SCROLLBAR_THUMB_VERTICAL, Integer.valueOf(R.attr.scrollbarThumbVertical));
            sAttributeMap.put(SRC, Integer.valueOf(R.attr.src));
            sAttributeMap.put(TEXT_COLOR, Integer.valueOf(R.attr.textColor));
            sAttributeMap.put(TEXT_COLOR_HINT, Integer.valueOf(R.attr.textColorHint));
            sAttributeMap.put(DRAWABLE_LEFT, Integer.valueOf(R.attr.drawableLeft));
            sAttributeMap.put(DRAWABLE_TOP, Integer.valueOf(R.attr.drawableTop));
            sAttributeMap.put(DRAWABLE_RIGHT, Integer.valueOf(R.attr.drawableRight));
            sAttributeMap.put(DRAWABLE_BOTTOM, Integer.valueOf(R.attr.drawableBottom));
            sAttributeMap.put(DRAWABLE_START, Integer.valueOf(R.attr.drawableStart));
            sAttributeMap.put(DRAWABLE_END, Integer.valueOf(R.attr.drawableEnd));
            sAttributeMap.put(PROGRESS_DRAWABLE, Integer.valueOf(R.attr.progressDrawable));
            sAttributeMap.put(THUMB, Integer.valueOf(R.attr.thumb));
            sAttributeMap.put(BUTTON, Integer.valueOf(R.attr.button));
            sAttributeMap.put(DIVIDER, Integer.valueOf(R.attr.divider));
        }

        public static boolean hasAttribute(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return sAttributeMap.containsKey(attr);
            }
            return false;
        }

        public static boolean isThemeAttribute(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return THEME.equals(attr);
            }
            return false;
        }

        public static boolean isStyleAttribute(String attr) {
            if (!TextUtils.isEmpty(attr)) {
                return STYLE.equals(attr);
            }
            return false;
        }

        public static boolean supportTransition(String attr) {
            if (TextUtils.isEmpty(attr)) {
                return false;
            }
            return BACKGROUND.equals(attr) || SRC.equals(attr) || TEXT_COLOR.equals(attr);
        }
    }
}