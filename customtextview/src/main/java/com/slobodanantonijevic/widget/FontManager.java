/**
 *
 * MIT License
 *
 * Copyright (c) 2017 Slobodan Antonijević
 * https://github.com/slobodanantonijevic/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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