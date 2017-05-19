package utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import com.apec.dispatcher.R;

import java.util.Random;

public class Utils {

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static int getRandomColor(Context context) {
        int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        return randomAndroidColor;
    }

    public static Drawable getRandomDrawableBg(Context mContext) {
        Drawable imgbgDrawable = mContext.getResources().getDrawable(R.drawable.bg_circle);
        imgbgDrawable.setColorFilter(Utils.getRandomColor(mContext), PorterDuff.Mode.MULTIPLY);
        return imgbgDrawable;
    }



}