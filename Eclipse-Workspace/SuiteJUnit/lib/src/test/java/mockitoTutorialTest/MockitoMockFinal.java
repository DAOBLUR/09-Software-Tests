package mockitoTutorialTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mockitoTutorial.*;

@ExtendWith(MockitoExtension.class)
public class MockitoMockFinal {


    @Test
    public void testMockFinal(@Mock FinalClass finalMocked)  {
        assertNotNull(finalMocked);
    }

    @Test
    public void testMockFinalViaMockStatic()  {
        MockedStatic<FinalClass> mockStatic = Mockito.mockStatic(FinalClass.class);
        assertNotNull(mockStatic);
    }
}