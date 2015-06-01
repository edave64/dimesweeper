package dimesweeper.neighborhoods;

import dimesweeper.INeighborhood;
import dimesweeper.positions.Position;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by EDave on 24.05.2015.
 */
public class Square implements INeighborhood {
	public final static Square instance = new Square ();

	private Square () {}

	@Override
	public Set<Position> getNeighborPositions (Position pos, int radius) {
		
		Set<Position> ret = new HashSet<> ();

		if (pos.isEmpty ()) { ret.add (Position.NIL); }
		else
		{
			for (Position subposition : getNeighborPositions (pos.getTail (), radius)) {
				for (int i = -radius; i <= radius; i++) {
					ret.add (subposition.prepend (pos.getHead () + i));
				}
			}
		}

		return ret;
	}
}
