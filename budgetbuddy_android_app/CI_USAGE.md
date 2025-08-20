# CI usage for Gradle wrapper

To build from repository root without changing directories:
- bash budget-tracker-8941/budgetbuddy_android_app/run-gradle.sh build

To install the debug app:
- bash budget-tracker-8941/budgetbuddy_android_app/run-gradle.sh :app:installDebug

Note: Ensure executable bit is set (CI typically preserves it). If needed:
- chmod +x budget-tracker-8941/budgetbuddy_android_app/gradlew
- chmod +x budget-tracker-8941/budgetbuddy_android_app/run-gradle.sh
