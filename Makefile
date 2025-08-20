# Simple CI-friendly targets for the Android app
APP_DIR := $(CURDIR)/budgetbuddy_android_app
GRADLEW := $(APP_DIR)/gradlew

.PHONY: build-android install-debug clean-android

build-android:
	@chmod +x "$(GRADLEW)" || true
	@bash "$(GRADLEW)" -p "$(APP_DIR)" build

install-debug:
	@chmod +x "$(GRADLEW)" || true
	@bash "$(GRADLEW)" -p "$(APP_DIR)" :app:installDebug

clean-android:
	@chmod +x "$(GRADLEW)" || true
	@bash "$(GRADLEW)" -p "$(APP_DIR)" clean
