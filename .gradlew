#!/usr/bin/env sh
# CI shim to delegate Gradle wrapper calls from repository root to the Android app module wrapper.
# Uses /bin/sh for maximum portability in minimal CI shells.
set -eu
SCRIPT_DIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
APP_DIR="${SCRIPT_DIR}/budgetbuddy_android_app"
# Ensure the wrapper is executable (ignore errors if FS doesn't support chmod)
chmod +x "${APP_DIR}/gradlew" 2>/dev/null || true
exec "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
