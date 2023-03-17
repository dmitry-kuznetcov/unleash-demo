package com.bsf.unleashdemo.persistense;

import com.bsf.unleashdemo.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
}
