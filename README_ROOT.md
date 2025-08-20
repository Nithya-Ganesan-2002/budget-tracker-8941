# BudgetBuddy Monorepo Root

This repository includes an Android app located in:
- budget-tracker-8941/budgetbuddy_android_app

Build from repository root:
- ./gradlew build
  (This uses a root-level shim that delegates to the Android app’s Gradle wrapper.)

Alternate:
- bash budget-tracker-8941/run-ci-gradle.sh build

If you run into permission issues:
- chmod +x budget-tracker-8941/budgetbuddy_android_app/gradlew
- chmod +x budget-tracker-8941/run-ci-gradle.sh
