import org.junit.*;
import static org.junit.Assert.*;

public class CharacterTest {

@Test                                                 
    public void test_use_duplicate() {
       
    Character Bob = new Character("Bob"); 
    String item = "gun";
    Bob.use(item);
    assertSame(Bob.itemUsing.indexOf(item), Bob.itemUsing.lastIndexOf(item));
                

    
}
}
