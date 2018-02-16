package simulation;

public class Tick extends AbstractEvent {
	
	public Tick(double tick) {
		super(tick);
	}

	@Override
	public void happen(ParticleEventHandler h) {
		// TODO Auto-generated method stub
		h.reactTo(this);
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
}
