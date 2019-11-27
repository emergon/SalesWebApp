package dao;

import entities.Salesman;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tasos
 */
public class SalesmanDaoTest {
    
    private SalesmanDao sdao;
    
    public SalesmanDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sdao = new SalesmanDao();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class SalesmanDao.
     */
    @Test
    public void testCreate() {
    }

    /**
     * Test of findAll method, of class SalesmanDao.
     */
    @Test
    public void testFindAll() {
        List<Salesman> list = sdao.findAll();
        assertTrue(list.size()>0);
    }

    /**
     * Test of findById method, of class SalesmanDao.
     */
    @Test
    public void testFindById() {
    }

    /**
     * Test of update method, of class SalesmanDao.
     */
    @Test
    public void testUpdate() {
    }

    /**
     * Test of delete method, of class SalesmanDao.
     */
    @Test
    public void testDelete() {
    }
    
}
