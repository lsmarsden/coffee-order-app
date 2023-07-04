package util;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TimeProviderTest {

    private TimeProvider underTest;

    private LocalDateTime now = LocalDateTime.now();

    @Test
    void getCurrentDateTime() {

        try (MockedStatic<LocalDateTime> mock = Mockito.mockStatic(LocalDateTime.class)) {
            // set up
            underTest = new TimeProvider();
            mock.when(LocalDateTime::now).thenReturn(now);

            // exercise & verify
            assertThat(underTest.getCurrentDateTime()).isEqualTo(now);
        }
    }
}