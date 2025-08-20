#!/usr/bin/env bash
set -euo pipefail
echo "[HINT] Your CI likely isn't running from the Android app directory."
echo "[HINT] Try one of these from repo root:"
echo "  bash budget-tracker-8941/build.sh build"
echo "  bash budget-tracker-8941/.ci-build.sh"
echo "[HINT] Or set working_directory to: budget-tracker-8941/budgetbuddy_android_app and run ./gradlew"
exit 127
