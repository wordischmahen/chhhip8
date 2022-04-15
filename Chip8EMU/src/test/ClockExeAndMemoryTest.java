package test;

import java.io.IOException;
import main.Chip8;
import util.Chip8Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClockExeAndMemoryTest {
	
	private Chip8 chip8;
	
	@Before
	public void loadMemory() throws IOException {
		this.chip8 = Chip8Utils.createFromRom(ClockExeAndMemoryTest.class.getResource("/TestRom"));
	}
	
	@Test
	public void testCycle() {
		chip8.cycle();
		chip8.cycle();
		chip8.cycle();
		chip8.cycle();
		Assert.assertEquals(0x15, chip8.getV0());
		Assert.assertEquals(0x20, chip8.getV1());
		Assert.assertEquals(0x25, chip8.getV2());
		Assert.assertEquals(0x30, chip8.getV3());
		Assert.assertEquals(0x208, chip8.getPC());
	}

}
