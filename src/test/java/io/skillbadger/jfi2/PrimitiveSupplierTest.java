package io.skillbadger.jfi2;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimitiveSupplierTest {

    @Test
    void explicitSupplier() {

        IntSupplier supplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                return 0;
            }
        };

        int result = supplier.getAsInt();
        assertEquals(0, result);

    }

    @Test
    void lambdaSupplier() {

        IntSupplier lambdaSupplier = () -> 0;

        int result = lambdaSupplier.getAsInt();
        assertEquals(0, result);

    }

}
