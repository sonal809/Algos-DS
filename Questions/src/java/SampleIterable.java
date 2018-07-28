package java;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implementing iterable can be used by the foreach loop.
 * Iterable returns iterator which is used by the JVM to iterate over your objects
 * 
 * An Iterator is an object instance which remembers where it is up to in a collection of things. 
 * Each time you ask it, it will give you next thing in sequence.
 *  It will also tell you when it has run out of things.
 * @author sonaggarwal
 *
 * @param <T>
 */
public class SampleIterable<T> implements Iterable<T>{
	  T[] values;  // this contains the actual elements of the array
	  
	  public SampleIterable(T[] array) {
		  this.values = array;
	  }
	  
	@Override
	public Iterator<T> iterator() {
		return new SampleIterator();
	}
	
	private class SampleIterator implements Iterator<T> {
		int current = 0;
		@Override
		public boolean hasNext() {
			return this.current < values.length;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return values[current++];
		}

		@Override
		public void remove() {
			if (values.length > 0) {
				current--;
			}
		}

	
		
	}

}
