#!/usr/bin/env bash
# CI-safe build entrypoint: always use the app module's Gradle wrapper via absolute path.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${ROOT_DIR}/budgetbuddy_android_app"
WRAPPER="${APP_DIR}/gradlew"
# Ensure wrapper is executable; ignore errors if FS disallows chmod
chmod +x "${WRAPPER}" 2>/dev/null || true
exec bash "${WRAPPER}" -p "${APP_DIR}" "$@"
