package com.bsf.unleashdemo.service;

import com.bsf.unleashdemo.model.Expense;
import com.bsf.unleashdemo.persistense.ExpensesRepository;
import io.getunleash.Unleash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesRepository expensesRepository;
    private final Unleash unleash;
    public static final String SAVE_EXPENSES_FF = "SAVE_EXPENSES_FF";

    public ExpensesServiceImpl(ExpensesRepository expensesRepository, Unleash unleash) {
        this.expensesRepository = expensesRepository;
        this.unleash = unleash;
    }

    @Override
    public Expense addExpense(Expense expense) {
        if (unleash.isEnabled(SAVE_EXPENSES_FF)) {
            return expensesRepository.save(expense);
        } else throw new RuntimeException("Feature flag SAVE_EXPENSES_FF is not enabled!");
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expensesRepository.findAll();
    }
}
