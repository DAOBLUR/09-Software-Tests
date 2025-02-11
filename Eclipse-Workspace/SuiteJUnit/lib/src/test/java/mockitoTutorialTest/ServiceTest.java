package mockitoTutorialTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mockitoTutorial.*;

@ExtendWith(MockitoExtension.class)                         
class ServiceTest {

    @Mock
    Database databaseMock;                                  

    @Test
    public void testQuery()  {
        assertNotNull(databaseMock);
        when(databaseMock.isAvailable()).thenReturn(true);  
        Service t  = new Service(databaseMock);             
        boolean check = t.query("* from t");                
        assertTrue(check);
    }
}