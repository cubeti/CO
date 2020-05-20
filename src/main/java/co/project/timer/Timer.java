package co.project.timer;

/**
 * Implements the Itimer interface
 */
public class Timer implements ITimer {
	/**
	 * Uses Start_time to record the starting time
	 * Total_time to record the time after pausing
	 * Stop_time to record the stopping time
	 */
	private long Start_time=0;
	private long Total_time=0;
	private long Stop_time=0;

	/**
	 * starts the Start_time timer
	 */
	public void Start()
	{
		Start_time=System.nanoTime();
	}

	/**
	 * starts the Start_time timer after a resume
	 */
	public void resume()
	{
		Start_time=System.nanoTime();
	}

	/**
	 * calculates total time the program used the timer
	 * @return long Total time recorded by timer
	 */
	public long Stop()
	{
		
		Stop_time=System.nanoTime();
		return Stop_time-Start_time+Total_time;
	}

	/**
	 * calculates the time between the last Start/resume call and pause call
	 * @return time after the last Start/Resume
	 */
	public long pause()
	{
		Stop_time=System.nanoTime();
		Total_time=Total_time+Stop_time-Start_time;
		return Stop_time-Start_time;
	}
}
