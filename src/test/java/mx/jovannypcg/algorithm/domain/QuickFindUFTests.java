package mx.jovannypcg.algorithm.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class QuickFindUFTests {
    private static final int N = 10;
    private QuickFindUF quickFindUF;

    @Before
    public void init() {
        quickFindUF = new QuickFindUF(N);
    }

    @Test
    public void algorithmIsProperlyInstantiated() {
        assertNotNull("Algorithm implementation was not correctly instantiated", quickFindUF);
        assertEquals("ID size does not match", N, quickFindUF.idSize());
    }

    @Test
    public void pointIsConnectedToItself() {
        for (int i = 0; i < N; i++) {
            assertTrue(quickFindUF.connected(i, i));
        }
    }

    @Test
    public void nonePointsAreConnectedAtTheBeginning() {
        for (int i = 0; i < N - 1; i++) {
            for (int j =  i + 1; j < N; j++) {
                assertFalse(quickFindUF.connected(i, j));
            }
        }
    }

    @Test
    public void testQuickConnected() {
        System.out.println(quickFindUF);


    }

    @Test
    public void testQuickUnion() {
        System.out.println("Initial: " + quickFindUF);

        System.out.println("Union 3, 4");
        quickFindUF.quickUnion(3, 4);
        System.out.println("Result: " + quickFindUF);
        assertTrue(quickFindUF.quickConnected(3, 4));

        System.out.println("Union 7, 9");
        quickFindUF.quickUnion(7, 9);
        System.out.println("Result: " + quickFindUF);
        assertTrue(quickFindUF.quickConnected(7, 9));

        System.out.println("Union 7, 4");
        quickFindUF.quickUnion(7, 4);
        System.out.println("Result: " + quickFindUF);
        assertTrue(quickFindUF.quickConnected(7, 4));
    }
}
