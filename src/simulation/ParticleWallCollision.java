package simulation;

public class ParticleWallCollision extends Collision {
	
	private Wall w;
	
	public ParticleWallCollision(Particle p, Wall w, double time) {
		super(time, new Particle[] {p});
		this.w = w;
	}
	@Override
	public void happen(ParticleEventHandler h) {
		// TODO Auto-generated method stub
		Particle[] a = this.getParticles();
		Particle b = a[0];
		Particle.collide(b, w);
		h.reactTo(this);
	}
	
}
