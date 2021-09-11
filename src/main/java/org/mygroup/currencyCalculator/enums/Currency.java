package org.mygroup.currencyCalculator.enums;
/**
 * Enumeration that represents available currencies to exchange.
 *
 * @author  Samvel Ghazaryan
 * @version 1.0
 * */
public enum Currency {
    AMD() {
        @Override
        public String description() {
            return this.name() + "  Armenian Dram";
        }
    },
    USD() {
        @Override
        public String description() {
            return this.name() + "  US Dollar";
        }
    },
    RUB() {
        @Override
        public String description() {
            return this.name() + "  Russian Ruble";
        }
    },
    EUR() {
        @Override
        public String description() {
            return this.name() + "  Euro";
        }
    };

    Currency() {
    }

    public String description() {
        return this.name();
    }
}
