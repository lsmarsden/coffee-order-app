package org.lsmarsden.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordHasherTest {

    private PasswordHasher underTest;

    @Test
    void hashPassword() {

        // set up
        underTest = new PasswordHasher();

        // exercise
        String hashedPassword = underTest.hashPassword("passwordToHash");

        // verify
        assertThat(hashedPassword).isEqualTo("hsaHoTdrowssap");
    }
}