#!/usr/bin/env bash
# Robust Gradle wrapper shim for CI environments that invoke ./gradlew from repo root.
set -euo pipefail
ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
APP_DIR="${ROOT_DIR}/budgetbuddy_android_app"
# Make sure the module wrapper is executable
chmod +x "${APP_DIR}/gradlew" || true
exec "${APP_DIR}/gradlew" -p "${APP_DIR}" "$@"
