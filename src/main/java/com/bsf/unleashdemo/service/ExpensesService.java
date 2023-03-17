package com.bsf.unleashdemo.service;

import com.bsf.unleashdemo.model.Expense;

import java.util.List;

public interface ExpensesService {
    Expense addExpense(Expense expense);
    List<Expense> getAllExpenses();
}
