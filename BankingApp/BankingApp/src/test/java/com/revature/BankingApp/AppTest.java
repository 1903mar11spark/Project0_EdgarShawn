package com.revature.BankingApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.revature.beans.Customer;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.util.ConnectionUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{
    
	private static final CustomerDAO evaluationCustomerDAO = new CustomerDAOImpl();
	private static final AccountDAO evaluationAccountDAO = new AccountDAOImpl();
	private static Connection con = null;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
//	@Test
//	public void testCreateUserP1() throws IOException, SQLException {
//		con = ConnectionUtil.getConnection();
//		con.setAutoCommit(false);
//		Customer user = new Customer(1, "Leonel", "Messi", "padilla157", "12345");
//		assertEquals(1, evaluationCustomerDAO.createUser(user, con));
//	
//	
	
}
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }

