#!/usr/bin/env bash
# Portable bash-invoked Gradle runner that delegates to the Android app wrapper.
set -euo pipefail
REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${REPO_ROOT}/budgetbuddy_android_app"
bash "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
