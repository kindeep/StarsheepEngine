package Engine;

/*
 * 
 * Use this file to run your tests.
 */
public class StarTest {
	
	public void testFileReading() {
		Job j = StarReader.readJob(999);
		System.out.println(j.toString());
	}
}
