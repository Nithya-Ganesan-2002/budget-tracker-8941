package org.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * PUBLIC_INTERFACE
 * MainActivity
 * This is the single-activity host for BudgetBuddy. It sets up a BottomNavigationView and
 * switches between Dashboard, Add Expense, and Reports fragments.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the main content view which includes a container and bottom navigation
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNav)

        // Default fragment
        if (savedInstanceState == null) {
            switchToFragment(DashboardFragment())
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> {
                    switchToFragment(DashboardFragment()); true
                }
                R.id.nav_add -> {
                    switchToFragment(AddExpenseFragment()); true
                }
                R.id.nav_reports -> {
                    switchToFragment(ReportsFragment()); true
                }
                else -> false
            }
        }
    }

    // PUBLIC_INTERFACE
    private fun switchToFragment(fragment: Fragment) {
        /** Switches the content to the provided fragment in the container. */
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, fragment::class.java.simpleName)
            .commit()
    }
}
