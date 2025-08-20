package org.example.app.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * PUBLIC_INTERFACE
 * LocalDbHelper
 * Minimal SQLiteOpenHelper for offline-first storage without annotation processing.
 */
class LocalDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    DB_NAME,
    null,
    DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS expenses (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "amount REAL NOT NULL, " +
                "category TEXT NOT NULL, " +
                "note TEXT, " +
                "timestamp INTEGER NOT NULL" +
            ");"
        )
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_expenses_timestamp ON expenses(timestamp)")
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_expenses_category ON expenses(category)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // For initial versions, destructive migration
        db.execSQL("DROP TABLE IF EXISTS expenses")
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "budgetbuddy.db"
        private const val DB_VERSION = 1
    }
}
