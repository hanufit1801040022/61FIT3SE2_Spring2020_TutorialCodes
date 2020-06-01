package tuts.tut10.to_dos.adapter;

import tuts.tut10.to_dos.adapter.adapter.SquarePegAdapter;
import tuts.tut10.to_dos.adapter.round.RoundHole;
import tuts.tut10.to_dos.adapter.round.RoundPeg;
import tuts.tut10.to_dos.adapter.square.SquarePeg;

/**
 * Somewhere in client code...
 */
public class Demo {
	public static void main(String[] args) {
		//TO-DO: Create 2 instances of RoundHole and RoundPeg with same radius
		RoundHole roundHole = new RoundHole(10);
		RoundPeg roundPeg = new RoundPeg(10);
		
		//TO-DO: If RoundHole instance "fits" with RoundPeg instance => show a message
		if (roundHole.fits(roundPeg)) {
			System.out.println("IT FITS");
		}

		//TO-DO: Create 2 instances of SquarePeg with 2 different widths
		SquarePeg smallSqPeg = new SquarePeg(5);
		SquarePeg bigSqPeg = new SquarePeg(15);

		//Note: You can't make RoundHole instance "fit" with SquarePeg instance
		//Therefore, we need to use Adapter for solving the problem.
		
		//TO-DO: Create 2 corresponding instances of SquarePegAdapter  
		SquarePegAdapter smallAdapter = new SquarePegAdapter(smallSqPeg);
		SquarePegAdapter bigAdapter = new SquarePegAdapter(bigSqPeg);
		 
		//TO-DO: Check whether RoundHole instance "fit" or not "fit" with "small" RoundPeg instance 
		//then show a suitable message
		String fitMessage = "Ok, fits!";
		String unfitMessage = "Nah, not a fit!";
		System.out.println(roundHole.fits(smallAdapter) ? fitMessage : unfitMessage);
	 
		//TO-DO: Do similar with "big" RoundPeg instance
		System.out.println(roundHole.fits(bigAdapter) ? fitMessage : unfitMessage);
	}
}