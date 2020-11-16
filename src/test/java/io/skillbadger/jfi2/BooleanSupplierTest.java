package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BooleanSupplierTest {

    @Test
    void explicitSupplier() {

        BooleanSupplier supplier = new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                return true;
            }
        };

        boolean result = supplier.getAsBoolean();
        assertEquals(true, result);

    }

    @Test
    void lambdaSupplier() {

        BooleanSupplier supplier = () -> true;

        boolean result = supplier.getAsBoolean();
        assertEquals(true, result);

    }

}
