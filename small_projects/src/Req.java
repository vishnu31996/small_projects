

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert.*;

import junit.framework.Assert;

public class Req {
	PrintStream old ;
	ByteArrayOutputStream baos;
	
	public Req(){
		 baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		 old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
	}
	
	public void grade() {
		String cmp="p1(x) = 0.0\n"
				+ "p2(x) = 3.6x^4 + 2.5x^3 - 2.5x^2 + 3.6\n"
				+ "p3(x) = 2.0x^5 - 4.0\n"
				+ "p21(x) = 3.6x^4 + 2.5x^3 - 2.5x^2 + 3.6".trim();
		
		System.out.flush();
		System.setOut(old);
		String txt=baos.toString().trim();
		// Show what happened
		System.out.println(txt);
		
		if(txt.equals(cmp))
		{
			System.out.println("----------PASS--------");
		}else {
			System.err.println("----------FAIL-------");

		}
	//	assertEquals(txt, cmp);

		
	}
}
