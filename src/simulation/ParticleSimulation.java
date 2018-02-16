package simulation;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;
import utils.List;

public class ParticleSimulation implements Runnable, ParticleEventHandler{

    private static final long FRAME_INTERVAL_MILLIS = 40;
    
    private final ParticlesModel          model;
    private final ParticlesView           screen;
    private double clock;
    private MinPriorityQueue queue;
    
    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        // TODO implement constructor
    	this.model = m;
    	this.screen = new ParticlesView(name, m);
    	MinPriorityQueue<Event> queue = new MinPriorityQueue();
    	this.queue = queue;
    	Tick tick = new Tick(1.0);
    	queue.add(tick);
    	Iterable<Collision> cs = m.predictAllCollisions(0.0);
    	for(Collision c : cs) {
    		queue.add(c);
    	}
    	this.clock = 0.0;
    }
   
   

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // TODO complete implementing this method
        while(!queue.isEmpty()) {
        	Event e = (Event) queue.remove();
        	if(e.isValid()) {
        		double prev = clock;
        		clock = e.time();
        		model.moveParticles(clock-prev);
        		e.happen(this);
        	}
        } 	
    }

	@Override
	public void reactTo(Tick tick) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(FRAME_INTERVAL_MILLIS);
		}
		catch(InterruptedException e) {
			 System.out.println("got interrupted!");	
		}
		screen.update();
		Tick tic = new Tick(clock + 1.0);
		queue.add(tic);
	}

	@Override
	public void reactTo(Collision c) {
		// TODO Auto-generated method stub
		
		//c get particles for collision
		Particle[] p = c.getParticles();
		for(Particle x : p) {
			List<Collision> cs = new List<Collision>();
			cs = (List<Collision>) model.predictCollisions(x, clock);
			for(Collision y : cs) {
				queue.add(y);
			}
		}
		//add new collisions for each particle
		
	}

}
