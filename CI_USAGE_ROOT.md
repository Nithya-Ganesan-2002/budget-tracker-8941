# CI Usage (Root)

If your CI cannot find ./gradlew at the repository root, use this script:

- bash budget-tracker-8941/build-android.sh build

Other available options:
- bash budget-tracker-8941/run-ci-gradle.sh build
- bash budget-tracker-8941/gradle.sh build

Or set the working directory to:
- budget-tracker-8941/budgetbuddy_android_app
Then run:
- ./gradlew build
