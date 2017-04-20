## CustomTextView ##
An android lib that (for now only) enables adding a custom font from XML layout

Plans exist to further enhance this library, but that'll happen when there's more spare time :)

Please read the guide and if in doubt do not hesitate to fire the question

Please do check the Example app provided in this repository if you have any doubts on how to use the lib, and also if you have any suggestions.

![MIT License](https://img.shields.io/github/license/mashape/apistatus.svg) ![api 16+](https://img.shields.io/badge/API-16%2B-green.svg)

## Example ##
![](/read_me/eg.png)

## Adding to project ##

### Sdk Version ###
`compileSdkVersion` >= 25

### Importing to project ###

#### Example for Gradle: ####

Step 1. Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Step 2. Add the dependency
```groovy
compile 'com.github.slobodanantonijevic:CustomTextView:1.0.1'
```

## Getting started ##

Adding a font .ttf to your project in
```groovy
assets/fonts/fontawesome-webfont.ttf
```

### Adding a custom widget in `xml` ###
First make sure you import namespace for custom views in your layout's root view, eg:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:custom="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

...

</LinearLAyout>
```
Then you can use fontTypeFaceAsset in your CustomTextView:
```xml
<com.slobodanantonijevic.widget.CustomTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="25.0sp"
        custom:fontTypeFaceAsset="fontawesome-webfont.ttf"
        android:text="@string/fa_font" />
```

Enjoy :D

```
MIT License

Copyright (c) 2017 Slobodan Antonijević

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
