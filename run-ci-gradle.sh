#!/usr/bin/env bash
set -euo pipefail
# CI-safe Gradle runner that delegates to the Android app's Gradle wrapper with explicit path.
REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${REPO_ROOT}/budgetbuddy_android_app"
# Ensure wrapper is executable (some CI systems may not preserve exec bit)
chmod +x "${APP_DIR}/gradlew" || true
exec bash "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
