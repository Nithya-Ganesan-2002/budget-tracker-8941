package org.example.app.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

/**
 * PUBLIC_INTERFACE
 * SqliteExpenseRepository
 * Repository using SQLiteOpenHelper to persist and query expenses offline.
 */
class SqliteExpenseRepository(context: Context) {

    private val helper = LocalDbHelper(context.applicationContext)

    // PUBLIC_INTERFACE
    fun save(amount: Double, category: String, note: String?, timestamp: Long): Long {
        /** Inserts an expense and returns the row ID. */
        val db = helper.writableDatabase
        val values = ContentValues().apply {
            put("amount", amount)
            put("category", category)
            put("note", note)
            put("timestamp", timestamp)
        }
        return db.insert("expenses", null, values)
    }

    // PUBLIC_INTERFACE
    fun listRecent(limit: Int = 20): List<Triple<Double, String, String?>> {
        /** Returns a recent list of expenses (amount, category, note). */
        val db = helper.readableDatabase
        val result = mutableListOf<Triple<Double, String, String?>>()
        val cursor: Cursor = db.query(
            "expenses",
            arrayOf("amount", "category", "note"),
            null,
            null,
            null,
            null,
            "timestamp DESC",
            limit.toString()
        )
        cursor.use {
            while (it.moveToNext()) {
                val amount = it.getDouble(0)
                val category = it.getString(1)
                val note = if (!it.isNull(2)) it.getString(2) else null
                result.add(Triple(amount, category, note))
            }
        }
        return result
    }

    // PUBLIC_INTERFACE
    fun clearAll(): Int {
        /** Deletes all expenses (for testing/dev). Returns rows deleted. */
        val db = helper.writableDatabase
        return db.delete("expenses", null, null)
    }
}
