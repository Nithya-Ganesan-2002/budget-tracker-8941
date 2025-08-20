#!/usr/bin/env bash
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${ROOT_DIR}/budgetbuddy_android_app"
chmod +x "${APP_DIR}/gradlew" || true
exec bash "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
