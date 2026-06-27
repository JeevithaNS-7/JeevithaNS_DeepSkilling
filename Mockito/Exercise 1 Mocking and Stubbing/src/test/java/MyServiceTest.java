import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Step 1: Create Mock Object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the Method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Pass Mock Object
        MyService service = new MyService(mockApi);

        // Call Method
        String result = service.fetchData();

        // Verify Result
        assertEquals("Mock Data", result);
    }
}