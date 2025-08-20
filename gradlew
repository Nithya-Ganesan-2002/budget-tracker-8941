#!/usr/bin/env sh
# Workspace-root Gradle wrapper shim delegating to the Android app's wrapper (POSIX sh).
# CI appears to call ./gradlew from budget-tracker-8941/, so forward to app wrapper.
set -eu
APP_DIR="budgetbuddy_android_app"
WRAPPER="$APP_DIR/gradlew"
# Ensure wrapper is executable where possible
chmod +x "$WRAPPER" 2>/dev/null || true
exec "$WRAPPER" -p "$APP_DIR" "$@"
