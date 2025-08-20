# Building BudgetBuddy Android

If your environment cannot find `./gradlew` at the repository root, use the provided Makefile targets:

- make -C budget-tracker-8941 build-android
- make -C budget-tracker-8941 install-debug

These targets delegate to the Android app’s Gradle wrapper at:
budget-tracker-8941/budgetbuddy_android_app/gradlew
