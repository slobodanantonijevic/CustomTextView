## CustomTextView ##
An android lib for customizable TextView for Android

![MIT License](https://img.shields.io/github/license/mashape/apistatus.svg) ![api 16+](https://img.shields.io/badge/API-16%2B-green.svg)

## Example ##
![](/read_me/example.png)

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

Adding a custom widget in `xml` :
```xml
<com.slobodanantonijevic.widget.CustomTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="25.0sp"
        custom:fontTypeFaceAsset="fontawesome-webfont.ttf"
        android:text="@string/fa_font" />
```

Enjoy :D
