#!/usr/bin/env bash
set -euo pipefail
# Helper to run Gradle from workspace root to avoid path issues in CI
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${SCRIPT_DIR}/budgetbuddy_android_app"
exec "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
