package rocks.zipcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class NotezTest {
    /**
     * Rigorous Test.
     */

    Notez notez = new Notez();
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    public void addToCategoryTest(){
        //Given
        String general = "General";
        String note = "go to store";


        //When
        notez.addToCategory(general,note);

        //Then
        assertTrue(notez.getFilemap().get(general).size() == 1);
    }

    @Test
    public void removeNote(){
        String todo = "ToDo";
        String note = "go to the store";
        int indexToRemove = 1;

        notez.addToCategory(todo,note);
        notez.removeNote(todo,indexToRemove);

        assertTrue(notez.getFilemap().get(todo).size() == 0);
    }
}
