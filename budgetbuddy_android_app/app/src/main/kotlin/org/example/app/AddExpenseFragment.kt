package org.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import org.example.app.data.SqliteExpenseRepository

/**
 * PUBLIC_INTERFACE
 * AddExpenseFragment
 * Minimal form to capture expense details and persist via SQLite repository (offline-first).
 */
class AddExpenseFragment : Fragment() {

    private lateinit var inputAmount: TextInputEditText
    private lateinit var inputCategory: TextInputEditText
    private lateinit var inputNote: TextInputEditText
    private lateinit var btnSave: MaterialButton
    private lateinit var repository: SqliteExpenseRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = SqliteExpenseRepository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputAmount = view.findViewById(R.id.inputAmount)
        inputCategory = view.findViewById(R.id.inputCategory)
        inputNote = view.findViewById(R.id.inputNote)
        btnSave = view.findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val amountStr = inputAmount.text?.toString()?.trim().orEmpty()
            val category = inputCategory.text?.toString()?.trim().orEmpty()
            val note = inputNote.text?.toString()?.trim().orEmpty()

            val amount = amountStr.toDoubleOrNull()
            if (amount == null || category.isEmpty()) {
                Snackbar.make(view, "Please provide a valid amount and category.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rowId = repository.save(
                amount = amount,
                category = category,
                note = if (note.isBlank()) null else note,
                timestamp = System.currentTimeMillis()
            )

            val message = if (rowId > 0) "Expense saved." else "Failed to save expense."
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
            if (rowId > 0) {
                inputAmount.setText("")
                inputCategory.setText("")
                inputNote.setText("")
            }
        }
    }
}
