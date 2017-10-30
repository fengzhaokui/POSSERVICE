package xb.posservice.test;

public class test {

	private int a=0;
	public void add()
	{
		System.out.println(a);
		a=a+10;
		//adda(a);
		System.out.println(a);
		System.gc();
	}
	
	private void adda(int b)
	{
		b=b+10;
	}
	
}
