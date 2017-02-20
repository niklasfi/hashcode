package it.reply.hashcode.mgrs;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import it.reply.hashcode.input.beans.Problem;
import it.reply.hashcode.output.beans.Row;
import it.reply.hashcode.output.beans.Solution;

/**
 * @author d.cavassa
 *
 */
public class AlgorithmMgr implements Runnable {
	
	private final Problem problem;
	private int optimalScore = 0;
	private ScoreMgr g_scoreMgr = null; 
	private final Random randomGenerator = new Random(System.currentTimeMillis());
	private Solution best;
	
	public AlgorithmMgr(File inData) throws IOException{
		problem = new Problem(inData);
		g_scoreMgr = new ScoreMgr(); 
		best = problem.emptySolution();
	}
	
	public synchronized Random getRandom() {
		return new Random(randomGenerator.nextInt());
	}
	
	// Generates solutions
	public void run() {
		//TODO
	}//generateNextSolution
	

	public synchronized void setBestSolution(Solution solution) {
		best = solution;
	}
		
	
	private Solution destroy(Random r, Solution old, float percent) {
		Solution sol = new Solution(old);
		for(int n = (int)(percent * sol.problem.servers.size()); n > 0; --n){
			Row r = sol.rows.get(r.nextInt(sol.rows.size()));
		}
	}
	
	public Solution getBestSolution() {
		return new Solution(best);
	}//getSolution
	
}//Class AlgorithmMgr

