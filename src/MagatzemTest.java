import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MagatzemTest {

    @Test
    void testArticuloNormal() {
        Article poma = new Article("Poma", 10, 20);
        Magatzem m = new Magatzem(new Article[]{poma});
        m.actualitzarEstat();
        assertEquals(9, poma.diesPerVendre);
        assertEquals(19, poma.qualitat);
    }

    @Test
    void testFormatgeGidurat() {
        Article formatge = new Article("Formatge Gidurat", 10, 20);
        Magatzem m = new Magatzem(new Article[]{formatge});
        m.actualitzarEstat();
        assertEquals(9, formatge.diesPerVendre);
        assertEquals(21, formatge.qualitat);
    }

    @Test
    void testMartellDeThor() {
        Article martell = new Article("Martell de Thor (Llegendari)", 10, 80);
        Magatzem m = new Magatzem(new Article[]{martell});
        m.actualitzarEstat();
        assertEquals(10, martell.diesPerVendre); // No cambia
        assertEquals(80, martell.qualitat);       // No cambia
    }

    @Test
    void testEntradesConcert() {
        Article entrades = new Article("Entrades per al Concert del Trobador", 5, 20);
        Magatzem m = new Magatzem(new Article[]{entrades});
        m.actualitzarEstat();
        assertEquals(4, entrades.diesPerVendre);
        assertEquals(23, entrades.qualitat); // Sube +3 porque quedan <= 5 días
    }
}