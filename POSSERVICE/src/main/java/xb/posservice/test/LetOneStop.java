package xb.posservice.test;

import java.util.HashMap;
import java.util.HashSet;

import xb.posservice.test.Animal.Calltoback;

public class LetOneStop implements Calltoback {

    // 动物对象
    Animal an;
    
    // 获取动物对象，可以传入兔子或乌龟的实例
    public LetOneStop(Animal an) {
        this.an = an;
    }
    
    //让动物的线程停止
   // @Override
    public void win() {
        // 线程停止
       // an.stop();
    	an.isrun=false;
    }
    
    public class aaa
    {
    	HashMap map=new HashMap();
		HashSet set=new HashSet();
    	
    	public void aa()
    	{
    		set.add("123");
    		
    	}
    	
    }
     
}


