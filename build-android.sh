#!/usr/bin/env bash
# Universal entry-point for CI to build the Android app from repo root.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${ROOT_DIR}/budgetbuddy_android_app"
WRAPPER="${APP_DIR}/gradlew"

# Ensure wrapper is executable (CI FS may drop +x)
chmod +x "${WRAPPER}" 2>/dev/null || true

# Execute build
exec bash "${WRAPPER}" -p "${APP_DIR}" "$@"
