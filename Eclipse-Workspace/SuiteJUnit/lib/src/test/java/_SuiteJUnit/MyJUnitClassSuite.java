package _SuiteJUnit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import _TestPackage.*;

@Suite
@SelectClasses({
	AccountTest.class, StringsTest.class
})
public class MyJUnitClassSuite { }