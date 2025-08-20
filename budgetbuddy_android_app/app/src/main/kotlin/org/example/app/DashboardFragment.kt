package org.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.example.app.data.SqliteExpenseRepository
import org.example.app.ui.RecentExpensesAdapter

/**
 * PUBLIC_INTERFACE
 * DashboardFragment
 * Displays a summary and a list of recent expenses loaded from local SQLite.
 */
class DashboardFragment : Fragment() {

    private lateinit var list: RecyclerView
    private lateinit var repository: SqliteExpenseRepository
    private val adapter = RecentExpensesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = SqliteExpenseRepository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onResume() {
        super.onResume()
        // Refresh list on resume in case user added new expense
        val recent = repository.listRecent(limit = 50)
        val items = recent.map { triple ->
            RecentExpensesAdapter.Item(
                amount = triple.first,
                category = triple.second,
                note = triple.third
            )
        }
        adapter.submitList(items)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view.findViewById(R.id.recentList)
        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = adapter
    }
}
