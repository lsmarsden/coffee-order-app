package org.lsmarsden.util;

import java.time.LocalDateTime;

public class TimeProvider implements ITimeProvider {
    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}
