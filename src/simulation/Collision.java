package simulation;

public abstract class Collision extends AbstractEvent{
    
    /**
     * Constructor for Collision
     */
	private Particle[] p;
	private int[] col;
	
    public Collision(double t, Particle[] ps) {
        // TODO implement constructor
    	super(t);
    	this.p = ps;
    	col = new int[p.length];
    	for(int i = 0; i < p.length; i++) {
    		Particle a = p[i];
    		col[i] = a.collisions();
    	}
   
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // TODO implement his method
    	for(int i = 0; i < p.length; i++) {
    		Particle a = p[i];
    		if(a.collisions() != col[i]) {
    			return false;
    		}
 
    	}
        return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {
        // TODO implement this method
        return p;
    }
}
