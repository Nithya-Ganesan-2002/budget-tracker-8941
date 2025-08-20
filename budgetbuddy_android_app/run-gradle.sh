#!/usr/bin/env bash
set -euo pipefail
# Ensure this script runs the Gradle wrapper from the app directory regardless of caller CWD.
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
exec "${SCRIPT_DIR}/gradlew" -p "${SCRIPT_DIR}" "$@"
