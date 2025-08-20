#!/usr/bin/env bash
# Forwarder used by CI that insists on running ./gradlew from the container workspace root.
set -euo pipefail
exec bash budget-tracker-8941/budgetbuddy_android_app/gradlew -p budget-tracker-8941/budgetbuddy_android_app "$@"
