package org.example.Exo2;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class TaxSystem {

    private double income;

    public void pay(TaxStrategy taxStrategy){taxStrategy.calculateTax(income);}

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
