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

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by slobodan on 4/20/17.
 */

public class FontManager {

    private static final String TAG = "FontManager";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context context, String assetPath) {

        synchronized (cache) {

            if (!cache.containsKey(assetPath)) {

                try {

                    Typeface typeFace = Typeface.createFromAsset(context.getAssets(), assetPath);

                    cache.put(assetPath, typeFace);
                } catch (Exception e) {

                    Log.w(TAG, "Could not get typeface '" + assetPath + "' because of " + e.getMessage());
                    return null;
                }
            }

            return cache.get(assetPath);
        }
    }
}