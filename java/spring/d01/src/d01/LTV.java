package d01;

public class LTV implements Tv {

	@Override
	public void powerOn() {
		System.out.println("LTV PowerOn");

	}

	@Override
	public void powerOff() {
		System.out.println("LTV PowerOff");

	}

	@Override
	public void volumeUp() {
		System.out.println("LTV Volume On");

	}

	@Override
	public void volumeDown() {
		System.out.println("LTV Volume Off");

	}

}
