package com.db.edu.query;

import com.db.edu.exceptions.EndOfSessionException;
import com.db.edu.exceptions.QueryProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExitQueryTest {

    @Test
    public void shouldThrowEndOfSessionExceptionWhenClientSendExitMessage() {
        assertThrows(EndOfSessionException.class, () -> new ExitQuery(null));
    }

    @Test
    public void shouldThrowQueryProcessingExceptionWhenClientSendNotEmptyExitMessage() {
        assertThrows(QueryProcessingException.class, () -> new ExitQuery("Hi"));
    }
}