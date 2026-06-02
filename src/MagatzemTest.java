import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MagatzemTest {
    @Test
    void testArticuloNormal() {
        Article poma = new Article("Poma", 10, 20);
        Magatzem m = new Magatzem(new Article[]{poma});
        m.actualitzarEstat();
        
        assertEquals(9, poma.getDiesPerVendre());
        assertEquals(19, poma.getQualitat());
    }

    @Test
    void testFormatgeGidurat() {
        Article formatge = new Article("Formatge Gidurat", 10, 20);
        Magatzem m = new Magatzem(new Article[]{formatge});
        m.actualitzarEstat();
        
        assertEquals(9, formatge.getDiesPerVendre());
        assertEquals(21, formatge.getQualitat());
    }
}