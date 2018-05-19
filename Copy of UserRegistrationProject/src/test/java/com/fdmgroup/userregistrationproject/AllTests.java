package com.fdmgroup.userregistrationproject;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FileReadAndWriteCommandTest.class, UserTest.class,UserFactoryTest.class,RegistrationControllerTest.class, })
public class AllTests {

}


