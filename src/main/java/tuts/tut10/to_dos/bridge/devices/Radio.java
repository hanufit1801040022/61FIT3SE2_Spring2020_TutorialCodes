package tuts.tut10.to_dos.bridge.devices;

public class Radio implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;

	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	// TO-DO: Implement getVolume() method
	@Override
	public int getVolume() {
		return volume;
	}

	// TO-DO: Implement setVolume() method
	@Override
	public void setVolume(int volume) {
		// use 'if-elseif-else' structure to limit the volume from 0 to 100
		// outside the range is invalid
		if (volume >= 0 && volume <= 100) {
			this.volume = volume;
		}
	}

	// TO-DO: Implement getChannel() method
	@Override
	public int getChannel() {
		return channel;
	}

	// TO-DO: Implement setChannel() method
	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	// TO-DO: Implement printStatus() method
	@Override
	public void printStatus() {
		// Show the current device is TV
		System.out.println("Current device: Radio");

		// Show the current status: enabled or disabled
		System.out.println("Status: " + (on ? "Turned on" : "Not turned on"));

		// Show the current volume
		System.out.println("Current volume: " + volume);

		// Show the current channel
		System.out.println("Current channel: " + channel);
	}
}
