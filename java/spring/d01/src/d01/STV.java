package d01;

public class STV implements Tv {

	@Override
	public void powerOn() {
		System.out.println("STV PowerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("STV PowerOff");

	}

	@Override
	public void volumeUp() {
		System.out.println("STV Volume On");

	}

	@Override
	public void volumeDown() {
		System.out.println("STV Volume Off");

	}

}
