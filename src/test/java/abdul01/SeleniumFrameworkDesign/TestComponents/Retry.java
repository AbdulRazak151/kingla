package abdul01.SeleniumFrameworkDesign.TestComponents;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
//Failed test cases to re-run
	int count=0;
	int maxTry=1;
	
	
	@Override
	public boolean retry(ITestResult result) {
	 if(count<maxTry) {
		 count++;
		 return true;
	 }
		return false;
	}

}
