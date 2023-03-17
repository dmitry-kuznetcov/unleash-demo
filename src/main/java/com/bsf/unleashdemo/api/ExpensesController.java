package com.bsf.unleashdemo.api;

import com.bsf.unleashdemo.model.Expense;
import com.bsf.unleashdemo.service.ExpensesService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @PostMapping("/expenses.json")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense, @RequestHeader(name = "USER-ID") String userId) {
        return new ResponseEntity<>(expensesService.addExpense(expense), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/expenses.json")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return new ResponseEntity(expensesService.getAllExpenses(), HttpStatusCode.valueOf(200));
    }
}
