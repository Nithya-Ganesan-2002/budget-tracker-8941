# CI Usage

Preferred way to build the Android app from the repository root (works regardless of the current working directory):

- bash budget-tracker-8941/run-ci-gradle.sh build

To install the debug app:

- bash budget-tracker-8941/run-ci-gradle.sh :app:installDebug

Note:
- This repository uses a declarative Gradle Android sample located in `budget-tracker-8941/budgetbuddy_android_app`.
- The script ensures the Gradle wrapper is invoked from the correct location and has the executable bit set.
