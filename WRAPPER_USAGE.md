# Gradle Wrapper Usage in CI

Some CI environments invoke `./gradlew` from the container workspace root.
This repository keeps the wrapper under:
- budget-tracker-8941/budgetbuddy_android_app/gradlew

If you cannot change CI working directory, use:
- bash budget-tracker-8941/budgetbuddy_android_app/gradlew -p budget-tracker-8941/budgetbuddy_android_app build

A convenience forwarder also exists:
- bash budget-tracker-8941/.gradlew-forwarder.sh build
