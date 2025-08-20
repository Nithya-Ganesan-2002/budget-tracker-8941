androidApplication {
    namespace = "org.example.app"

    dependencies {
        // AndroidX core and appcompat for modern Android APIs
        implementation("androidx.core:core-ktx:1.13.1")
        implementation("androidx.appcompat:appcompat:1.7.0")

        // Material Components for BottomNavigationView and theming
        implementation("com.google.android.material:material:1.12.0")

        // Fragment KTX for fragment transactions and lifecycle
        implementation("androidx.fragment:fragment-ktx:1.8.2")

        // ConstraintLayout for layouts
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")

        // RecyclerView for lists on dashboard/reports
        implementation("androidx.recyclerview:recyclerview:1.3.2")

        // Optional lifecycle
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

        // Keep existing sample deps if needed by current test scaffolding
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
    }
}
