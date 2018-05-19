package com.fdmgroup.serialization;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BackpackTest.class, ShieldTest.class, WizardSerializerTest.class,
		WizardTest.class })
public class AllTests {

}
