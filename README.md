# BudgetBuddy Workspace

This workspace contains the BudgetBuddy Android app in the `budgetbuddy_android_app` folder.

How to build locally:
- Change directory into the Android app root:
  cd budget-tracker-8941/budgetbuddy_android_app
- Build:
  ./gradlew build
- Install debug:
  ./gradlew :app:installDebug

If CI uses a different working directory, invoke the wrapper using the path:
  bash budget-tracker-8941/budgetbuddy_android_app/gradlew -p budget-tracker-8941/budgetbuddy_android_app build
