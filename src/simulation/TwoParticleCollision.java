package simulation;

public class TwoParticleCollision extends Collision{

	public TwoParticleCollision(Particle p1, Particle p2, double t) {
		
		super(t, new Particle[] {p1,p2});
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void happen(ParticleEventHandler h) {
		// TODO Auto-generated method stub
		Particle[] a = this.getParticles();
		Particle b1 = a[0];
		Particle b2 = a[1];
		Particle.collide(b1, b2);
		h.reactTo(this);
	}
	
}
