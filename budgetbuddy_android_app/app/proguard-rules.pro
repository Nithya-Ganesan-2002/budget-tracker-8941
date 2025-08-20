# Keep rules placeholder for release builds; debug builds ignore by default.
# Keeping material and androidx classes names if needed in future.
-keep class com.google.android.material.** { *; }
-keep class androidx.** { *; }
-dontwarn org.checkerframework.**
