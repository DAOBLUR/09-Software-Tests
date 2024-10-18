package _SuiteJUnit;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
	"_TestPackage"
})
public class MyJUnitPackageSuite {

}
