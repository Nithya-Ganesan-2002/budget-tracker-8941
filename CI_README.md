# CI Integration Notes

If your CI cannot locate `./gradlew` at repository root, use one of the shims:
- Linux/macOS: `bash budget-tracker-8941/build-android.sh build`
- Linux/macOS: `bash budget-tracker-8941/run-ci-gradle.sh build`
- Windows: `budget-tracker-8941\gradlew.bat build`

Alternatively, set the working directory to `budget-tracker-8941/budgetbuddy_android_app` and run:
- `./gradlew build` (Linux/macOS)
- `gradlew.bat build` (Windows)

Note: Ensure executable permissions are preserved. `.gitattributes` is configured to help, but your CI may still require `chmod +x` before invoking scripts.
