#!/usr/bin/env bash
set -euo pipefail

echo "[CI] Repo root: $(pwd)"
echo "[CI] Listing relevant paths..."
ls -la .
echo "[CI] Attempting to invoke module gradle wrapper..."

APP_DIR="budget-tracker-8941/budgetbuddy_android_app"
WRAPPER="${APP_DIR}/gradlew"

if [ ! -f "${WRAPPER}" ]; then
  echo "[CI][ERROR] Gradle wrapper not found at ${WRAPPER}."
  echo "[CI][HINT] Ensure working_directory is budget-tracker-8941/budgetbuddy_android_app or call:"
  echo "  bash budget-tracker-8941/build.sh build"
  exit 127
fi

chmod +x "${WRAPPER}" || true
echo "[CI] Executing: bash ${WRAPPER} -p ${APP_DIR} ${*:-build}"
exec bash "${WRAPPER}" -p "${APP_DIR}" ${*:-build}
