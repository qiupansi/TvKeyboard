package com.psqiu.keyboard;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

public class Utils {

    public static float scale = 1.03f;
    public static int duration = 600;
    
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    public static Drawable getCompoundDrawable(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context,R.drawable.ic_check_circle_black_24dp);
        // 需要设置图片的大小才能显示
        drawable.setBounds(0, 0, Utils.dp2px(context, 24), Utils.dp2px(context, 24));
        return drawable;
    }

    public static void setFocusHighLight(final View view, final TimeInterpolator interpolator, boolean alpha) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (interpolator != null) {
                        view.animate().setInterpolator(interpolator).scaleX(scale).scaleY(scale).setDuration(duration).start();
                    } else {
                        view.animate().scaleX(scale).scaleY(scale).setDuration(duration).start();
                    }
                } else {
                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(duration).start();
                }
            }
        });
    }

}
