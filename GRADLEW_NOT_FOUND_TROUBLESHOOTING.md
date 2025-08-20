# Troubleshooting: ./gradlew not found

If your CI logs show:
  bash: line 1: ./gradlew: No such file or directory

This typically means Gradle is being invoked from the wrong working directory.

Working paths:
- Android app wrapper path: budget-tracker-8941/budgetbuddy_android_app/gradlew

Options to fix:
1) Set CI working_directory to: budget-tracker-8941/budgetbuddy_android_app
   Then run: ./gradlew build

2) From repository root, run:
   bash budget-tracker-8941/build.sh build
   or
   bash budget-tracker-8941/.ci-build.sh

3) From container workspace root (budget-tracker-8941), run:
   ./gradlew build  (this shim forwards to app wrapper)

If permissions are an issue, add:
  chmod +x budget-tracker-8941/budgetbuddy_android_app/gradlew
