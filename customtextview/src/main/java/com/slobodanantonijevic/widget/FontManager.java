package com.slobodanantonijevic.widget;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by slobodan on 4/20/17.
 */

public class FontManager {
    private static FontManager instance;

    private AssetManager mMgr;

    private Map<String, Typeface> fonts;

    private FontManager(AssetManager mgr) {

        this.mMgr = mgr;
        fonts = new HashMap<String, Typeface>();
    }

    public static void init(AssetManager mgr) {

        instance = new FontManager(mgr);
    }

    public static FontManager getInstance() {

        return instance;
    }

    public Typeface getFont(String asset) {

        if (fonts.containsKey(asset)) {

            return fonts.get(asset);
        }

        Typeface font = null;

        try {

            font = Typeface.createFromAsset(mMgr, asset);
            fonts.put(asset, font);
        } catch (Exception e) {

            Log.w("FontManager", "Failed to create Type Face from asset!");
        }

        if (font == null) {

            try {

                String fixedAsset = fixAssetFilename(asset);
                font = Typeface.createFromAsset(mMgr, fixedAsset);
                fonts.put(asset, font);
                fonts.put(fixedAsset, font);
            } catch (Exception e) {

                Log.w("FontManager", "Something went wrong adding the font to cache!");
            }
        }

        return font;
    }

    private String fixAssetFilename(String asset) {
        // Empty font filename?
        // Just return it. We can't help.
        if ((asset == null) || asset.trim().equals("")) {

            return asset;
        }

        // Make sure that the font ends in '.ttf'
        if (!asset.endsWith(".ttf")) {

            asset = String.format("%s.ttf", asset);
        }

        return asset;
    }
}