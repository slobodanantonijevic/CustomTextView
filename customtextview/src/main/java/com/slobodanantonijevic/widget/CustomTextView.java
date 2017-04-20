package com.slobodanantonijevic.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import  android.support.v7.widget.AppCompatTextView;

/**
 * Created by slobodan on 4/20/17.
 */

public class CustomTextView extends AppCompatTextView {

    public FontManager fontMgr;

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (fontMgr == null) {

            AssetManager assets = context.getAssets();
            fontMgr.init(assets);
        }

        if (isInEditMode()) {

            return;
        }

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.font);

        if (ta != null) {

            String fontAsset = String.format("fonts/%s", ta.getString(R.styleable.font_fontTypeFaceAsset));

            try {

                Typeface tf = fontMgr.getInstance().getFont(fontAsset);
                int style = Typeface.NORMAL;
//                float size = getTextSize();

                if (getTypeface() != null) {

                    style = getTypeface().getStyle();
                }

                if (tf != null) {

                    setTypeface(tf, style);
                }

            } catch (Exception e) {
                Log.w("CustomTextView", String.format("Could not create a font from asset: %s", fontAsset));
                e.printStackTrace();
            }
        }
    }
}
